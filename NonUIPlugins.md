# Overview #

Non-UI plugins can be implemented based on AbstractPlugin class that is provided by the AndroidAnalyzer project as a convenience Android service that implements the IAnalyzerPlugin AIDL.


# Details #

The following step-by-step guide assumes that plugin developer will base his plugin on top of the AbstractPlugin that comes with the AndroidAnalyzer project. At the end of the guide, differences implementing the AIDL on your own will be listed.
  1. Define class that extends `org.androidanalyzer.plugins.AbstractPlugin`
  1. Define constants for the static plugin metadata like name, vendor, description, version, etc.
```
  private static final String PLUGIN_NAME = "Device Info Plugin";
  private static final String PLUGIN_DESCRIPTION = "Collects data on general device properties";
  private static final String PLUGIN_VERSION = "1.0.0";
  private static final String PLUGIN_VENDOR = "ProSyst Software GmbH";
```
  1. Implement the abstract methods
  1. Define constants for the Data keys, system properties (if any) that will be read during data collection
```
  /**
   * Root node
   */
  private static final String DEVICE_NODE = "Device";

  /**
   * 1st level node
   */
  private static final String PRODUCT_NODE = "Product";

  /**
   * 1st level node
   */
  private static final String FIRMWARE_NODE = "Firmware";
  
  private static final String BUILD_PROPERTIES_FILE = "/system/build.prop";
  
  private static final String BASEBAND_VERSION_PROP = "gsm.version.baseband";
```
  1. For certain values that is known that are not available in older versions of the API use reflection, thus your code still can run on all platforms, and obtain the value where it is available.
```
  private String getDeviceManufacturer() {
    String mfg = Constants.NODE_VALUE_UNKNOWN;
    try {
      // using reflection
      Field manufacturerField = Build.class.getDeclaredField(MANUFACTURER_FIELD);
      manufacturerField.setAccessible(true);
      Object myManufacturer = manufacturerField.get(null);
      mfg = String.valueOf(myManufacturer);
    } catch (Exception ex) {
      mfg = Build.PRODUCT;
      Logger.WARNING(TAG, "Could not get Manufacturer!" + ex.getMessage(), ex);
    }
    return mfg;
  }  
```
  1. Structure data collection in separate methods, each one responsible for reading specific part of information (e.g firmware data, product data). Avoid constructing all data structure in the getData method of the plugin. Use small methods, this will improve code maintainance and readability.
  1. Data collection should not block or fail with unhandled exceptions.  Whenever data retrieval may fail, this should be properly set in the returned Data objects by setting correct status and value of the respective nodes.
```
  private Data getDeviceHardware() {
    Data bData = new Data();
    try {
      bData.setName(HARDWARE_NAME);
      if (isApiAvailable(8)) {
        String hardware = Constants.NODE_VALUE_UNKNOWN;
        Field hwField = Build.class.getDeclaredField(HARDWARE_FIELD);
        hwField.setAccessible(true);
        Object myHardware = hwField.get(null);
        hardware = String.valueOf(myHardware);
        bData.setValue(hardware);
      } else {
        bData.setValue(Constants.NODE_STATUS_FAILED_UNAVAILABLE_API);
        bData.setStatus(Constants.NODE_STATUS_FAILED);
        bData.setValueType(Constants.NODE_VALUE_TYPE_STRING);
      }
    } catch (Throwable t) {
      Logger.WARNING(TAG, "Could not get Hardware: "+t.getMessage(), t);
    }
    return bData;
  }
```
  1. Time consuming operations should be run in separate threads with means to forcibly stop them after a timeout expires.
  1. If certain operations or values are known that are not available for API Levels below certain number, plugin implemetor is advised to check API level before executing the operation and handle the result if it is not supported. AbstractPlugin.getAPIversion() is a convinience method to easily check API level. (For example see method `getDeviceHardware()` listed above.
  1. When all data is collected, merge results in a single `Data` object, with tree structure matching the table created.
```
  protected Data getData() {
    Data device = new Data();
    try {
      device.setName(DEVICE_NODE);
    } catch (Exception e) {
      Logger.ERROR(TAG, "Error creating device node: "+e.getMessage(), e);
      status = "Could not create Device root node";
      return null;
    }
    ArrayList<Data> subnodes = new ArrayList<Data>();
    try {
      Data product = new Data();
      product.setName(PRODUCT_NODE);
      ArrayList<Data> productData = readProductData();
      addToParent(product, productData);
      subnodes.add(product);
    } catch (Throwable t) {
      Logger.ERROR(TAG, "Error creating product subnodes: "+t.getMessage(), t);
      status = "Could not create Product subnode";
    }
    try {
      Data firmware = new Data();
      firmware.setName(FIRMWARE_NODE);
      ArrayList<Data> firmwareData = readFirmwareData();
      addToParent(firmware, firmwareData);
      subnodes.add(firmware);
    } catch (Throwable t) {
      Logger.ERROR(TAG, "Error creating firmware subnodes: "+t.getMessage(), t);
      status = "Could not create Firmware subnode";
    }
    addToParent(device, subnodes);
    return device;
  }
```
  1. Use `Service.stopSelf()` method to abort data collection when core explicitly requests data collection abortion.