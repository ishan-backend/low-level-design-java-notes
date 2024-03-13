package multiThreadedMessageQueue.subscribers;

import multiThreadedMessageQueue.model.Message;

public interface ISubscriber {
    void consume(Message message) throws InterruptedException;
    String getId();
}
