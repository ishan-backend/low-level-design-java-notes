**Requirements**:
- should be plug-in and play i.e  decoupled from main services
- multiple types of notifications
  - text message
  - qr code
  - open to adding new type of message i.e. JSON, XML etc
- should support multiple ways of sending - email, whatsapp/telegram, sms etc
  - each type can have its own processor (SRP)
  - processors should not be tightly coupled and open to adding new ways of sending

- App -> [Message Queue {JSON with mutliple tags (customizable) - text, whatsapp & email}] -> Message Processor
- Service should be able to scale in high traffic i.e. Using BookMyShow etc
- Reduce the service downtime
- Load Balance and distribute the processing (scaling microservice)

**Bridge design pattern**:
- decouples abstractions from its implementations
- helpful when class i.e template and action taken by class i.e. method varies a lot
  * type of messages JSON, XML, text etc (template/abstractions) say N ways
  * ways to send - push notification, email, WA etc (implementation) say M ways
  * seems like, total no of classes to create = N*M
  * makes bridge between abstractions and its implementation which reduces classes to almost N+M classes (interface, abstract classes + actual implementation)

**Implementation**:
* Implementation side:
  * NotificationSender interface
  * Abstract class of different types of notifications we want to send
