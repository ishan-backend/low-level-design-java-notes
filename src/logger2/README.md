**Requirements**:

Client / application make use of logger library to log messages to a sink e.g log4J

**Message**
* has content which is of type string
* has a level associated with it
* is direct it to a destination( sink)
* has namespace associated with it to identify the part of application that send the message

**Sink**
* This is the destination for a message (e.g. text file, database, console etc)
* Sync is tied to or more message level
* one or more message level can have the same sink

**Logger library**
* Requires configuration during sink setup
* Accepts messages from client(s)
* Routes messages to appropriate sink based on the level
* Supports following message level in the order of priority: FATAL, ERROR, WARN, INFO, DEBUG
* Message levels adobe a given message level should be logged
* Ex: If INFO is configured as a message level, FATAL, ERROR, WARN and INFO should be logged
* Enriches message which additional information (like timestamp) while directing message to a sink

**Sending messages**
* Sink need not be mentioned while sending a message to the logger library.
* A message level is tied to a sink.
* You specify message content, level and namespace while sending a message

**Logger configuration( see sample below)**
* Specifies all the details required to use the logger library.
* Library can accept one or more configuration for an application
* One configuration for association of message level and sink
You may consider logger configuration as key value pair
`Example
time format
logging level
sink type
details required for sink (ex file location)`

**Components involved**:
1. Logger Class - exposed to application
2. Category Class - to be chosen at runtime based on some parameter from configuration file
3. Sink Class - selected at runtime based on some parameter

Onboarding/Removing new category or sink should not disturb any flow - loosely coupled
- SOLID Principles
- Relate requirements to a design pattern
  * Creational:
    * Objects we can create - Logger, (Enum /Class for INFO, DEBUG), Class - Database (create db connection and log it), third party, console, file
      * Singleton for Logger Class
        * For Logger: we don't want to create multiple instances of logger, if we have multi-threaded application - ideally should log into a single file
        * if not using singleton, same log RID can be written to multiple files, since there will be multiple instances
      * Sink Objects - as application gets large can be moved from singleton to factory/abstract factory (moving away from singleton)

  * Structural:
    * structure wise there is no connection between two systems - it is single system from source to sink
    * no two classes coupled/connecting/bridging between each other

  * Behavioural:
    * Category (multiple kind):
      * we have different kind of category and some are more restrictive than other
      * if level is info (info, error etc can be shown) but not debug
        * Related to chain of responsibility
        * move from low strictness to high strictness
        * 
    * Sink (multiple kind):
      * each sink is independent of each other but is dependent on category of logs which we are going to write
      * Logger -> (Category class) -> Observer Notify -> Different sinks (silent listener)
      * Observer Pattern