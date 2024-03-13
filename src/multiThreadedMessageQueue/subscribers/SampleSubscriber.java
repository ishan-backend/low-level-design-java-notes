package multiThreadedMessageQueue.subscribers;

import multiThreadedMessageQueue.model.Message;

public class SampleSubscriber implements ISubscriber{
    private final String id;
    private final Integer timeInMs;

    public SampleSubscriber(String id, Integer timeInMs) {
        this.id = id;
        this.timeInMs = timeInMs;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMessage());
        Thread.sleep(timeInMs);
        System.out.println("Subscriber: " + id + " ended consuming: " + message.getMessage());
    }

    @Override
    public String getId() {
        return id;
    }
}
