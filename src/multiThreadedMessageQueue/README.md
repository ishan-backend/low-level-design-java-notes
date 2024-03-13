Design a MQ supporting pub sub model. It should support following operations:
1. It should support multiple topics where messages can be published
2. Publisher should be able to publish a message to particular topic
3. Subscribers should be able to subscribe to a topic
4. Subscribers should be able to run in parallel
5. Whenever a message is published to a topic, all subscribers subscribed to that topic should receive messages
6. We should be able to reset the offset of a topic for a subscriber. This means subscriber would start reading from that offset next.
   - like replaying the messages.
