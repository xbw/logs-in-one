package com.xbw.log.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author xbw
 */
public class Log4j {
    private static final Logger logger = Logger.getLogger(Log4j.class);

    public static void log() {
        log(logger);
    }

    public static void log(Object... params) {
        log(logger, params);
    }

    public static void custom() {
        Logger custom = Logger.getLogger(Log4j.class.getName() + ".custom");
        log(custom);
    }

    /**
     * @param logger org.apache.log4j.Logger
     *               org.jboss.logmanager.log4j.BridgeLogger
     */
    public static void log(Logger logger) {
        logger.info("logger = " + logger.getClass() + " , " + logger.getName());

        logger.fatal(Level.FATAL);
        logger.error(Level.ERROR);
        logger.warn(Level.WARN);
        if (logger.isInfoEnabled()) {
            logger.info(Level.INFO);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(Level.DEBUG);
        }
        if (logger.isTraceEnabled()) {
            logger.trace(Level.TRACE);
        }
    }

    public static void log(Logger logger, Object... params) {
        logger.log(Level.INFO, "logger = " + logger.getClass() + " , " + logger.getName());

        logger.log(Level.OFF, Level.OFF);
        logger.log(Level.FATAL, Level.FATAL);
        logger.log(Level.ERROR, Level.ERROR);
        logger.log(Level.WARN, Level.WARN);
        logger.log(Level.FATAL, Level.FATAL);
        if (logger.isInfoEnabled()) {
            logger.log(Level.INFO, Level.INFO);
        }
        if (logger.isDebugEnabled()) {
            logger.log(Level.DEBUG, Level.DEBUG);
        }
        if (logger.isTraceEnabled()) {
            logger.log(Level.TRACE, Level.TRACE);
        }
        logger.log(Level.ALL, Level.ALL);
    }
}