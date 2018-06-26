package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用Springtest框架 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_default.xml")
public class ArrayTester {

	@Test
	public void array2List() {
		HashMap<String,String> extMap = new HashMap<String,String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		
		List<String> list = Arrays.<String>asList(extMap.get("image").split(","));
		
		System.out.println("list: " + list.toString());
	}
}
