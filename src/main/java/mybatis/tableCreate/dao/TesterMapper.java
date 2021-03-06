package mybatis.tableCreate.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mybatis.dbSelect.model.User;


/**
 * @date 2017-06-29 04:24:25
 * @version 1.0
 */
 
 public interface TesterMapper {
	
	/**
	 * 查询列表
	 * @param params
	 * @return list<User>
	 */
	public void testCreateTable(HashMap<Object, Object> params);
 }