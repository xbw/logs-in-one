package com.xbw.log;

import com.xbw.log.slf4j.Slf4j;

/**
 * @author xbw
 */
public class Main {
    static {
//        System.out.println("logging.configuration = " + Config.jBossLogConfiguration("jboss-logmanager"));

        try {
            org.apache.log4j.BasicConfigurator.configure();
        } catch (NoClassDefFoundError e) {
            // log4j is provided
        }
    }

    /**
     * order by:
     * Maven pom.xml order
     */
    public static void main(String[] args) {
        Slf4j.log();
    }
}
