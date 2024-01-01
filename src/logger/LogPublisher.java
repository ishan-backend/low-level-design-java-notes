package logger;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements IPublisher{
    private final List<ISubscriber> subscribers;
    public LogPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notify(String message) { // message is published using this method
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
}
