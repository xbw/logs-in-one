package com.xbw.log;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * only for
 * 
 * <groupId>org.slf4j</groupId>
 * <artifactId>jul-to-slf4j</artifactId>
 * 
 * @author xbw
 *
 */
public class JulToSlf4j {
	private static Logger logger = Logger.getLogger(JulToSlf4j.class.getName());
	private static LogManager logManager = LogManager.getLogManager();

	public JulToSlf4j() {
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
		JulToSlf4j.log();
		System.out.println("========================>");
		new JulToSlf4j().logAll();
	}

	public void logAll() {
		JulToSlf4j.log();
	}

	public static void log() {
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
		logger.severe("java.util.logging SEVERE");// 严重
		logger.warning("java.util.logging WARNING");// 警告
		logger.info("java.util.logging INFO");// 信息
		logger.config("java.util.logging CONFIG");// 配置
		logger.fine("java.util.logging FINE");// 详细
		logger.finer("java.util.logging FINER");// 较详细
		logger.finest("java.util.logging FINEST");// 非常详细
	}
}