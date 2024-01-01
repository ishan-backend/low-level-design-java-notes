**Requirements**:
* design your own logging system
* support multiple severity levels of log: info, debug, error, warn, fatal etc
* send specific category of logs to destinations of our choice
  * e.g. error logs to be written to -
    * local file system
    * written to cmd/console
    * sent to third party system
  * system should be configurable enough for us to add loggers for different severity logs to destine it to his choice
* ensure a log statement can be processed by multiple loggers
  * e.g. severity - error
    * two loggers - one sends to third party logging service; other one processes and sends to console

**Implementation steps**:
* ENUM loglevel
* we should have certain loggers and we should be able to pass our request through all of them -> Chain of responsibility pattern
  * ILogger interface, its methods and its concrete implementations following COR pattern (nextLogger and message)
  * Further Improvement: Data class which is composed of Loglevel and Message
  * a logging request can be required to go through different log handlers/loggers
* In addition to concrete implementations of ENUM type of ILogger interface
  * You can implement other concrete types as well for Analytics, etc.

* **Most important requirement**: Certain categories of logs should be destined to multiple destinations of our choice
  * Loggers need to publish data on different destinations
  * LogPublisher - responsible for publishing message
  * Subscribers (Loggers) - can subscribe to LogPublisher, when message is published, they can write to where required
  * **Observer Pattern**
    * Two interfaces: Publisher and Subscriber, And they have their own concrete implementations
      * Subscribers can be of following types:
        * Console subscriber - prints on console, once message is received
        * Local file system subs - prints at certain location in your file system
        * Cloud storage subscriber - publishes to a cloud store
  * Create IPublisher, ISubscriber interface
  * Write concrete implementation of IPublisher - LogPublisher
  * Write concrete implementation of ISubscriber - Console, File

* Lets introduce our Publisher into our loggers say logger/.
  * Injected via constructor
  * And all notify call on successful ENUM comparison check

* **Initialising the chain**:
  * IdleLogger - will be tail of our chain, so it doesnt need any publisher to publish & does not need next pointer

* In real world, order of members in chain is defined in some configuration file
  * What kind of publishers are needed by this logger?
  * What are subscribers of this publisher
  * These are read by factory, and then creates a chain and returns the logger
  * We are skipping the configuration file read, and will create a random chain and return it.
  * In real world, there is only one instance of logger that is used everywhere.
    * Reason: logger is humongous object (logger -> publisher -> subscribers), used by everything else in application
    * So, as improvement, you can make your factory look like singleton class
    * When we would use Logger.Log, it would get to know of correct type and publish on relevant place