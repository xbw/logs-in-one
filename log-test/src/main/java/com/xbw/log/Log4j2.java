package com.xbw.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {
	private static final Logger logger = LogManager.getLogger(Log4j2.class.getName());

	public static void main(String[] args) {
		Log4j2.log();
	}

	public static void log() {
		if (logger.isFatalEnabled()) {
			logger.fatal("org.apache.logging.log4j fatal");
		}
		if (logger.isErrorEnabled()) {
			logger.error("org.apache.logging.log4j error");
		}
		if (logger.isWarnEnabled()) {
			logger.warn("org.apache.logging.log4j warn");
		}
		if (logger.isInfoEnabled()) {
			logger.info("org.apache.logging.log4j info");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("org.apache.logging.log4j debug");
		}
		if (logger.isTraceEnabled()) {
			logger.trace("org.apache.logging.log4j trace");
		}
	}

}