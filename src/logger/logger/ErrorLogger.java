package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class ErrorLogger implements ILogger{
    // Chain of responsibility
    private final ILogger nextLogger; // next pointer in chain of responsibility
    private final IPublisher logPublisher;

    public ErrorLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.ERROR.getLevel()) {
            // publish via publisher
            this.logPublisher.notify(LogLevel.ERROR + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
