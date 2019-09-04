package com.xbw.log;

import com.xbw.log.jcl.JCL;
import org.apache.avalon.framework.logger.ConsoleLogger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.AvalonLogger;
import org.apache.log4j.BasicConfigurator;

public class Main {
    static {
        // Log4JLogger based configuration
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        JCL.log();
//        avalonLogger();
    }

    /**
     * commons-logging.properties 中配置以下
     * org.apache.commons.logging.Log = org.apache.commons.logging.impl.AvalonLogger
     * 报Exception in thread "main" java.lang.ExceptionInInitializerError
     */
    public static void avalonLogger() {
        Log logger = new AvalonLogger(new ConsoleLogger());
        logger.error("error");
    }

}
