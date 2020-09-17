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
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
        System.setProperty("org.jboss.logging.Logger.pluginClass", "org.jboss.logging.jdk.JDK14LoggerPlugin");
    }

    public static void main(String[] args) {
        Config.julLevelAll(true);
        JCL.log();
        JUL.log();
        JLogging.log();
        Log4j.log();
        Log4j2.log();
        Slf4j.log();
    }

}
