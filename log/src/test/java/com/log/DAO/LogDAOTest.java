package com.log.DAO;

import static org.junit.Assert.*;

import static org.mockito.Matchers.*;

import static org.mockito.Mockito.*;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.sql.DataSource;

import com.log.data.LogVO;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class LogDAOTest {

	@Mock
	private DataSource ds;

	@Mock
	private Connection c;

	@Mock
	private PreparedStatement stmt;

	@Mock
	private ResultSet rs;

	private LogVO logVO;

	@Before

	public void setUp() throws Exception {

		assertNotNull(ds);

		when(c.prepareStatement(any(String.class))).thenReturn(stmt);

		when(ds.getConnection()).thenReturn(c);

		logVO = new LogVO();

		logVO.setIdlevel(1);

		logVO.setMessage("message");

		when(stmt.executeQuery()).thenReturn(rs);

	}

	@Test

	public void insertLog() {

		new LogDAO(ds).insert(logVO);

	}

}
