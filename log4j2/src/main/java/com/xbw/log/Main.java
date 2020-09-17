package com.xbw.log;

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
        Config.jul2Log4j2();
        Config.jul2Slf4J();
        System.setProperty("org.jboss.logging.provider", "log4j2");
    }

    public static void main(String[] args) {
        Config.jul2JBossLog();
        JCL.log();
        // when exist jboss-logmanager, org.jboss.logmanager.Logger
        // when not exist Config.jul2Log4j2();, java.util.logging.Logger
        // other, org.apache.logging.log4j.jul.CoreLogger
        JUL.log();
        JLogging.log();
        Log4j.log();
        Log4j2.log();
        Slf4j.log();
    }
}
