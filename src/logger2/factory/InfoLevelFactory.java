package logger2.factory;

import logger2.logger.ErrorLogger;
import logger2.logger.IdleLogger;
import logger2.logger.InfoLogger;
import logger2.logger.Logger;
import logger2.pubsub.ConsoleOnlySubscriber;
import logger2.pubsub.FileOnlySubscriber;
import logger2.pubsub.IPublisher;
import logger2.pubsub.LogPublisher;

import java.io.IOException;


// InfoLevelFactory allows logger to save all severity logs from SINK to higher priority/ENUM level
public class InfoLevelFactory implements IFactory {
    private static InfoLevelFactory instance; // singleton inside factory

    private InfoLevelFactory() {
    }

    public static InfoLevelFactory getInstance() {
        if (instance == null) {
            synchronized (InfoLevelFactory.class) {
                if (instance == null) { // This check is necessary because multiple threads might have passed the first check and are waiting for synchronization. The second check prevents the creation of multiple instances by the first thread that acquires the lock.
                    instance = new InfoLevelFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public Logger getLogger() throws IOException {
        return createLogger();
    }

    // Actual logger creation logic with Singleton pattern
    private Logger createLogger() throws IOException {
        return LoggerSingleton.getInstance(); // Assume LoggerSingleton is a Singleton for logger instance
    }

    // LoggerSingleton class representing the Singleton pattern for logger instance
    private static class LoggerSingleton {
        private static Logger instance;

        // Private constructor to prevent instantiation
        private LoggerSingleton() {
        }

        // Get singleton instance of logger
        public synchronized static Logger getInstance() throws IOException {
            if (instance == null) {
                IPublisher infoLevelPublisher = new LogPublisher(); // add separate log publishers with group of sinks for this use-case
                infoLevelPublisher.subscribe(new ConsoleOnlySubscriber());
                infoLevelPublisher.subscribe(new FileOnlySubscriber()); // todo: add FileOnlySubscriber with AOF using singleton

                IPublisher analyticsLevelPublisher = new LogPublisher(); // for ERROR or FATAL
                analyticsLevelPublisher.subscribe(new FileOnlySubscriber()); // this may be errors.txt

                // now attach this publisher into next logger chain using chain of responsibility
                // todo: Why? -> Certain sinks defined for down level might be valid for other top level sinks as well
                // for e.g. analytics will be active for INFO, ERROR, FATAL
                // while for long term storage say for database, we want to store ERROR and FATAL only
                // IdleLogger() might not only be end, before that AggregateLogger() which appends every thing to database may be called
                instance = new InfoLogger(
                        new ErrorLogger(
                                new IdleLogger(),
                                analyticsLevelPublisher
                        ),
                        infoLevelPublisher
                );
            }
            return instance;
        }
    }
}
