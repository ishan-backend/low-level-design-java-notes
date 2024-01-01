package logger.logger;

import logger.data.LogLevel;

public interface ILogger {
    void log(LogLevel logLevel, String message);
}
