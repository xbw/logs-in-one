package com.xbw.log;

import com.xbw.log.jcl.JCL;
import com.xbw.log.jul.JUL;
import com.xbw.log.log4j.Log4j;
import com.xbw.log.log4j2.Log4j2;
import com.xbw.log.slf4j.Slf4j;

public class Main {
    static {
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }

    public static void main(String[] args) {
        JCL.log();
        JUL.log();
        Log4j.log();
        Log4j2.log();
        Slf4j.log();
    }
}
