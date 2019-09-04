package com.xbw.log.jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author xbw
 */
public class JCL {
    private static Log logger = LogFactory.getLog(JCL.class);

    public static void log() {
        log(logger);
    }

    private static void log(Log logger) {
        logger.info("logger = " + logger.getClass().getName());

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