package com.xbw.log;

import java.util.logging.Logger;

/**
 * only for
 * 
 * <groupId>org.apache.logging.log4j</groupId>
 * <artifactId>log4j-jul</artifactId>
 * 
 * @author xbw
 *
 */
public class JulToLog4j2 {
	/*
	 * Use either
	 * -Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager or
	 * uncomment the static initializer below.
	 */
	static {
		System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
	}

	// This is the JUL Adapter implemented for this class.
	private static Logger logger = Logger.getLogger(JulToLog4j2.class.getName());

	public static void main(String[] args) {
		JulToLog4j2.log();
	}

	public static void log() {
		logger.severe("java.util.logging SEVERE");
		logger.warning("java.util.logging WARNING");
		logger.info("java.util.logging INFO");
		logger.config("java.util.logging CONFIG");
		logger.fine("java.util.logging FINE");
		logger.finer("java.util.logging FINER");
		logger.finest("java.util.logging FINEST");
	}

}