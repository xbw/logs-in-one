package com.xbw.log;

import java.util.logging.Logger;

/**
 * 
 * @author xbw
 *
 */
public class JulCustom {
	static {
		System.setProperty("java.util.logging.config.file",
				JulCustom.class.getClassLoader().getResource("logging.properties").getPath());
	}

	private static Logger logger = Logger.getLogger(JulCustom.class.getName());

	public static void main(String[] args) {
		JulCustom.log();
	}

	public static void log() {
		logger.severe("java.util.logging SEVERE");// 严重
		logger.warning("java.util.logging WARNING");// 警告
		logger.info("java.util.logging INFO");// 信息
		logger.config("java.util.logging CONFIG");// 配置
		logger.fine("java.util.logging FINE");// 详细
		logger.finer("java.util.logging FINER");// 较详细
		logger.finest("java.util.logging FINEST");// 非常详细
	}
}