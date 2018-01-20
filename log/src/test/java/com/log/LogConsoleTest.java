package com.log;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import org.junit.Before;
import org.junit.Test;

import com.log.util.MyResources;

public class LogConsoleTest {

	private Logger logger = Logger.getLogger(MyResources.getProperties().get("log"));

	private OutputStream logOut;
	private StreamHandler testLogHandler;

	@Before
	public void setUp() throws Exception {
		setUpLogHandler(logger);
	}

	private void setUpLogHandler(Logger logger) {
		logOut = new ByteArrayOutputStream();
		Handler[] handlers = logger.getParent().getHandlers();
		testLogHandler = new StreamHandler(logOut, handlers[0].getFormatter());

		logger.addHandler(testLogHandler);
	}
	
	
	@Test
	public void logMessageTest() throws Exception {

		try {

			LogConsole.logMessage("message");

			testLogHandler.flush();

			String logMsg = logOut.toString();

			assertNotNull(logMsg);
			assertTrue(logMsg.toLowerCase().contains("message"));

		} finally {
			logger.removeHandler(testLogHandler);
		}
	}
	
	@Test
	public void logWarnMessageTest() throws Exception {

		try {

			LogConsole.logWarnMessage("message");

			testLogHandler.flush();

			String logMsg = logOut.toString();
			
			assertNotNull(logMsg);
			assertTrue(logMsg.toLowerCase().contains("message"));

		} finally {
			logger.removeHandler(testLogHandler);
		}
	}
	
	@Test
	public void logErrorMessageTest() throws Exception {

		try {

			LogConsole.logErrorMessage("message");

			testLogHandler.flush();

			String logMsg = logOut.toString();

			assertNotNull(logMsg);
			assertTrue(logMsg.toLowerCase().contains("message"));

		} finally {
			logger.removeHandler(testLogHandler);
		}
	}

}
