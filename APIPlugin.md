The API plugin collects data on available Android and Google APIs and their versions.

**Plugin Name:** API Plugin

**Class Name:** `org.androidanalyzer.plugins.api.APIPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:---------------------|
| API      |          |          |           |                      |
|          | Android API Level |          | _integer_ | `System.getProperty(android.os.Build.VERSION)` |
|          | Google   |          |           |                      |
|          |          | Google Maps Application | _boolean_ | `PackageManager.getActivityInfo(new ComponentName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity"))` |