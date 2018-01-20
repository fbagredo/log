package com.log.DAO;

import com.log.data.LogVO;

public interface ILogDAO extends IDAO<LogVO, Long>{
	
	void update(LogVO object); 

}
