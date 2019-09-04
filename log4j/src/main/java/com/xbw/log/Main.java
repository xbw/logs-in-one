package com.xbw.log;

import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;

public class Main {
    // http://people.apache.org/~psmith/logging.apache.org/sandbox/jul-log4j-bridge/examples.html
    static {
        System.setProperty("java.util.logging.manager", "org.apache.logging.julbridge.JULBridgeLogManager");
    }

    public static void main(String[] args) {
        JCL.log();
//        JULLog4jBridge.assimilate();
        JUL.log();
        Log4j.log();
//        Log4j.custom();
    }
}
