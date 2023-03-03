package com.xbw.log.tinylog.archived;

import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;

/**
 * https://tinylog.org/v1/documentation
 *
 * @author xbw
 */
public class TinyLog {

    public static void log() {
        log(null);
    }

    public static void log(Level level) {
        Logger.info("logger = " + Logger.class);

        if (level != null) {
            changeLevel(level);
        }

        Logger.error(Level.ERROR);
        Logger.warn(Level.WARNING);
        Logger.info(Level.INFO);
        Logger.debug(Level.DEBUG);
        Logger.trace(Level.TRACE);
    }

    private static void changeLevel(Level level) {
        Configurator.defaultConfig()
                .level(level)
                .activate();
    }
}