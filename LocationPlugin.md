This plugin collects data on available positioning methods.

**Plugin Name:** Location Plugin

**Class Name:** `org.androidanalyzer.plugins.location.LocationPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Node** | **Value** | **Retrieval Method** |
|:---------|:---------|:---------|:---------|:----------|:---------------------|
| Location |          |          |          |           |                      |
|          | GPS      |          |          |           |                      |
|          |          | GPS supported |          |_boolean_ (Y, N) | `LocationManager.getAllProviders().contains("gps")`  |
|          |          | A-GPS supported |          |_boolean_ (Y, N) | `Settings.Secure.getInt(this.getContentResolver(), ASSISTED_GPS_ENABLED) != 0` |
|          | Network-based |          |          |           |                      |
|          |          | Supported |          | _boolean_ (Y, N) | `LocationManager.getAllProviders().contains("network")` |

**Privacy policy: this plugin MUST NEVER report the device location to the backend. Querying device location for determining positioning method accuracy is allowed, as long as this data never leaves the device.**