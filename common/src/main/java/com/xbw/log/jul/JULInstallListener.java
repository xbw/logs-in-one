package com.xbw.log.jul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContextListener implementation class JULInstallListener
 *
 * @author xbw
 */
@WebListener
public class JULInstallListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(JULInstallListener.class);

//    @PostConstruct
    public void init() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        if (logger.isDebugEnabled()) {
            logger.debug("JULInstallListener contextInitialized");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        if (logger.isDebugEnabled()) {
            logger.debug("JULInstallListener contextDestroyed");
        }
    }

}