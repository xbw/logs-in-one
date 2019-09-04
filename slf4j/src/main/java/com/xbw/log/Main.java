package com.xbw.log;

import com.xbw.log.slf4j.Slf4j;
import org.apache.log4j.BasicConfigurator;

public class Main {
    static {
        // Log4JLogger based configuration
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        Slf4j.log();
    }
}
