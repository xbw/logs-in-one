package com.xbw.log.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {
    private static final Logger logger = LogManager.getLogger(Log4j2.class.getName());

    public static void log() {
        log(logger);
    }

    /**
     * @param logger org.apache.logging.log4j.core.Logger
     *               org.apache.logging.log4j.simple.SimpleLogger
     */
    private static void log(Logger logger) {
        logger.info("logger = " + logger.getClass().getName());

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

}