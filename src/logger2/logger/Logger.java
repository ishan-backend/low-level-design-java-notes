package logger2.logger;

import logger2.loglevel.LogLevel;
import logger2.pubsub.IPublisher;

public abstract class Logger {
    Logger nextLogger; // abstract class
    IPublisher logPublisher;  // interface public - as needed in child classes to call nextLogger

    public Logger(Logger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    public void log(LogLevel logLevel, String message) {
        if(nextLogger != null)
            nextLogger.log(logLevel, message);
    }
}
