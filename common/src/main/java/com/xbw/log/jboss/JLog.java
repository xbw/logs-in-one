package com.xbw.log.jboss;

import org.jboss.logmanager.Level;
import org.jboss.logmanager.Logger;

public class JLog {
    private static Logger logger = Logger.getLogger(JLog.class.getName());


    public static void log() {
        log(logger);
    }

    /**
     * @param logger org.jboss.logmanager.Logger
     */
    public static void log(Logger logger) {
        logger.log(Level.INFO, "logger = " + logger.getClass().getName());
        logger.log(Level.FATAL, Level.FATAL.getName());
        logger.log(Level.ERROR, Level.ERROR.getName());
        logger.log(Level.WARN, Level.WARN.getName());
        logger.log(Level.INFO, Level.INFO.getName());
        logger.log(Level.DEBUG, Level.DEBUG.getName());
        logger.log(Level.TRACE, Level.TRACE.getName());

        logger.info("before 1.2.2.GA The upper and lower outputs are different");

        logger.info("logger = " + logger.getClass().getName());
        logger.severe(Level.SEVERE.getName());
        logger.warning(Level.WARNING.getName());
        logger.info(Level.INFO.getName());
        logger.config(Level.CONFIG.getName());
        logger.fine(Level.FINE.getName());
        logger.finer(Level.FINER.getName());
        logger.finest(Level.FINEST.getName());
    }

}
