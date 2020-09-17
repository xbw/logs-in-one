package com.xbw.log.logkit;

import org.apache.log.Hierarchy;
import org.apache.log.Logger;

/**
 * @author xbw
 */
public class LogKit {
    public static final Logger logger = Hierarchy.getDefaultHierarchy().getLoggerFor(LogKit.class.getName());

    public static void main(String[] args) {
        log(logger);
    }

    public static void log(Logger logger) {
        logger.info("logger = " + logger.getClass());

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