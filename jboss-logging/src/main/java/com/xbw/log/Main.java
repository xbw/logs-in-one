package com.xbw.log;

import com.xbw.log.jboss.JLogging;
import org.jboss.logging.Logger;
import org.jboss.logging.LoggerProvider;

import java.util.ServiceLoader;

/**
 * @author xbw
 */
public class Main {
    static {
//        System.setProperty("org.jboss.logging.provider", "jboss");
//        System.out.println("logging.configuration = " + Config.jBossLogConfiguration("jboss-logmanager"));
//        System.setProperty("org.jboss.logging.Logger.pluginClass", "org.jboss.logging.logmanager.LoggerPluginImpl");

//        System.setProperty("org.jboss.logging.provider","log4j2");

//        System.setProperty("org.jboss.logging.provider","log4j");
//        try {
//            org.apache.log4j.BasicConfigurator.configure();
//        } catch (NoClassDefFoundError e) {
//            // log4j is provided
//        }

        // when logback-classic org.jboss.logging.Slf4jLocationAwareLogger
        // when other org.jboss.logging.Slf4jLogger
//        System.setProperty("org.jboss.logging.provider","slf4j");

//        System.setProperty("org.jboss.logging.provider","jdk");
    }

    /**
     * order by:
     * 1. System Property (jboss, jdk, log4j2, log4j, slf4j)
     * 2. ServiceLoader<LoggerProvider>
     * 3. jboss-logging-logmanager
     * 4. jboss-logging-log4j
     * 5. log4j-api + logback
     * 6. slf4j-api
     * 7. jdk
     */
    public static void main(String[] args) {
//        org.jboss.logging.LoggerProviders.findProvider();
        JLogging.log();
//        custom();
    }

    public static void custom() {
        ServiceLoader<LoggerProvider> loader = ServiceLoader.load(LoggerProvider.class);
        loader.forEach(provider -> {
            Logger logger = provider.getLogger(Main.class.getName());
            logger.debug("loader = " + loader);
            logger.debug("provider = " + provider.getClass());
            logger.info(logger.getClass());
        });
    }
}
