package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class DebugLogger implements ILogger{
    private final ILogger nextLogger;
    private final IPublisher logPublisher;
    public DebugLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.DEBUG.getLevel()) {
        this.logPublisher.notify(LogLevel.DEBUG + " " + message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
