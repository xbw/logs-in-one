package com.xbw.log;

import com.xbw.log.jboss.JLog;
import com.xbw.log.jboss.JLogging;
import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.slf4j.Slf4j;

/**
 * @author xbw
 */
public class Main {
    static {
        Config.jul2JBossLog();
        System.setProperty("org.jboss.logging.provider","log4j");
    }

    public static void main(String[] args) {
        // when exist jcl-over-slf4j > org.apache.commons.logging.impl.SLF4JLocationAwareLog
        // when exist commons-logging > org.apache.commons.logging.impl.Log4JLogger
        JCL.log();
        // when exist jboss-logmanager+System Property, org.jboss.logmanager.Logger
        // when exist jboss-logging, jboss-logging > java.util.logging.Logger
//        jul2Log4j();
        Config.jul2Slf4J();
        JUL.log();
        // org.jboss.logmanager.Logger
        // when use apache-jul-log4j-bridge, jboss log --> jul --(apache-jul-log4j-bridge)--> log4j
        // when use jul-to-slf4j,jul --(jul-to-slf4j)--> slf4j --(slf4j-log4j12)--> log4j
        JLog.log();
        // when exist jboss-logmanager, jboss-logging > org.jboss.logging.JBossLogManagerLogger
        // when exist log4j-to-slf4j, jboss-logging > org.jboss.logging.Log4j2Logger
        // when exist jboss-logging-log4j or log4j, jboss-logging > org.jboss.logging.Log4jLogger
        // when System.setProperty("org.jboss.logging.provider","log4j");, jboss-logging > org.jboss.logging.Log4jLogger
        JLogging.log();
        // org.apache.log4j.Logger
        Log4j.log();
        Log4j.custom();
        // log4j2 --(log4j2-jboss-logmanager)--> jboss log --> jul --(apache-jul-log4j-bridge)--> log4j org.jboss.logmanager.log4j.JBossLogger
        // log4j2 --(log4j-to-slf4j)--> slf4j --(slf4j-log4j12)--> log4j org.apache.logging.slf4j.SLF4JLogger,org.jboss.logging.Log4j2LoggerProvider
//        Log4j2.log();
        // org.slf4j.impl.Log4jLoggerAdapter
        Slf4j.log();
    }


    private static void jul2Log4j() {
        // http://people.apache.org/~psmith/logging.apache.org/sandbox/jul-log4j-bridge/examples.html

        // Example 1 - Completely take over JUL and route all LogRecords into log4j
        org.apache.logging.julbridge.JULLog4jBridge.assimilate(); // Bridge all class

        // Example 3 - Bridge a single JUL Logger
//        org.apache.logging.julbridge.JULLog4jBridge.bridgeJULLogger(JUL.class.getName()); // Bridge custom class, Print twice

        // Example 4 - Completely take over JUL and route all LogRecords into log4j by using a System property
        // -Djava.util.logging.manager=org.apache.logging.julbridge.JULBridgeLogManager
//        System.setProperty("java.util.logging.manager", "org.apache.logging.julbridge.JULBridgeLogManager");
    }
}
