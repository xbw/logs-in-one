package com.xbw.log.jboss;

import org.jboss.logmanager.Level;
import org.jboss.logmanager.Logger;

/**
 * @author xbw
 */
public class JLog {
    private static final Logger logger = Logger.getLogger(JLog.class.getName());

    public static void log() {
        log(logger);
    }

    public static void log(Object... params) {
        log(logger, params);
    }

    /**
     * @param logger org.jboss.logmanager.Logger
     */
    public static void log(Logger logger) {
        logger.log(Level.INFO, "logger = " + logger.getClass() + " , " + logger.getName());

        logger.severe(Level.SEVERE.getName());
        logger.warning(Level.WARNING.getName());
        logger.info(Level.INFO.getName());
        logger.config(Level.CONFIG.getName());
        logger.fine(Level.FINE.getName());
        logger.finer(Level.FINER.getName());
        logger.finest(Level.FINEST.getName());
    }

    public static void log(Logger logger, Object... params) {
        logger.log(Level.INFO, "before 1.2.2.GA The log() and logLevel() outputs are different");
        logger.log(Level.INFO, "logger = " + logger.getClass() + " , " + logger.getName());

        logger.log(Level.OFF, Level.OFF.getName());
        logger.log(Level.FATAL, Level.FATAL.getName());
        logger.log(Level.ERROR, Level.ERROR.getName());
        logger.log(Level.WARN, Level.WARN.getName());
        logger.log(Level.INFO, Level.INFO.getName());
        logger.log(Level.DEBUG, Level.DEBUG.getName());
        logger.log(Level.TRACE, Level.TRACE.getName());
        logger.log(Level.FINE, Level.FINE.getName());
        logger.log(Level.FINER, Level.FINER.getName());
        logger.log(Level.FINEST, Level.FINEST.getName());
        logger.log(Level.ALL, Level.ALL.getName());
    }

}
