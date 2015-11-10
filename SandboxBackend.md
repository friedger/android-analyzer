# Purpose #
A dedicated backend server allows plugin developers to create, test, inspect and fine-tune plugin output within a sandbox environment. This way, temporary results generated during development will not intertwine with the real device data posted to the production server at http://AndroidFragmentation.com

# Usage #
The Sandbox Backend runs on http://212.95.166.45:8080. The new functionality of the production server will be staged at the Sandbox Backend first, so new features will be applied all across the site for the plugin developers to get acquainted first. However, on the Sandbox Backend the data in the news, forums and database sections will always be considered as **temporary test data** and will be deleted periodically. Therefore, please **do not** use the Sandbox Backend to post anything other than test content.

The link to the device database section on the Sandbox Backend is:
http://212.95.166.45:8080/af/database

To make a developer's life easier the default configuration in the SVN will always point to the Sandbox Backend, as well as any intermediary binary releases. This way the developer is not required to change the URL each time. Public, major releases and the ones published on the Android Market will always come with the production backend pre-configured.