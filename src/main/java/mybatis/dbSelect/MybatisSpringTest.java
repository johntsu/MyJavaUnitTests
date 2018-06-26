package mybatis.dbSelect;

import java.util.List;

import mybatis.dbSelect.dao.UserMapper;
import mybatis.dbSelect.model.User;
import mybatis.dbSelect.utils.DataSourceContextHolder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用Springtest框架 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_dbSelect.xml")
public class MybatisSpringTest {
	
	// 注入 
    @Autowired   
    private UserMapper userMapper; 
    
    public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Test
    public void getDs1User() {
        DataSourceContextHolder.setDbType("ds1");     //注意这里在调用userMapper前切换到ds1的数据源  
        
        List<User> list = userMapper.queryList();  
        System.out.println(list.get(0).toString());  
    }
    
    @Test
    public void getDs2User() {
        DataSourceContextHolder.setDbType("ds2");     //注意这里在调用userMapper前切换到ds1的数据源  
        
        List<User> list = userMapper.queryList();  
        System.out.println(list.get(0).toString());  
    }
}
