package logger;

public interface IPublisher {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber); // takes subscriber and unsubscribes it from the list
    void notify(String message);
}
