package logger2;

import logger2.factory.InfoLevelFactory;
import logger2.logger.Logger;
import logger2.loglevel.LogLevel;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        Logger infoFactoryLogger = InfoLevelFactory.getInstance().getLogger();
        infoFactoryLogger.log(LogLevel.INFO, "Enter main method");
    }
}
