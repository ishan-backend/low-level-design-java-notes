package logger2.pubsub;

public class ConsoleOnlySubscriber implements ISubscriber{
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
