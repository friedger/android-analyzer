This plugin collects data on available device sensors.

**Plugin Name:** Sensor Plugin

**Class Name:** `org.androidanalyzer.plugins.sensor.SensorPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Sensor   |          |          |           |            |
|          | Accelerometer |          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_ACCELEROMETER).isEmpty()` |
|          | Proximity|          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_PROXIMITY).isEmpty()` |
|          | Gyroscope|          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_GYROSCOPE).isEmpty()` |
|          | Light    |          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_LIGHT).isEmpty()` |
|          | Orientation|          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_ORIENTATION).isEmpty()` |
|          | Pressure |          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_PRESSURE).isEmpty()` |
|          | Temperature|          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_TEMPERATURE).isEmpty()` |
|          | Magnetic field|          | _boolean_ (Y, N) |            | `!SensorManager.getSensorList(TYPE_MAGNETIC_FIELD).isEmpty()` |
|          | Sensor-`<x>`|          |           |            |
|          |          | Type     | _integer_ |            | `Sensor.getType()`   |
|          |          | Type name | _string_  |            | `Sensor.getType()`. Present only if it is one of the known types |
|          |          | Name     | _string_  |            | `Sensor.getName()`   |
|          |          | Vendor   | _string_  |            | `Sensor.getVendor()` |
|          |          | Version  | _integer_ |            | `Sensor.getVersion()` |
|          |          | Power    | _double_  |            | `Sensor.getPower()`  |
|          |          | Resolution | _double_  | _SU_       | `Sensor.getResolution()` |
|          |          | Maximum range | _double_  | _SU_       | `Sensor.getMaximumRange()` |

Note: _SU_ denotes a _Sensor Unit_ metric, which has no standard absolute scale and is specific to every sensor implementation and every sensor property
Note: for each present sensor a separate Sensor-`<x>` node is created, `<x>` starting from 0.