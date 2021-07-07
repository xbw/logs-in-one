package com.xbw.log.avalon;

import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.avalon.framework.logger.Logger;

/**
 * @author xbw
 */
public class Avalon {
    private static final Logger logger = new ConsoleLogger();

    /**
     * new ConsoleLogger()
     */
    public static void log() {
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
