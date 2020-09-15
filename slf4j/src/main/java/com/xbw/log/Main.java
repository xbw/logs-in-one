package com.xbw.log;

import com.xbw.log.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

public class Main {
    static {
        try {
            BasicConfigurator.configure();
        } catch (NoClassDefFoundError e) {
            // log4j is provided
        }
    }

    public static void main(String[] args) {
        Slf4j.log();
    }
}
