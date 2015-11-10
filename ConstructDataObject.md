# Introduction #

The AndroidAnalyzer application provides `org.androidanalyzer.core.Data` AIDL file which is used to store the data, collected by the Plugins. It provides means for tree-like structuring of the Data with a root node, sub nodes and leaves, which represent actual values collected from the device that is analyzed.

# Details #

This chapter covers the specifics and best practices when creating Data structures. It will provide explanation how to set correctly the data in the Data objects.
There are a lot of constants specified in `org.androidanalyzer.Constants` class.
The following table will provide details about each of them:

| **Constant** | **Usage** |
|:-------------|:----------|
| `NODE_STATUS_OK` | This is the default value of the Data status. Whenever an error occurs during retrieval there are other constants that have to be used |
| `NODE_STATUS_FAILED` | This indicates Data status, when data retrieval did not complete as expected |

These two constants are to be set as status of the Data object via `Data.setStatus(String)` method. _Note: Status is set to `NODE_STATUS_OK` by default, and if no errors occur, calling `setStatus()` is optional._

| **Constant** | **Usage** |
|:-------------|:----------|
| `NODE_STATUS_FAILED_UNAVAILABLE_API` | Denoting that used API is not available for this device |
| `NODE_STATUS_FAILED_UNAVAILABLE_VALUE` | Denoting that used API is available, but returned wrong or no value at all |
| `NODE_STATUS_FAILED_UNKNOWN` | Denoting that failure reason is not any of the above. Though there might be cases where this constant have to be used, Plugin developers are very much encouraged to avoid using it and make their best to locate the failure reasons |

These three constants are to be set as Data value via `Data.setValue(Object)` method when for some reason data retrieval has failed.

By default Data object treats its value as of `String` type. In the cases where the value to be set is of different type, this has to be set explicitly using
`Data.setValueType(String)` method. Otherwise exception for incorrect value type will be thrown. Here are some pre-defined constants for the supported types:

| **Constant** | **Usage** |
|:-------------|:----------|
| `NODE_VALUE_TYPE_STRING` | (**default**) Denotes value of the Data is `String` |
| `NODE_VALUE_TYPE_INT` | Denotes value of the Data is `Integer` |
| `NODE_VALUE_TYPE_LONG` | Denotes value of the Data is `Long` |
| `NODE_VALUE_TYPE_DOUBLE` | Denotes value of the Data is `Double`. It is advisable to round the double values to the smallest fraction presentation that makes sense |
| `NODE_VALUE_TYPE_BOOLEAN` | Denotes value of the Data is `Boolean` |
| `NODE_VALUE_TYPE_DATA` | (**default**) Denotes that value of the Data is another `Data` object. This is usually the case when children nodes are added to the parent. Android Analyzer handles this case automatically |

Ordinal values should have metrics, especially if they match any of the already defined ones. Data value metrics is set via `Data.setValueMetrics(String)` method.

| **Constant** | **Usage** |
|:-------------|:----------|
| `NODE_INPUT_SOURCE_AUTOMATIC` | (**default**) Denotes that data was retrieved automatically with a testcase |
| `NODE_INPUT_SOURCE_MANUAL` | Denotes that data collected is provided by the user |

These values are set via `Data.setInputSource(String)` method and if data is collected with a testcase, setting input source is handled by the AnalyzerCore automatically.

| **Constant** | **Usage** |
|:-------------|:----------|
| `NODE_CONFIRMATION_LEVEL_TEST_CASE_CONFIRMED` | (**default**) Denotes that data si collected by a testcase |
| `NODE_CONFIRMATION_LEVEL_USER_CONFIRMED` | Denotes that data has been manually input by the user |
| `NODE_CONFIRMATION_LEVEL_UNCONFIRMED` | Denotes that collected data cannot be confirmed. Usually this is data that is provided from manual input source |

Confirmation level is set via `Data.setConfirmationLevel(String)` method and should be used when collected data is confirmed by user or cannot be confirmed.