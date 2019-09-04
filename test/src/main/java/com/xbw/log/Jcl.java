package com.xbw.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Jcl {
	private static Log logger = LogFactory.getLog(Jcl.class);

	public static void main(String[] args) {
		Jcl.log();
	}

	public static void log() {
		if (logger.isFatalEnabled()) {
			logger.fatal("commons-logging fatal");
		}
		if (logger.isErrorEnabled()) {
			logger.error("commons-logging error");
		}
		if (logger.isWarnEnabled()) {
			logger.warn("commons-logging warn");
		}
		if (logger.isInfoEnabled()) {
			logger.info("commons-logging info");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("commons-logging debug");
		}
		if (logger.isTraceEnabled()) {
			logger.trace("commons-logging trace");
		}
	}

}