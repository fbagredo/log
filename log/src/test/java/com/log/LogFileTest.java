package com.log;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.log.util.MyResources;


public class LogFileTest {
	
	BufferedReader br = null;
	FileReader fr = null;


	@Test
	public void logMessageTest() throws Exception {

		try {
			
			LogFile.createFile();
			LogFile.logMessage("message");
			
			fr = new FileReader(MyResources.getProperties().get("filePath") + MyResources.getProperties().get("fileName"));
			br = new BufferedReader(fr);

			String file=null;
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				file += sCurrentLine;
			}

			assertTrue(file.contains("message"));

		} catch(IOException e) {
			LogConsole.logErrorMessage(e.getMessage());
		}
			
		}
	
	
	@Test
	public void logWarnMessageTest() throws Exception {

		try {

			LogFile.createFile();
			LogFile.logWarnMessage("message");
			
			fr = new FileReader(MyResources.getProperties().get("filePath") + MyResources.getProperties().get("fileName"));
			br = new BufferedReader(fr);

			String file=null;
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				file += sCurrentLine;
			}

			assertTrue(file.contains("message"));

		} catch(IOException e) {
			LogConsole.logErrorMessage(e.getMessage());
		}
	}
	
	@Test
	public void logErrorMessageTest() throws Exception {

		try 		{	
		LogFile.createFile();
		LogFile.logErrorMessage("message");
				
		fr = new FileReader(MyResources.getProperties().get("filePath") + MyResources.getProperties().get("fileName"));
		br = new BufferedReader(fr);

		String file = null;
		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {
			file += sCurrentLine;
		}

		assertTrue(file.contains("message"));

	} catch(IOException e) {
		LogConsole.logErrorMessage(e.getMessage());
	}
	}
}
	