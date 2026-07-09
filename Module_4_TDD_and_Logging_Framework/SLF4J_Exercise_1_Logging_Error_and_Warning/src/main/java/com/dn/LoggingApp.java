package com.dn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingApp {
    
    private static final Logger appLogger = LoggerFactory.getLogger(LoggingApp.class);
    
    public static void main(String[] args) {
        appLogger.info("Starting up the Logging Application...");
        
        try {
            executeSystemCheck();
        } catch (Exception ex) {
            appLogger.error("A critical system error occurred during startup.", ex);
        }
        
        appLogger.info("Application execution finished.");
    }
    
    private static void executeSystemCheck() throws Exception {
        appLogger.debug("Performing initial diagnostic checks.");
        appLogger.warn("System memory is running below optimal thresholds (Warning).");
        
        throw new Exception("Simulated Diagnostic Failure");
    }
}
