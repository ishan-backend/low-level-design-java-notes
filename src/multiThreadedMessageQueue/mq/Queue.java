package multiThreadedMessageQueue.mq;

import multiThreadedMessageQueue.model.Topic;


import java.util.UUID;

public class Queue {

    public Topic createTopic(final String topicName) { // todo: add @NonNull wrapper using Lombok
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
    }
}
