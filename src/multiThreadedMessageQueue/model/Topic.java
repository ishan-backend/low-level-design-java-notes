package multiThreadedMessageQueue.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic {
    private final String topicName;
    private final String topicId;
    // save all messages sent to a topic to reset offset for a subscriber later
    private final List<Message> messages; // add a getter which returns an immutable list of messages for this topic, for outside
    private final List<TopicSubscriber> subscribers; // is a class in between topic and subscriber, add a getter which returns immutable list

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    // getters
    public String getTopicId() {
        return topicId;
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return subscribers;
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    public String getTopicName() {
        return topicName;
    }

    public synchronized void addMessage(final Message message) {
        messages.add(message);
    }

    public void addSubscriber(final TopicSubscriber topicSubscriber) {
        subscribers.add(topicSubscriber);
    }
}
