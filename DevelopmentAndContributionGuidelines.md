# Overview #

This page provides guidelines about the process of development and contribution of AnalyzerPlugins.

# Details #

There are already some steps defined which describe the process of creating and submitting plugins. Here are the main ones:
  * New plugin is proposed in the tracker.
  * Plugin proposal is discussed and approved by the project owners.
  * Page for the plugin is created [here](Plugins.md). The page must contain detailed specification of the plugin design:
    * Tree-like structure of the data that will be collected (hierarchy of nodes, subnodes, leaves ). An example is available [here](DeviceInfoPlugin.md)
    * Metrics of the collected ordinal values
    * Methods for retrieving data
    * Data structure must be future-proof, though the initial version of the plugin may not implement it entirely
  * Plugin design is approved by the project owners
  * Timeline and assignments are discussed.
  * When plugin is implemented, another person is assigned to make code review and post relevant tracker issues, that are ultimately fixed/addressed.

When all of the above steps are completed, the ready plugin is integrated in the AndroidAnalyzer application and is distributed with the next release.