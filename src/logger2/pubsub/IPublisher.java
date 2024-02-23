package logger2.pubsub;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notify(String message); // is called from clients
}
