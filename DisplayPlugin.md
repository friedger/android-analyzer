The API plugin collects data on available displays and their capabilities

**Plugin Name:** Display Plugin

**Class Name:** `org.androidanalyzer.plugins.display.DisplayPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Displays |          |          |          |           |            |
|          | Display-`<x>` |          |          |           |            |                      |
|          |          | Location |          | _string_ (e.g. "front", "back") |            | Unknown, N/A         |
|          |          | Horizontal resolution |          | _integer_ | pixel      | `DisplayMetrics.widthPixels` |
|          |          | Vertical resolution |          | _integer_ | pixel      | `DisplayMetrics.heightPixels` |
|          |          | Density  |          |           |            |                      |
|          |          |          | Logical  | _integer_ | dpi        | `DisplayMetrics.density` |
|          |          |          | Logical DPI | _integer_ | dpi        | If API>=4 `DisplayMetrics.densityDPI` |
|          |          |          | Scaled   | _integer_ | dpi        | `DisplayMetrics.scaledDensity` |
|          |          |          | Horizontal | _integer_ | dpi        | `DisplayMetrics.xdpi` |
|          |          |          | Vertical | _integer_ | dpi        | `DisplayMetrics.ydpi` |
|          |          | Display size |          | _double_ (e.g. 3.7) | inch       | Unknown, but we could use xdpi, ydpi and dpi to calculate the size diagonal |
|          |          | Display technology |          | _string_ (e.g. AMOLED, etc.) |            | Unknown, N/A         |
|          |          | Touch support |          | _boolean_ (e.g. Y, N) |            | Unknown, N/A         |
|          |          | Touch method |          | _string_ (Finger, Stylus, Unknown) |            | `android.content.res.Configuration` |
|          |          | Color depth |          | _integer_ (e.g. 16, 32) | bit        | Unknown, N/A         |
|          |          | Refresh rate |          | _integer_ (e.g. 60, 65) | fps        | display.getRefreshRate() |

Note: for each present display a separate Display-`<x>` node is created, `<x>` starting from 0.