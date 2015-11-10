This plugin collects data on various web browser application and engine capabilities.

**Plugin Name:** Browser Plugin

**Class Name:** `org.androidanalyzer.plugins.browser.BrowserPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Node** | **Value** | **Retrieval Method** |
|:---------|:---------|:---------|:---------|:----------|:---------------------|
| Browser  |          |          |          |           |                      |
|          | WebKit   |          |          |           |                      |
|          |          | User agent |          | `String`  | `android.webkit.WebSettings.getUserAgentString()`  |

**Privacy policy: this plugin MUST NEVER report the browser history, cookies, stored input, certificates or any private data.**