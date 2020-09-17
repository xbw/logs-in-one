package com.xbw.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xbw
 */
public class Slf4j {
    private static final Logger logger = LoggerFactory.getLogger(Slf4j.class);

    public static void log() {
        log(logger);
    }

    /**
     * @param logger org.slf4j.impl.JCLLoggerAdapter
     *               org.slf4j.impl.JDK14LoggerAdapter
     *               org.slf4j.impl.Log4jLoggerAdapter
     *               org.apache.logging.slf4j.Log4jLogger
     *               org.slf4j.impl.SimpleLogger
     *               org.jboss.slf4j.JBossLoggerAdapter
     */
    public static void log(Logger logger) {
        logger.info("logger = {} , {}", logger.getClass(), logger.getName());

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