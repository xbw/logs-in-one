package com.xbw.log.tinylog;


import org.tinylog.Level;
import org.tinylog.Logger;

/**
 * https://tinylog.org/v2/getting-started/
 *
 * @author xbw
 */
public class TinyLog {

    public static void log() {
        Logger.info("logger = " + Logger.class);
        Logger.error(Level.ERROR);
        Logger.warn(Level.WARN);
        Logger.info(Level.INFO);
        Logger.debug(Level.DEBUG);
        Logger.trace(Level.TRACE);
    }
}