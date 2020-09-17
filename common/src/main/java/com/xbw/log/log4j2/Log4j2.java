package com.xbw.log.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author xbw
 */
public class Log4j2 {
    private static final Logger logger = LogManager.getLogger(Log4j2.class.getName());

    public static void log() {
        log(logger);
    }

    public static void log(Object... params) {
        log(logger, params);
    }

    /**
     * @param logger org.apache.logging.log4j.core.Logger
     *               org.apache.logging.log4j.simple.SimpleLogger
     */
    public static void log(Logger logger) {
        logger.info("logger = {} , {}", logger.getClass(), logger.getName());

        if (logger.isFatalEnabled()) {
            logger.fatal(Level.FATAL);
        }
        if (logger.isErrorEnabled()) {
            logger.error(Level.ERROR);
        }
        if (logger.isWarnEnabled()) {
            logger.warn(Level.WARN);
        }
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
        logger.log(Level.INFO, "logger = {} , {}", logger.getClass(), logger.getName());

        logger.log(Level.OFF, Level.OFF);
        if (logger.isFatalEnabled()) {
            logger.log(Level.FATAL, Level.FATAL);
        }
        if (logger.isErrorEnabled()) {
            logger.log(Level.ERROR, Level.ERROR);
        }
        if (logger.isWarnEnabled()) {
            logger.log(Level.WARN, Level.WARN);
        }
        // Create and use a new custom level "DIAG".
        logger.log(Level.forName("DIAG", 350), Level.getLevel("DIAG"));
        if (logger.isInfoEnabled()) {
            logger.log(Level.INFO, Level.INFO);
        }
        if (logger.isDebugEnabled()) {
            logger.log(Level.DEBUG, Level.DEBUG);
        }
        // This creates the "VERBOSE" level if it does not exist yet.
        Level VERBOSE = Level.forName("VERBOSE", 550);
        logger.log(VERBOSE, VERBOSE); // use the custom VERBOSE level
        if (logger.isTraceEnabled()) {
            logger.log(Level.TRACE, Level.TRACE);
        }
        logger.log(Level.ALL, Level.ALL);
    }
}