# Goals #
The Android Analyzer project aims at developing an Android application that analyzes and collects hardware and software capabilities of devices based on the Android OS. Capability reports can be sent to an online database, currently hosted at http://AndroidFragmentation.com sister-site, where a comprehensive user interface is presented for browsing and comparing device capabilities for one or more devices. We believe that the Android developer community will benefit significantly from having an in-depth capability analysis at their fingertips, saving time, money and frustration.

# Deliverables #
The project will produce a single APK file, that will be published as a free application on the Android Market. This allows the developer community (as well as non-developer enthusiasts) to access the application easily and without any extra tooling. As the project evolves and new versions are released, the application on the Market will be updated accordingly.

The architecture of Android Analyzer also allows it to be embedded into third-party applications, which may provide their own UI.

# Architecture #
The range of hardware and software capabilities than will be analyzed and reported on is significant - from display characteristics, to memory, sensors, location, built-in applications, and so on. Each capability group requires dealing with one or more specific Android APIs, Linux APIs or the Linux OS in general. In order to make the development more manageable and scalable, the related functionality and capability analysis code is grouped into a separate plugin. For example, there will be separate plugins for display, memory, and so on.

Please refer to the [Architecture](Architecture.md) page for more details.

# Roadmap #
The concrete roadmap and feature list will be elaborated on in the [Roadmap](Roadmap.md) page. Major project releases are expected to be published every 3 months and will be kept in-sync with the evolution of the [Android Fragmentation](http://AndroidFragmentation.com) site.

# Community #
We welcome your feedback and contributions, and look forward to creating a vibrant community!

Ways to contribute:
  * Use the issue tracker to submit feature requests, bugs, patches, etc.
  * Submit code reviews
  * Become a developer of new plugins and features
  * Discuss the project at [Android Analyzer Google Group](http://groups.google.com/group/android-analyzer/)

To become a developer, first participate at the discussion group or mailing list by showing your interest in the project and your ability to help the project. Then, ask the project owners to make you a member of the project.