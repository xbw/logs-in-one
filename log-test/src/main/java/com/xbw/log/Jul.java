package com.xbw.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;


/**
 * 
 * @author xbw
 *
 */
public class Jul {
	private static Logger logger = Logger.getLogger(Jul.class.getName());
	private static LogManager logManager = LogManager.getLogManager();

	public Jul() {
		InputStream inputStream = null;
		try {
			// 读取配制文件
			inputStream = getClass().getClassLoader().getResourceAsStream("logging.properties");
			logManager.readConfiguration(inputStream);
			// 添加Logger
			logManager.addLogger(logger);

		} catch (SecurityException e) {
			logger.severe(e.getMessage());
		} catch (IOException e) {
			logger.severe(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Jul.log();
		System.out.println("========================>");
		new Jul().logAll();
	}

	public void logAll() {
		Jul.log();
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