package com.log;

import java.text.DateFormat;
import java.util.Date;

import com.log.DAO.ILogDAO;
import com.log.data.LogVO;

public class LogDataBase implements ILog {
	
	private static ILogDAO logDAO;
	
	static void logMessage(LogVO logVO) {
		logVO.setMessage(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " " + logVO.getMessage());
		logDAO.insert(logVO);
	}

	public static ILogDAO getLogDAO() {
		return logDAO;
	}

	public static void setLogDAO(ILogDAO logDAO) {
		LogDataBase.logDAO = logDAO;
	}
	
}
