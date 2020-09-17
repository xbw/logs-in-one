package com.xbw.log;

import org.jboss.logging.Logger;

public class JbossLog {
	private static final Logger logger = Logger.getLogger(JbossLog.class);

	public static void main(String[] args) {
		for (int i = 0; i < 5000; i++) {
			JbossLog.log();
		}
	}

	public static void log() {

		logger.fatal("org.jboss.logging fatal");
		logger.error("org.jboss.logging error");
		logger.warn("org.jboss.logging warn");
		if (logger.isInfoEnabled()) {
			logger.info("org.jboss.logging info");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("org.jboss.logging debug");
		}
		if (logger.isTraceEnabled()) {
			logger.trace("org.jboss.logging trace");
		}
	}

}
