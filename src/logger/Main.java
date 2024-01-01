package logger;

import logger.data.LogLevel;
import logger.logger.ILogger;
import logger.logger.LoggerFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ILogger logger = LoggerFactory.getLogger();
        logger.log(LogLevel.ERROR, "DB Query Failed");
        logger.log(LogLevel.INFO, "Enter in method");
    }
}
