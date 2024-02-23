package logger2.pubsub;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements IPublisher {
    public List<ISubscriber> subscribers;
    public LogPublisher() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(String message) {
        for(ISubscriber subscriber: subscribers) {
            subscriber.send(message);
        }
    }
}
