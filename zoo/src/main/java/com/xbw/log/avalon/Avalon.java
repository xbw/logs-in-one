package com.xbw.log.avalon;

import org.apache.avalon.framework.logger.*;
import org.apache.log.Hierarchy;

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
        // org.apache.avalon.framework.logger.ConsoleLogger
        Logger logger = new ConsoleLogger();
        log(logger);
    }

    public static void jdk14Logger() {
        // org.apache.avalon.framework.logger.Jdk14Logger
        Logger logger = new Jdk14Logger(java.util.logging.Logger.getLogger(Avalon.class.getName()));
        log(logger);
    }

    public static void log4JLogger() {
        // org.apache.avalon.framework.logger.Log4JLogger
        org.apache.log4j.BasicConfigurator.configure();
        Logger logger = new Log4JLogger(org.apache.log4j.Logger.getLogger(Avalon.class));
        log(logger);
    }

    public static void logKitLogger() {
        // org.apache.avalon.framework.logger.LogKitLogger
        Logger logger = new LogKitLogger(Hierarchy.getDefaultHierarchy().getLoggerFor(Avalon.class.getName()));
        log(logger);
    }

    public static void nullLogger() {
        // org.apache.avalon.framework.logger.NullLogger
        Logger logger = new NullLogger();
        log(logger);
    }

    public static void log(Logger logger) {
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
