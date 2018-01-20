package com.log;

import static org.junit.Assert.*;

import static org.mockito.Matchers.*;

import static org.mockito.Mockito.*;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.sql.DataSource;

import com.log.DAO.LogDAO;
import com.log.data.LogVO;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class LogDataBaseTest {

	@Mock
	private DataSource ds;

	@Mock
	private Connection c;

	@Mock
	private PreparedStatement stmt;

	@Mock
	private ResultSet rs;

	private LogVO logVOMessage;
	private LogVO logVOWarning;
	private LogVO logVOerror;

	@Before

	public void setUp() throws Exception {

		assertNotNull(ds);

		when(c.prepareStatement(any(String.class))).thenReturn(stmt);

		when(ds.getConnection()).thenReturn(c);

		logVOMessage = new LogVO();
		logVOMessage.setIdlevel(1);
		logVOMessage.setMessage("message");
		
		logVOWarning = new LogVO();
		logVOWarning.setIdlevel(2);
		logVOWarning.setMessage("message");
		
		logVOerror = new LogVO();
		logVOerror.setIdlevel(3);
		logVOerror.setMessage("message");

		when(stmt.executeQuery()).thenReturn(rs);

	}

	@Test
	public void insertMessageLog() {

		LogDataBase.setLogDAO(new LogDAO(ds));
		LogDataBase.logMessage(logVOMessage);

	}
	
	@Test
	public void insertWarningLog() {

		LogDataBase.setLogDAO(new LogDAO(ds));
		LogDataBase.logMessage(logVOWarning);

	}
	
	@Test
	public void insertErrorLog() {

		LogDataBase.setLogDAO(new LogDAO(ds));
		LogDataBase.logMessage(logVOerror);

	}

}
