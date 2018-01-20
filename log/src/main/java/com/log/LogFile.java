package com.log;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.log.util.MyResources;

public class LogFile implements ILog {

	private final static Logger logger = Logger.getLogger(MyResources.getProperties().get("log"));
	private static FileHandler fh;
	private static File logFile;

	static void createFile() {

		// You must config the path and filename in log.properties
		setLogFile(new File(MyResources.getProperties().get("filePath") + MyResources.getProperties().get("fileName")));

		try {
			setFh(new FileHandler(
					MyResources.getProperties().get("filePath") + MyResources.getProperties().get("fileName")));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void logMessage(String messageText) {
		logger.addHandler(fh);
		logger.log(Level.INFO, messageText);
	}

	static void logErrorMessage(String messageText) {
		logger.addHandler(fh);
		logger.log(Level.SEVERE, messageText);
	}

	static void logWarnMessage(String messageText) {
		logger.addHandler(fh);
		logger.log(Level.WARNING, messageText);
	}

	public static FileHandler getFh() {
		return fh;
	}

	public static void setFh(FileHandler fh) {
		LogFile.fh = fh;
	}

	public static File getLogFile() {
		return logFile;
	}

	public static void setLogFile(File logFile) {
		LogFile.logFile = logFile;
	}

}
