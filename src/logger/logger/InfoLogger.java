package logger.logger;

import logger.IPublisher;
import logger.data.LogLevel;

public class InfoLogger implements ILogger{
    // Class depends on abstractions, not on concretions
    private final ILogger nextLogger;
    private final IPublisher logPublisher;
    public InfoLogger(ILogger nextLogger, IPublisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel.getLevel() == LogLevel.INFO.getLevel()) {
            this.logPublisher.notify(LogLevel.INFO + " " +message);
        }
        this.nextLogger.log(logLevel, message);
    }
}
