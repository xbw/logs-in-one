package com.xbw.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4j {
    private static Logger logger = LoggerFactory.getLogger(Slf4j.class);

    public static void log() {
        log(logger);
    }

    private static void log(Logger logger) {
        logger.info("logger = " + logger.getClass().getName());

        if (logger.isErrorEnabled()) {
            logger.error("error");
        }
        if (logger.isWarnEnabled()) {
            logger.warn("warn");
        }
        if (logger.isInfoEnabled()) {
            logger.info("info");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }
        if (logger.isTraceEnabled()) {
            logger.trace("trace");
        }
    }

}