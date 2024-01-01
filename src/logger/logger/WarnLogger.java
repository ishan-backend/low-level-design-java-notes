package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class WarnLogger implements ILogger{
    private final ILogger nextLogger;
    private final IPublisher logPublisher;
    public WarnLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.WARN.getLevel()) {
            this.logPublisher.notify(LogLevel.WARN + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
