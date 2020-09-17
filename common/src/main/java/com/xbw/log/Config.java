package com.xbw.log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Config {
    public static final String JUL_LOGMANAGER = "java.util.logging.manager";

    public static final String LOG4J_CONFIGURATION = "log4j.configuration";
    public static final String LOG4J_CONFIGURATION_XML = "log4j.xml";
    public static final String LOG4J_CONFIGURATION_PROPERTIES = "log4j.properties";

    public static final String LOG4J2_LOGMANAGER = "org.apache.logging.log4j.jul.LogManager";

    public static final String JBOSS_LOGMANAGER = "org.jboss.logmanager.LogManager";
    public static final String JBOSS_LOGMANAGER_CONFIGURATION = "logging.configuration";
    public static final String JBOSS_LOGMANAGER_CONFIGURATION_PROPERTIES = "logging.properties";


    public static String jBossLogConfiguration(String module) {
        jul2JBossLog();
        return configuration(module, JBOSS_LOGMANAGER_CONFIGURATION, JBOSS_LOGMANAGER_CONFIGURATION_PROPERTIES);
    }

    public static void jul2JBossLog() {
        System.setProperty(JUL_LOGMANAGER, JBOSS_LOGMANAGER);
    }

    public static void jul2Log4j2() {
        System.setProperty(JUL_LOGMANAGER, LOG4J2_LOGMANAGER);
    }

    public static void jul2Slf4J() {
        org.slf4j.bridge.SLF4JBridgeHandler.removeHandlersForRootLogger();
        org.slf4j.bridge.SLF4JBridgeHandler.install();
    }

    public static void julLevelAll(boolean setProperty) {
        Logger logger;
        if (setProperty) {
            System.setProperty("java.util.logging.config.file", Config.class.getClassLoader().getResource("logging.properties").getPath());
            logger = Logger.getLogger(Config.class.getName());
            logger.info("java.util.logging.config.file = " + System.getProperty("java.util.logging.config.file"));
        } else {
            logger = Logger.getLogger(Config.class.getName());
            try (InputStream is = Config.class.getClassLoader().getResourceAsStream("logging.properties")) {
                LogManager manager = LogManager.getLogManager();
                manager.readConfiguration(is);
//                manager.addLogger(logger);
            } catch (IOException e) {
                logger.severe(e.getMessage());
            }
        }
    }

    public static String log4jConfiguration(String module) {
        return log4jConfiguration(module, LOG4J_CONFIGURATION_PROPERTIES);
    }

    public static String log4jConfiguration(String module, String fileName) {
        if (null == fileName || "".equals(fileName)) {
            fileName = LOG4J_CONFIGURATION_XML;
        }
        return configuration(module, LOG4J_CONFIGURATION, fileName);
    }

    private static String configuration(String module, String config, String fileName) {
        StringBuilder sb = new StringBuilder("file:");
        sb.append(System.getProperty("user.dir"));
        sb.append(File.separator);
        sb.append(module);
        sb.append(File.separator);
        sb.append("src");
        sb.append(File.separator);
        sb.append("main");
        sb.append(File.separator);
        sb.append("resources");
        sb.append(File.separator);
        sb.append(fileName);

        setProperty(config, sb.toString());
        return getProperty(config);
    }

    public static String configuration(String config, String configuration) {
        setProperty(config, configuration);
        return getProperty(config);
    }

    private static void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    private static String getProperty(String key) {
        return System.getProperty(key);
    }
}
