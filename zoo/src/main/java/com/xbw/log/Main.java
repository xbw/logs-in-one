package com.xbw.log;


import com.xbw.log.avalon.Avalon;
import com.xbw.log.logkit.LogKit;
import org.apache.avalon.framework.logger.*;
import org.apache.commons.logging.LogFactory;
import org.apache.log.Hierarchy;

/**
 * @author xbw
 */
public class Main {

    public static void main(String[] args) {
        airlift();
        avalon();
        LogKit.log();
        minlog();
    }


    private static void airlift() {
        io.airlift.log.Logger logger = io.airlift.log.Logger.get(Main.class);
        logger.info("logger = " + logger.getClass());

        logger.error("ERROR");
        logger.warn("WARN");
        if (logger.isInfoEnabled()) {
            logger.info("INFO");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("DEBUG");
        }
    }

    private static void avalon() {
        org.apache.log4j.BasicConfigurator.configure();
        //@since 4.3
        Avalon.log(new CommonsLogger(LogFactory.getLog(Avalon.class), Avalon.class.getName()));
        Avalon.log(new ConsoleLogger());
        Avalon.log(new Jdk14Logger(java.util.logging.Logger.getLogger(Avalon.class.getName())));
        Avalon.log(new Log4JLogger(org.apache.log4j.Logger.getLogger(Avalon.class)));
        Avalon.log(new LogKitLogger(Hierarchy.getDefaultHierarchy().getLoggerFor(Avalon.class.getName())));
        Avalon.log(new NullLogger());
    }

    private static void minlog() {
        com.esotericsoftware.minlog.Log.TRACE();
        com.esotericsoftware.minlog.Log.error("error");
        com.esotericsoftware.minlog.Log.warn("warn");
        com.esotericsoftware.minlog.Log.info("info");
        com.esotericsoftware.minlog.Log.debug("debug");
        com.esotericsoftware.minlog.Log.trace("trace");
    }
}
