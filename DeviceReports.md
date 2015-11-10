# Report Structure #
Each device report consists of many nodes and sub-nodes of data, that will be sent to the backend. Both the Analyzer Core and the backend don't necessarily care about or validate the data structure, as we try to keep them data-agnostic and flexible as much as possible. However, both plugin developers and end users do care about the contents and the structure, since this is what is being presented to the user ultimately.

This is a [sample report](http://android-analyzer.googlecode.com/svn/trunk/docs/Sample%20Device%20Data%20Report.htm) structure that will be generated. **Note that the values presented in the sample file are random** and are presented just to give a clue about what a device report actually is. Once we generate our first real reports we will add some more real-world samples as well.

| **Node** | **Node** | **Node** | **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Root     |          |          |          |          |          |           |            |                      |
|          | Data     |          |          |          |          |           |            |                      |
|          |          | `<`Node`>` |          |          |          |           |            |                      |
|          |          | ......   |          |          |          |           |            |                      |
|          |          | `<`Node`>` |          |          |          |           |            |                      |
|          | Metadata |          |          |          |          |           |            |                      |
|          |          | Analyzer |          |          |          |           |            |                      |
|          |          |          | Version  |          |          | _string_  |            |Format is: Major.Minor.Micro |
|          |          | Plugins  |          |          |          |           |            |                      |
|          |          |          | Plugin-`<x>`|          |          |           |            |                      |
|          |          |          |          | Human name |          | _string_  |            | Human-readable name of the plugin|
|          |          |          |          | Class name |          | _string_  |            | this.getClass().getName() |
|          |          |          |          | Version  |          | _string_  |            | Format is: Major.Minor.Micro |
|          |          |          |          | Vendor   |          | _string_  |            | Free text            |
|          |          |          |          | Status   |          | _boolean_ (e.g. Y, N) |            | If failed then "Failure details" node is available |
|          |          |          |          | Failure details |          | _string_  |            | Returned by the plugin |
|          |          | Manufacturer |          |          |          | _string_  |            | _Build.class.getDeclaredField("MANUFACTURER")_ or _Build.PRODUCT_ as a fallback|
|          |          | Firmware version |          |          |          | _string_  |            | _Build.VERSION.RELEASE_ |
|          |          | Operator |          |          |          | _string_  |            | _TelephonyManager.getNetworkOperatorName()_ |
|          |          | Device ID Hash |          |          |          | _string_  | MD5H       | Calculate hash code of TelephonyManager.getDeviceId().getBytes() |
|          |          | Model    |          |          |          | _string_  |            | _Build.MODEL_        |
|          |          | Date     |          |          |          | _string_  |Timestamp   | Format is: yyyy/MM/dd HH:mm:ss |
|          |          | Android API Level |          |          |          | _integer_ |            | `System.getProperty(android.os.Build.VERSION)` |


For further details about **< Node >** structure please see [Plugins](Plugins.md) section.

# Report File Format #
Android Analyzer's architecture is report format-agnostic, so that 3rd-party reporting implementation can be developed. However, the default format and transport supported is JSON over HTTP.

The report is a tree-like data structure, which is exported as a JSON file. This is a [sample report](http://code.google.com/p/android-analyzer/source/browse/trunk/docs/sample_device_data_report_json_formatted.txt) just to give a clue about the structure. Some real data from different devices: [Archos](http://code.google.com/p/android-analyzer/source/browse/trunk/docs/aa_dump_archos.txt), [Desire Froyo](http://code.google.com/p/android-analyzer/source/browse/trunk/docs/aa_dump_desire_froyo.txt), [G1](http://code.google.com/p/android-analyzer/source/browse/trunk/docs/aa_dump_G1.txt), [Milestone](http://code.google.com/p/android-analyzer/source/browse/trunk/docs/aa_dump_milestone.txt)