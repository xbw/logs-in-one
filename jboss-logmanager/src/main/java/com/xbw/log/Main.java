package com.xbw.log;

import com.xbw.log.jboss.JLog;
import com.xbw.log.jboss.JLogging;
import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.log4j2.Log4j2;
import com.xbw.log.slf4j.Slf4j;

/**
 * @author xbw
 */
public class Main {
    static {
        // Using JBoss LogManager (1.1.x) in a standalone program
        // https://developer.jboss.org/docs/DOC-13898

        // 2. Specify the alternate log manager as a system property, either on the command-line or as a part of your early boot process:
        // -Djava.util.logging.manager=org.jboss.logmanager.LogManager
        Config.jul2JBossLog();

        // 3. Specify your logging configuration properties (see JBossBootLogging for information about how to set up this properties file).
        // JBossBootLogging https://developer.jboss.org/docs/DOC-10235
//        String configuration = "file:" + Main.class.getResource("/").getPath()+ "logging.properties";
//        System.out.println("logging.configuration = " + Config.configuration(Config.JBOSS_LOGMANAGER_CONFIGURATION,configuration));

        // 4.1. Specify the special system property to disable automatic log4j configuration:
        System.setProperty("log4j.defaultInitOverride", "true");
        // 4.2. In your early boot process, install the special repository selector:
        try {
            new org.jboss.logmanager.log4j.BridgeRepositorySelector().start();
        } catch (NoClassDefFoundError e) {
            // jboss-logmanager-log4j is provided
        }

        // 5.If you require bridging support from JBoss Logging to JBoss LogManager, be sure to specify the appropriate system property:
        System.setProperty("org.jboss.logging.Logger.pluginClass", "org.jboss.logging.logmanager.LoggerPluginImpl");
    }

    public static void main(String[] args) {
        // commons-logging-jboss-logmanager > org.apache.commons.logging.JBossLog
        // jcl-over-slf4j > org.apache.commons.logging.impl.SLF4JLocationAwareLog
        // commons-logging > org.apache.commons.logging.impl.Log4JLogger
        // commons-logging.properties config org.apache.commons.logging.impl.Jdk14Logger
        JCL.log();
        // jboss-logmanager > org.jboss.logmanager.Logger
        JUL.log();
        // jboss-logmanager > org.jboss.logmanager.Logger
        JLog.log();
        JLog.log("");
        // jboss-logmanager > org.jboss.logging.Logger
        JLogging.log();
        // log4j-jboss-logmanager > org.apache.log4j.Logger
        // jboss-logmanager-log4j > org.jboss.logmanager.log4j.BridgeLogger, need log4j
        Log4j.log();
        // log4j2-jboss-logmanager > org.jboss.logmanager.log4j.JBossLogger
        Log4j2.log();
        // slf4j-jboss-logmanager > org.slf4j.impl.Slf4jLogger
        Slf4j.log();
    }
}
