package logger2.logger;

import logger2.loglevel.LogLevel;
import logger2.pubsub.IPublisher;

import java.util.Date;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger, IPublisher logPublisher) {
        super(nextLogger, logPublisher);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel == LogLevel.ERROR) {
            String logMessage = "[" + new Date() + "] [" + logLevel.name() + "] " + message;
            this.logPublisher.notify(logMessage);
        }

        super.log(logLevel, message);
    }
}
