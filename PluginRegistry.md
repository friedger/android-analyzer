# Overview #

This page will cover the registration mechanism of the Analyzer plugins. It will give short guidelines how to make a plugin discoverable by the AnalyzerCore.

# Details #

At initialization time the AnalyzerCore broadcasts an Intent, that the available plugins should listen for, and upon receiving the Intent, they have to report back to the PluginRegistry service, thus they get registered.
In order to receive the broadcast Intent, each plugin has to implement a `andriod.content.BroadcastReceiver` and register it in the `AndroidManifest` with the following `<intent-filter>`:
```
        <receiver android:enabled="true"
              android:exported="true"
              android:label="device info plugin receiver"
              android:name=".plugins.device.BReceiver" >
               <intent-filter>
                    <action android:name="org.androidanalyzer.plugins.discovery" />
                </intent-filter>
        </receiver>
```
The broadcast receiver on its turn, issues an Intent that is hanlded by `org.androidanalyzer.plugins.AbstractPlugin` which on his behalf connects to the PluginRegistry and registers the plugin in it.
In order to have your plugin visible for the Android OS, it has to be declared as service in the AndroidManifest like this:
```
        <service android:name=".plugins.device.DeviceInfoPlugin" android:process=":aanalyzer_plugins">
            <intent-filter>                                                 
              <action android:name="org.androidanalyzer.plugins.device.DeviceInfoPlugin"  />
            </intent-filter>
        </service>
```
Otherwise a Service Not Found exception will be thrown.