package com.xbw.log;

import com.xbw.log.jboss.JLogging;
import org.apache.log4j.BasicConfigurator;

/**
 * @author xbw
 */
public class Main {
    /**
     * order by jboss, log4j2, log4j, slf4j(logback), jul
     *
     * implementation:
     * 1. jboss-logging-logmanager
     * 2. jboss-logging-log4j
     * 3. log4j2
     * 4. log4j
     * 5. jul
     */
    static {
//        System.setProperty("org.jboss.logging.provider", "jboss");
        // when jboss-logging-logmanager
//        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
//        System.setProperty("org.jboss.logging.Logger.pluginClass", "org.jboss.logging.logmanager.LoggerPluginImpl");

//        System.setProperty("org.jboss.logging.provider","jdk");
//        System.setProperty("org.jboss.logging.provider","log4j2");
//        System.setProperty("org.jboss.logging.provider","log4j");
        try {
            BasicConfigurator.configure();
        } catch (NoClassDefFoundError e) {
            // log4j is provided
        }

        // org.jboss.logging.Slf4jLocationAwareLogger when logback-classic
        // org.jboss.logging.Slf4jLogger when other
//        System.setProperty("org.jboss.logging.provider","slf4j");
    }

    public static void main(String[] args) {
        JLogging.log();
    }
}
