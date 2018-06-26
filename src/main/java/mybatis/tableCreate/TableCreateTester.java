package mybatis.tableCreate;

import java.util.HashMap;
import java.util.List;

import mybatis.dbSelect.model.User;
import mybatis.dbSelect.utils.DataSourceContextHolder;
import mybatis.tableCreate.dao.TesterMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用Springtest框架 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_mybatis_tbl_create.xml")
public class TableCreateTester {
	
	// 注入 
    @Autowired   
    private TesterMapper testerMapper; 

	/**
	 * @return the testerMapper
	 */
	public TesterMapper getTesterMapper() {
		return testerMapper;
	}

	/**
	 * @param testerMapper the testerMapper to set
	 */
	public void setTesterMapper(TesterMapper testerMapper) {
		this.testerMapper = testerMapper;
	}

	@Test
    public void testCreateTable() {
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		
		params.put("tablename", "t_test123");
		//testerMapper.testCreateTable(params); 
    }
}
