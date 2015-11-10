# Overview #

This page aims to cover the different aspects of AnalyzerPlugins and provide rich technical advise on implementing them.

# Details #

By design the AndroidAnalyzer application supports two types of plugins: UI and non-UI.

UI plugins have a visual part which usually interacts with the user and expects some feedback from him (e.g text bounces on the screen, and user has to confirm he has seen and read it).

On the other hand non-UI plugins collect data without the user consent.

Another aspect of the implementation of a plugin is where it resides: is it part of the AndroidAnalyzer application or it is implemented as a separate Android application.

The following table provides more details about the specifics of implementing AnalyzerPlugins:

| **Topic** | **Description** |
|:----------|:----------------|
| [Non-UI Plugins](NonUIPlugins.md) | Provides the basics that have to be implemented for every plugin. |
| [UI Plugins](UIPlugins.md) | Covers the differences from Non-UI Plugins. |
| [Standalone Plugins](StandalonePlugins.md) | Covers the differences when plugins is provided as standalone Android application |
| [How to register a plugin?](PluginRegistry.md) | Provides the steps how a plugin should be registered in the Plugin Registry, so the AnalyzerCore will be aware of its presence |