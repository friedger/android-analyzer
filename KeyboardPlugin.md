This plugin collects data on present keyboard(s) and physical keys.

**Plugin Name:** Keyboard Plugin

**Class Name:** `org.androidanalyzer.plugins.keyboard.KeyboardPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:---------------------|
| Keyboard |          |          |           |                      |
|          | Hard keyboard |          | _string_ (Custom keys, Numeric pad, QWERTY, Unknown) | `!Resources.Configuration.keyboard` |
|          | Navigation|          | _string_ (Directional pad, No navigation, Trackball, Wheel, Unknown) | `!Resources.Configuration.navigation` |
|          | Hard key -`x`|          |           |                      |
|          |          | Name     | _string_  | (to be defined)      |

Note: for each present hard key a separate Hard key-`<x>` node is created, `<x>` starting from 0.

Soft keyboards are not listed as they can added and removed easily and often by the user.

Maybe this plugin could also recover the ability to connect an external keyboard or remote control through cable or bluetooth.