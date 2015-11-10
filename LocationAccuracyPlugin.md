This plugin benchmarks the accuracy of the positioning technology.

**Plugin Name:** Location Accuracy Plugin

**Class Name:** `org.androidanalyzer.plugins.locationaccuracy.LocationAccuracyPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Location Accuracy  |          |          |           |            |                      |
|          | Test ID  |          | _integer_ (eg. 1) |            | Unknown, N/A         |
|          | App Version |          | _string_ (eg. 0.9.119) |            | Unknown, N/A         |
|          | Start Time |          | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |
|          | End Time |          | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |
|          | Time To First Fix |          | _double_  | second     | Unknown, N/A         |
|          | Location Provider |          | _double_  | second     | Unknown, N/A         |
|          | Sample Size |          | _double_  | second     | Unknown, N/A         |
|          | Horizontal Error |          |           |            |                      |
|          |          | Min      | _double_  | meter      | Unknown, N/A         |
|          |          | Max      | _double_  | meter      | Unknown, N/A         |
|          |          | Mean     | _double_  | meter      | Unknown, N/A         |
|          |          | 50th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | 68th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | 95th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | Standard Deviation | _double_  | meter      | Unknown, N/A         |
|          | Vertical Error |          |           |            |                      |
|          |          | Min      | _double_  | meter      | Unknown, N/A         |
|          |          | Max      | _double_  |  meter     | Unknown, N/A         |
|          |          | Mean     | _double_  | meter      | Unknown, N/A         |
|          |          | Mean Absolute  | _double_  |            | Unknown, N/A         |
|          |          | 50th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | 68th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | 95th Percentile | _double_  | meter      | Unknown, N/A         |
|          |          | RMSE     |           | meter      | Unknown, N/A         |
|          |          | Standard Deviation | _double_  | meter      | Unknown, N/A         |
|          |  Estimated Horizontal Accuracy Error |          |           |            |                      |
|          |          | Min      | _double_  | meter      | Unknown, N/A         |
|          |          | Max      | _double_  | meter      | Unknown, N/A         |
|          |          | Mean     | _double_  | meter      | Unknown, N/A         |
|          |          | Mean Absolute  | _double_  |            | Unknown, N/A         |
|          |          | 50th Percentile| _double_  | meter      | Unknown, N/A         |
|          |          | 68th Percentile| _double_  | meter      | Unknown, N/A         |
|          |          | 95th Percentile| _double_  | meter      | Unknown, N/A         |
|          |          | RMSE     | _double_  | meter      | Unknown, N/A         |
|          |          | Standard Deviation| _double_  | meter      | Unknown, N/A         |
|          | First Fix Time |          | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |
|          | Sampling |          |           |            |                      |
|          |          | Interval  | _double_  | millisecond | Unknown, N/A         |
|          |          | Distance  | _double_  | meter      | Unknown, N/A         |
|          | Average Time Between Fixes |          | _double_  | second     | Unknown, N/A         |
|          | Override Refresh Rate |          |  _boolean_ (Y, N) |            | Unknown, N/A         |
|          | Keep Screen On |          | _boolean_ (Y, N)  |            | Unknown, N/A         |
|          | Time Injected |          |           |            |                      |
|          |          | Time Data  | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |
|          |          | XTRA Data  | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |
|          | Time Cleared Assist Data |          | _string_  | (date) MM/dd/yyyy HH:mm | Unknown, N/A         |

**Privacy policy: this plugin MUST NEVER report the device location to the backend. Querying device location for determining positioning method accuracy is allowed, as long as this data never leaves the device.**

## Integration with GPSBenchmark ##
In order to produce meaningful data this plugin requires [GPSBenchmark](http://gpsbenchmark.com) app to be installed. GPSBenchmark must be run at least once prior to running Android Analyzer in order to store the accuracy data in the report. When the GPSBenchmark analysis completes the user needs to choose to send the benchmark data to Android Analyzer (opposed to e.g. sending it via mail). The latest data received by the Location Accuracy Plugin will be stored internally and then converted to the report structure above.

The Location Accuracy Plugin will handle Intent with name `org.androidanalyzer.plugins.locationaccuracy.gpsbenchmark`. The Intent will carry the extra data in the form of hashmap stored with the key `gpsbenchmark`, like this:
`gpsBenchmarkIntent.putExtra("gpsbenchmark", hashmap)`

The following table defines a mapping between keys received via Intent extra data from GPS Benchmark application (right column) and how they structured as nodes in the report.

| **Intent Key** | **Report Node** | **Parent Node** |
|:---------------|:----------------|:----------------|
| testID         | Test ID         | Location Accuracy |
| AppVersion     | Application Version | Location Accuracy |
| startTime      | Start Time      | Location Accuracy |
| endTime        | End Time        | Location Accuracy |
| TimeToFirstFix(s) | Time To First Fix | Location Accuracy |
| locationProvider | Location Provider | Location Accuracy |
| sampleSize     | Sample Size     | Location Accuracy |
| HorizontalErrorMin(m) | Min             | Horizontal      |
| HorizontalErrorMax(m) | Max             | Horizontal      |
| HorizontalErrorMean(m) | Mean            | Horizontal      |
| HorizontalError50thPercentile(m) | 50th Percentile | Horizontal      |
| HorizontalError68thPercentile(m) | 68th Percentile | Horizontal      |
| HorizontalError95thPercentile(m) | 95th Percentile | Horizontal      |
| HorizontalErrorStandardDeviation(m) | Standard Deviation | Horizontal      |
| VerticalErrorMin(m) | Min             | Vertical        |
| VerticalErrorMax(m) | Max             | Vertical        |
| VerticalErrorMean(m) | Mean            | Vertical        |
| VerticalErrorMeanAbsolute | Mean Absolute   | Vertical        |
| VerticalError50thPercentile(m) | 50th Percentile | Vertical        |
| VerticalError68thPercentile(m) | 68th Percentile | Vertical        |
| VerticalError95thPercentile(m) | 95th Percentile | Vertical        |
| VerticalErrorRMSE(m) |RMSE             | Vertical        |
| VerticalErrorStandardDeviation(m) | Standard Deviation | Vertical        |
| EstimatedHorAccuracyErrorMin(m) | Min             | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyErrorMax(m) | Max             | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyErrorMean(m) | Mean            | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyErrorMeanAbsolute | Mean Absolute   | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyError50thPercentile(m) | 50th Percentile | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyError68thPercentile(m) | 68th Percentile | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyError95thPercentile(m) | 95th Percentile | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyErrorRMSE(m) | RMSE            | Estimated Horizontal Accuracy Error |
| EstimatedHorAccuracyErrorStandardDeviation(m) | Standard Deviation | Estimated Horizontal Accuracy Error |
| FirstFixTime   | 	First Fix Time | Location Accuracy |
| SamplingInterval(ms) | 	Interval       | Sampling        |
| SamplingDistance(m) | 	Distance       | Sampling        |
| AverageTimeBetweenFixes(s) | Average Time Between Fixes | Location Accuracy |
| OverrideRefreshRate | Override Refresh Rate | Location Accuracy |
| KeepScreenOn   | 	Keep Screen On | Location Accuracy |
| TimeInjectedTimeData | Time Data       | Time Injected   |
| TimeInjectedXTRAData | XTRA Data       | Time Injected   |
| TimeClearedAssistData | Time Cleared Assist Data | Location Accuracy |