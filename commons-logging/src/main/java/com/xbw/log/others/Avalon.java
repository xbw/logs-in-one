package com.xbw.log.others;

import org.apache.avalon.framework.logger.*;
import org.apache.log.Hierarchy;

import java.util.logging.LogManager;

/**
 * @author xbw
 */
public class Avalon {
    public static void main(String[] args) {
        consoleLogger();
        jdk14Logger();
        log4JLogger();
        logKitLogger();
        nullLogger();
    }

    public static void consoleLogger() {
        Logger logger = new ConsoleLogger();
        log(logger);
    }

    public static void jdk14Logger() {
        Logger logger = new Jdk14Logger(LogManager.getLogManager().getLogger(""));
        log(logger);
    }

    public static void log4JLogger() {
        org.apache.log4j.BasicConfigurator.configure();
        Logger logger = new Log4JLogger(org.apache.log4j.Logger.getLogger(Avalon.class));
        log(logger);
    }

    public static void logKitLogger() {
        Logger logger = new LogKitLogger(Hierarchy.getDefaultHierarchy().getLoggerFor(Avalon.class.getName()));
        log(logger);
    }

    public static void nullLogger() {
        Logger logger = new NullLogger();
        log(logger);
    }

    private static void log(Logger logger) {
        logger.info("logger = " + logger.getClass().getName());
        if (logger.isFatalErrorEnabled()) {
            logger.fatalError("FATAL ERROR");
        }
        if (logger.isErrorEnabled()) {
            logger.error("ERROR");
        }
        if (logger.isWarnEnabled()) {
            logger.warn("WARN");
        }
        if (logger.isInfoEnabled()) {
            logger.info("INFO");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("DEBUG");
        }
    }
}
