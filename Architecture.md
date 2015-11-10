Android Analyzer consists of the following high-level components:
  * Analyzer Core - takes care of plugin discovery, analysis and reporting flow. Plugins are discovered by the Analyzer Core, which exposes a plugin API, through which plugins are initialized, invoked and the results are collected
  * Plugin - plugins analyze on or more specific capabilities and report back the data to the Analyzer Core. Plugins can be delivered as part of the main Android Analyzer APK, but can also be deployed via standalone APKs and invoked via AIDL, as long as they follow the discovery mechanism. This approach adds more flexibility to third-parties, which may want to develop their own plugins, that analyze specific functionality not covered by the open source effort.
  * Reporter - reports the collected data to the backend. Different implementations are possible, but initially the goal is to have an implementation, which will deliver the data in JSON format via HTTP

Detailed software architecture document can be found in the source repository at http://code.google.com/p/android-analyzer/source/browse/trunk/docs/SAD_AndroidAnalyzer_EN.doc

Any comments or ideas are very much welcome!