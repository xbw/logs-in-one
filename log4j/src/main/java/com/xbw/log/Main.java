package com.xbw.log;

import com.xbw.log.jboss.JLog;
import com.xbw.log.jboss.JLogging;
import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.log4j2.Log4j2;
import com.xbw.log.slf4j.Slf4j;
import org.apache.logging.julbridge.JULLog4jBridge;

public class Main {
    static {
        // http://people.apache.org/~psmith/logging.apache.org/sandbox/jul-log4j-bridge/examples.html
        // jul --(apache-jul-log4j-bridge)--> log4j
//        System.setProperty("java.util.logging.manager", "org.apache.logging.julbridge.JULBridgeLogManager");

        System.setProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager");
    }

    public static void main(String[] args) {
        JCL.log();
        // if no JULLog4jBridge , need jul-to-slf4j
        // Bridge all class
        JULLog4jBridge.assimilate();
        // Bridge custom class
//        JULLog4jBridge.bridgeJULLogger(JUL.class.getName());
        JUL.log();
        // jboss log --(jboss-logbridge+log4j)--> log4j
        // jboss log --(jboss-logmanager-log4j+jboss-logmanager)--> log4j
        JLog.log();
        JLogging.log();
        Log4j.log();
//        Log4j.custom();
        // log4j2 --(log4j-to-slf4j)--> slf4j --(slf4j-log4j12)--> log4j org.apache.logging.slf4j.SLF4JLogger
        // log4j2 --(log4j2-jboss-logmanager)--> jboss log --(jboss-logbridge)--> log4j org.jboss.logmanager.log4j.JBossLogger
        Log4j2.log();
        Slf4j.log();
    }
}
