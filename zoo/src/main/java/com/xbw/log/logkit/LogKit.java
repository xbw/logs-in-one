package com.xbw.log.logkit;

import org.apache.log.Hierarchy;
import org.apache.log.Logger;
import org.apache.log.Priority;

/**
 * @author xbw
 */
public class LogKit {
    private static final Logger logger = Hierarchy.getDefaultHierarchy().getLoggerFor(LogKit.class.getName());

    public static void log() {
        log(logger);
    }

    public static void log(Object... params) {
        log(logger, params);
    }

    public static void log(Logger logger) {
        logger.info("logger = " + logger.getClass());

        if (logger.isFatalErrorEnabled()) {
            logger.fatalError(Priority.FATAL_ERROR.getName());
        }
        if (logger.isErrorEnabled()) {
            logger.error(Priority.ERROR.getName());
        }
        if (logger.isWarnEnabled()) {
            logger.warn(Priority.WARN.getName());
        }
        if (logger.isInfoEnabled()) {
            logger.info(Priority.INFO.getName());
        }
        if (logger.isDebugEnabled()) {
            logger.debug(Priority.DEBUG.getName());
        }
    }

    public static void log(Logger logger, Object... params) {
        logger.log(Priority.INFO, "logger = " + logger.getClass());

        logger.log(Priority.NONE, Priority.NONE.getName());
        logger.log(Priority.FATAL_ERROR, Priority.FATAL_ERROR.getName());
        logger.log(Priority.ERROR, Priority.ERROR.getName());
        logger.log(Priority.WARN, Priority.WARN.getName());
        if (logger.isInfoEnabled()) {
            logger.log(Priority.INFO, Priority.INFO.getName());
        }
        if (logger.isDebugEnabled()) {
            logger.log(Priority.DEBUG, Priority.DEBUG.getName());
        }
    }
}