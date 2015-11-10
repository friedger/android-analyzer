This plugin collects data on various memory capabilities, like ROM, RAM, removable storage, etc.

**Plugin Name:** Memory Plugin

**Class Name:** `org.androidanalyzer.plugins.memory.MemoryPlugin`

The following table defines the structure of data being inserted in the report, and the APIs or methods used to retrieve the value.

| **Node** | **Node** | **Node** | **Value** | **Metric** | **Retrieval Method** |
|:---------|:---------|:---------|:----------|:-----------|:---------------------|
| Memory   |          |          |           |            |                      |
|          | ROM      |          | _integer_ |            | Unknown, N/A         |
|          | RAM      |          | _integer_ |            | Parse the value of `/proc/meminfo` file for the value in line starting with _MemTotal_ |
|          | Internal Storage |          | _integer_ | K          | See [#Internal\_Storage\_Analysis](#Internal_Storage_Analysis.md) below |
|          | External Storage |          |           |            |                      |
|          |          | Media type | _string_ (e.g. _mmc_) |            | Return _mmc_ if `new File("/dev/block/mmcblk0").exists())` |
|          |          | Maximum size | _integer_ | K          | Unknown, N/A         |


## Internal Storage Analysis ##
Steps to determine the size of internal storage:
  1. Parse the output of `mount` command for mounted points using _yaffs_ file system (except `/dev/block`)
  1. Parse the output of `df` command for sizes of each of the mounted points
  1. Total storage size is the sum of sizes of each mounted points