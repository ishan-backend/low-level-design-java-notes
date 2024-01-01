package logger;

import logger.ISubscriber;

public class ConsoleSubscriber implements ISubscriber {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
