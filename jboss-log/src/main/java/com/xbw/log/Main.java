package com.xbw.log;

import com.xbw.log.jboss.JLog;
import com.xbw.log.jboss.JLogging;
import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.log4j2.Log4j2;
import com.xbw.log.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

public class Main {
    static {
        // https://developer.jboss.org/docs/DOC-13898

        // 2. Specify the alternate log manager as a system property, either on the command-line or as a part of your early boot process:
        // -Djava.util.logging.manager=org.jboss.logmanager.LogManager
        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");

        // 3. Specify your logging configuration properties (see JBossBootLogging for information about how to set up this properties file).
        // https://developer.jboss.org/docs/DOC-10235
//        System.setProperty("logging.configuration", "file:logging.properties");

        // 4.1. Specify the special system property to disable automatic log4j configuration:
        System.setProperty("log4j.defaultInitOverride", "true");

        // 5.If you require bridging support from JBoss Logging to JBoss LogManager, be sure to specify the appropriate system property:
        System.setProperty("org.jboss.logging.Logger.pluginClass", "org.jboss.logging.logmanager.LoggerPluginImpl");
    }

    public static void main(String[] args) {
        JCL.log();
        JUL.log();
        JLog.log();
        JLogging.log();
        Log4j.log();
        Log4j2.log();
        Slf4j.log();
    }
}
