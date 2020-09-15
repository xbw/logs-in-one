package com.xbw.log;

import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.log4j2.Log4j2;
import com.xbw.log.slf4j.Slf4j;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class Main {
    static {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
    public static void main(String[] args) {
        JCL.log();
        JUL.log();
        Log4j.log();
//        Log4j.custom();
        Log4j2.log();
        Slf4j.log();
    }
}
