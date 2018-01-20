package com.log.DAO;

import javax.sql.DataSource;

import com.log.data.LogVO;

public class LogDAO extends IDAOImpl<LogVO, Long> implements ILogDAO {

	public LogDAO(DataSource ds) {
		super(ds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogVO findByKey(Class<LogVO> typeClass, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(LogVO object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(LogVO object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LogVO object) {
		// TODO Auto-generated method stub
		
	}



}