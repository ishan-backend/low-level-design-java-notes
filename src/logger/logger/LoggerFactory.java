package logger.logger;

import logger.ConsoleSubscriber;
import logger.FileSubscriber;
import logger.IPublisher;
import logger.LogPublisher;

import java.io.IOException;

public class LoggerFactory {
    private LoggerFactory(){} // private constructor of factory

    public static ILogger getLogger() throws IOException {
        // we will create a chain of all the different loggers we have
        // before that, we need publishers - will make two: one for debug&info, other for all
        // we need subscribers to subscribe to these publishers
        IPublisher debugAndInfoPublisher = new LogPublisher();
        debugAndInfoPublisher.subscribe(new ConsoleSubscriber()); // debug and info logs will be print to console

        IPublisher warnAndAbovePublisher = new LogPublisher();
        warnAndAbovePublisher.subscribe(new ConsoleSubscriber());
        warnAndAbovePublisher.subscribe(new FileSubscriber("log.txt"));

        // chain - type that is created from this chain is still ILogger
        return new DebugLogger(
                new InfoLogger(
                        new WarnLogger(
                                new ErrorLogger(
                                        new AnalyticsLogger(
                                                new FatalLogger(
                                                        new IdleLogger(),
                                                        warnAndAbovePublisher
                                                ),
                                                warnAndAbovePublisher
                                        ),
                                        warnAndAbovePublisher
                                ),
                                warnAndAbovePublisher
                        ),
                        debugAndInfoPublisher
                ),
                debugAndInfoPublisher
        );
    }
}
