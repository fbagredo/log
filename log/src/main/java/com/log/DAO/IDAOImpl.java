package com.log.DAO;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

public class IDAOImpl <T, K extends Serializable> implements IDAO<T, K>{
    
    private DataSource ds;
    
	public IDAOImpl(DataSource ds) {
		super();
		this.setDs(ds);
	}

	@Override
	public List <T>getAll(Class<T> typeClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public T findByKey(Class typeClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Object object) {
		// TODO Auto-generated method stub
		
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
    
}
