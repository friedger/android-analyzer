Collects general device info like manufacturer, model and brand. Also provides details on the firmware, kernel and baseband versions.

**Plugin Name:** Device Info Plugin

**Class Name:** `org.androidanalyzer.plugins.device.DeviceInfoPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:---------------------|
| Device   |          |          |           |                      |
|          |Product   |          |           |                      |
|          |          | Manufacturer name | `String ` (e.g HTC)| read via reflection the value of `android.os.Build.MANUFACTURER` key                   |
|          |          | Device model | `String` (e.g Milestone) | read value of `android.os.Build.MODEL` key |
|          |          | Device brand | `String` (e.g MOTO\_VFDE) | read value of `android.os.Build.BRAND` key |
|          |          | Device hardware | `String`  | read value of `android.os.Build.HARDWARE` key (_Note: This is available since API Level 8_)|
|          | Firmware |          |           |                      |                      |
|          |          | Firmware version | `String` (e.g 2.1-update1) | read value of `android.os.Build.VERSION.RELEASE` key |
|          |          | Firmware configuration version | `String`  |(_Optional_) read value of **ro.build.config.version** system property |
|          |          | Kernel version raw | `String`  |read content of **proc/version** file |
|          |          | Kernel version | `String`  | use REGEX to format the value of **Kernel version raw** by stripping some of the info |
|          |          | Baseband version | `String`  | read value of **gsm.version.baseband** system property |
|          |          | Baseband configuration version | `String`  | (_Optional_) read value of **ro.gsm.flexversion** system property |
|          |          | Build number | `String`  | read value of `android.os.Build.DISPLAY` key |
|          |          | Build fingerprint | `String`  |read value of **ro.build.fingerprint** system property |
|          |          | Bootloader version | `String`  |read value of `android.os.Build.BOOTLOADER` key (_Note: This is available since API Level 8_)|