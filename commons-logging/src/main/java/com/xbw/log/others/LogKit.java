package com.xbw.log.others;

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

    private static void log(Logger logger) {
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