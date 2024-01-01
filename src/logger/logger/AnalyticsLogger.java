package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class AnalyticsLogger implements ILogger{
    private final ILogger nextLogger;
    private final IPublisher logPublisher;

    public AnalyticsLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.ERROR.getLevel()) {
            //
        }
        this.nextLogger.log(logLevel, message);
    }
}
