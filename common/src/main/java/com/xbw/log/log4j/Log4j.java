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

    public static void custom() {
        Logger custom = Logger.getLogger(Log4j.class.getName() + ".custom");
        log(custom);
    }

    private static void log(Logger logger) {
        logger.info("logger = " + logger.getClass().getName());

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

}