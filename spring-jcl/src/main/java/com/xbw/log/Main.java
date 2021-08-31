package com.xbw.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author xbw
 */
public class Main {
    private static final Log logger = LogFactory.getLog(Main.class);

    /**
     * order by:
     * 1. log4j2 {@link org.apache.logging.log4j.spi.ExtendedLogger}
     * 2. log4j2 {@link org.apache.logging.slf4j.SLF4JProvider}
     * 3. slf4j org.slf4j.spi.LocationAwareLogger
     * 4. slf4j org.slf4j.Logger
     * 5. jdk java.util.logging.Logger
     * @see org.apache.commons.logging.LogAdapter
     */
    public static void main(String[] args) {
        log(logger);
    }

    public static void log(Log logger) {
        logger.info("logger = " + logger.getClass());

        if (logger.isFatalEnabled()) {
            // java.util.logging.Level.SEVERE
            // org.apache.log4j.Level.FATAL
            logger.fatal("fatal");
        }
        if (logger.isErrorEnabled()) {
            // java.util.logging.Level.SEVERE
            // org.apache.log4j.Level.ERROR
            logger.error("error");
        }
        if (logger.isWarnEnabled()) {
            // java.util.logging.Level.WARNING
            // org.apache.log4j.Level.WARN
            logger.warn("warn");
        }
        if (logger.isInfoEnabled()) {
            // java.util.logging.Level.INFO
            // org.apache.log4j.Level.INFO
            logger.info("info");
        }
        if (logger.isDebugEnabled()) {
            // java.util.logging.Level.FINE
            // org.apache.log4j.Level.DEBUG
            logger.debug("debug");
        }
        if (logger.isTraceEnabled()) {
            // java.util.logging.Level.FINEST
            // org.apache.log4j.Level.TRACE
            logger.trace("trace");
        }
    }
}
