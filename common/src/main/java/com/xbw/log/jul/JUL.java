package com.xbw.log.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author xbw
 */
public class JUL {
    private static final Logger logger = Logger.getLogger(JUL.class.getName());

    public static void log() {
        log(logger);
    }

    public static void log(Object... params) {
        log(logger, params);
    }

    /**
     * @param logger java.util.logging.Logger
     *               org.apache.logging.log4j.jul.CoreLogger
     */
    public static void log(Logger logger) {
        logger.info("logger = " + logger.getClass() + " , " + logger.getName());

        logger.severe(Level.SEVERE.getName());
        logger.warning(Level.WARNING.getName());
        logger.info(Level.INFO.getName());
        logger.config(Level.CONFIG.getName());
        logger.fine(Level.FINE.getName());
        logger.finer(Level.FINER.getName());
        logger.finest(Level.FINEST.getName());
    }

    public static void log(Logger logger, Object... params) {
        logger.log(Level.INFO, "logger = " + logger.getClass() + " , " + logger.getName());

        logger.log(Level.OFF, Level.OFF.getName());
        logger.log(Level.SEVERE, Level.SEVERE.getName());
        logger.log(Level.WARNING, Level.WARNING.getName());
        logger.log(Level.INFO, Level.INFO.getName());
        logger.log(Level.CONFIG, Level.CONFIG.getName());
        logger.log(Level.FINE, Level.FINE.getName());
        logger.log(Level.FINER, Level.FINER.getName());
        logger.log(Level.FINEST, Level.FINEST.getName());
        logger.log(Level.ALL, Level.ALL.getName());
    }
}
