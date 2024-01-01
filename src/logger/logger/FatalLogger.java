package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class FatalLogger implements ILogger{
    private final ILogger nextLogger;
    private final IPublisher logPublisher;
    public FatalLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.FATAL.getLevel()) {
            this.logPublisher.notify(LogLevel.FATAL + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
