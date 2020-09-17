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
        Config.jul2JBossLog();
        System.setProperty("org.jboss.logging.provider","slf4j");
    }

    public static void main(String[] args) {
        JCL.log();
        // jul --> slf4j --> log4j
        Config.jul2Slf4J();
        JUL.log();
        // jboss logmanager --> jul --> slf4j --> log4j, org.jboss.logmanager.Logger
        JLog.log();
        // jboss logging --> jboss logmanager --> jul --> slf4j -->l og4j
        // jboss logging --> log4j2 --> slf4j --> log4j
        JLogging.log();
        Log4j.log();
        Log4j2.log();
        Slf4j.log();
    }
}
