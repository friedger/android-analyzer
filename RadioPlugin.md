This plugin collects data on the radio interface and capabilities.

**Plugin Name:** Radio Interfaces Plugin

**Class Name:** `org.androidanalyzer.plugins.radiointerfaces.RadioInterfacesPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Radio Interfaces|          |          |          |           |            |                      |
|          | Supported |          |          | _boolean_ (Y, N) |            | `TelephonyManager.getPhoneType() != TelephonyManager.PHONE_TYPE_NONE`|
|          | Phone Type |          |          | _string_ (_GSM_, _CDMA_) |            | Convert `TelephonyManager.getPhoneType()` into string |
|          | Bands    |          |          | _string_ (comma-separated list of values _850_, _900_, etc.) | MHz        | Unknown, N/A         |
|          | Current Network |          |          |           |            |                      |
|          |          | Type     |          | _string_ (_1xRTT_, _CDMA_, _EDGE_, _EVDO\_0_, _EVDO\_A_, _GPRS_, _HSDPA_, _HSPA_, _HSUPA_, _IDEN_, _UMTS_, _Unknown_  ) |            | Convert `TelephonyManager.getNetworkType()` into string |
|          |          | Band     |          | _string_ (value of _850_, _900_, etc.) | MHz        | Unknown, N/A         |


