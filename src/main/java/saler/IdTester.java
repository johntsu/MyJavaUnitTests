package saler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用Springtest框架 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_default.xml")
public class IdTester {
	
	@Test
	public void testNewSalerId() {
		String oldSalerId = "SJ00000001";
		
		int iSalerId = Integer.parseInt(oldSalerId.substring(2));
		iSalerId++;
		
		//补全0
		String salerId = String.valueOf(iSalerId);
		int zeroLen = 8-salerId.length();
		for(int i = 0; i < zeroLen; i++) {
			salerId = "0" + salerId;
		}
		
		salerId = "SJ" + salerId;
		
		System.out.println("new saler id:" + salerId);
	}
}
