package com.xbw.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4j {
	private static Logger logger = LoggerFactory.getLogger(Slf4j.class);

	public static void main(String[] args) {
		Slf4j.log();
	}

	public static void log() {
		if (logger.isErrorEnabled()) {
			logger.error("org.slf4j error");
		}
		if (logger.isWarnEnabled()) {
			logger.warn("org.slf4j warn");
		}
		if (logger.isInfoEnabled()) {
			logger.info("org.slf4j info");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("org.slf4j debug");
		}
		if (logger.isTraceEnabled()) {
			logger.trace("org.slf4j trace");
		}
	}

}