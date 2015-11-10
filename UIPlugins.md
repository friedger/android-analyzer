# Introduction #

UI Plugins are AnalyzerPlugins that present the user with some visual components and prompt him to input his feedback.

# Details #

Since UI Plugins expect user input, they are executed prior to the non-visual ones. For that purpose there is a sorting mechanism implemented in the AnalyzerCore, which examines the list of registered plugins before analysis and puts the UI ones to be first.

In order for the core to recognize a plugin as UI one, plugin has to return `true` in his `isPluginUIRequired()` method.
For example:
```
  @Override
  public boolean isPluginUIRequired() {
    return true;
  }
```

Another specific for the visual plugins is that they need to handle timeouts even more precisely since they are based on the user feedback.

Basically the implementation flow is as follows:
  * Plugin launches UI on start of the analysis
  * Plugin blocks until the UI is visible and user hasn't provided any input _(e.g Screen shows red bouncing ball and user is asked whether he sees it bouncing and/or it is red)_
  * Data objects that are the result of plugin execution are constructed based on the values that the UI returned for the user input