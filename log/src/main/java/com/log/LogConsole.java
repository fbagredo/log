package com.log;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.log.util.MyResources;

public class LogConsole implements ILog {
	
	private final static Logger logger = Logger.getLogger(MyResources.getProperties().get("log"));

	static void logMessage(String messageText) {
		logger.log(Level.INFO, messageText);
	}
	
	static void logWarnMessage(String messageText){
		logger.log(Level.WARNING, messageText);
	}
	
	static void logErrorMessage(String messageText){
		logger.log(Level.SEVERE, messageText);
	}
}
