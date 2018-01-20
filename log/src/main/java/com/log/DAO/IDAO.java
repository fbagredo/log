package com.log.DAO;

import java.io.Serializable;
import java.util.List;

public interface IDAO <T, K extends Serializable> {  
	    List<T> getAll(Class<T> typeClass);   
	    T findByKey(Class<T> typeClass, K id);  
	    void update(T object);  
	    void remove(T object);  
	    void insert(T object);  

}
