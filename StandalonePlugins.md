# Overview #

The AndroidAnalyzer supports AnalyzerPlugin discovery when plugin is deployed in its own .apk file by design.


# Details #

In general there is no difference in the way plugin collects its data. The plugin provider has to comply with the following requirements:

  1. Include the AndroidAnalyzer AIDL files in the application.
  1. Either implement IAnalyzerPlugin.Stub or copy AbstractPlugin class from the AndroidAnalyzer application and implement the plugin on top of it
  1. Register your plugin in the PluginRegistry (Note: this is not required if you implement on top of AbstractPlugin).

There are some benefits using AbstractPlugin instead of implementing IAnalyzerPlugin.Stub:
  1. AbstractPlugin handles connection to PluginRegistry service, so plugin developer's don't have to bother about it.
  1. AbstractPlugin provides an Android Service that eases the communication between the core and the plugins. Otherwise plugin developer has to handle this on his own.