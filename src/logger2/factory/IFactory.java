package logger2.factory;

import logger2.logger.Logger;

import java.io.IOException;


// IFactory - has classes / multiple types of factories of producing MainLogger class which will be singleton
public interface IFactory {
    Logger getLogger() throws IOException;
}
