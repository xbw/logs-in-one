package com.xbw.log;

import org.apache.log4j.Logger;

public class Log4j {
	private static final Logger logger = Logger.getLogger(Log4j.class);

	public static void main(String[] args) {
		Log4j.log();
	}

	public static void log() {
		logger.fatal("org.apache.log4j fatal");
		logger.error("org.apache.log4j error");
		logger.warn("org.apache.log4j warn");
		if (logger.isInfoEnabled()) {
			logger.info("org.apache.log4j info");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("org.apache.log4j debug");
		}
		if (logger.isTraceEnabled()) {
			logger.trace("org.apache.log4j trace");
		}
	}

}