package com.xbw.log.jboss;

import org.jboss.logging.Logger;

/**
 * @author xbw
 */
public class JLogging {
    private static final Logger logger = Logger.getLogger(JLogging.class);

    public static void log() {
        log(logger);
    }

    /**
     * @param logger org.jboss.logging.JDKLogger
     *               org.jboss.logging.Log4jLogger
     *               org.jboss.logging.Log4j2Logger
     *               org.jboss.logging.Slf4jLocationAwareLogger
     *               org.jboss.logging.Slf4jLogger
     *               org.jboss.logging.JBossLogManagerLogger
     */
    public static void log(Logger logger) {
        logger.info("logger = " + logger.getClass() + " , " + logger.getName());

        logger.fatal(Logger.Level.FATAL);
        logger.error(Logger.Level.ERROR);
        logger.warn(Logger.Level.WARN);
        if (logger.isInfoEnabled()) {
            logger.info(Logger.Level.INFO);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(Logger.Level.DEBUG);
        }
        if (logger.isTraceEnabled()) {
            logger.trace(Logger.Level.TRACE);
        }
    }
}
