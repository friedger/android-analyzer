This plugin collects information on the device's main CPU.

**Plugin Name:** CPU Plugin

**Class Name:** `org.androidanalyzer.plugins.cpu.CPUPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| CPU      |          |          |           |            |                      |
|          | Manufacturer |          | _string_  |            | If the architecture is ARM parse the `/proc/cpuinfo` file for the manufacturer code in line starting with _CPU implementer_ (see below) |
|          | Instruction Set |          | _string_  |            | `System.getProperty(OS_ARCH)` |
|          | Name     |          | _string_  |            | Parse the `/proc/cpuinfo` file for the processor name code in line starting with _Processor_ |
|          | Operational Frequency |          | _double_  | MHz        | Read the `/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq` file and divide by 1000 to get MHz |
|          | Cores    |          | _int_     |            | Parse `/proc/cpuinfo` file. Number of cores is detected by the count _Processor_ line that occur in the file |
|          | CPU Revision |          | _int_     |            | Parse `/proc/cpuinfo` file for the line _CPU revision_. |
|          | CPU Variant |          | _int_     |            | Parse `/proc/cpuinfo` file for the line _CPU variant_. |
|          | Features |          | _string_  |            | Parse `/proc/cpuinfo` file for the line _Features_. Value represents list of CPU's features. |
|          | Hardware |          | _string_  |            | Parse `/proc/cpuinfo` file for the line _Hardware_. Represents the manufacturing technology of the CPU |
|          | Revision |          | _string_  |            | Parse `/proc/cpuinfo` file for the line _Revision_. |




Known ARM manufacturer codes:
  * 0x41: ARM Limited
  * 0x44: Digital Equipment Corporation
  * 0x4D: Motorola, Freescale Semiconductor Inc.
  * 0x51: QUALCOMM Inc.
  * 0x56: Marvell Semiconductor Inc.
  * 0x69: Intel Corporation