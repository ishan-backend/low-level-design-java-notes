package multiThreadedMessageQueue.model;

import multiThreadedMessageQueue.subscribers.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private final ISubscriber subscriber;
    private final AtomicInteger offset;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
