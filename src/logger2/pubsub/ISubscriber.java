package logger2.pubsub;

public interface ISubscriber {
    void send(String message); // is called from publishers
}
