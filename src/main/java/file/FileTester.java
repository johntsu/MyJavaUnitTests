package file;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

//使用Springtest框架 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext_default.xml")
public class FileTester {
	
	@Test
	public void getMultipartFileMd5(){
		String path = "D:\\adt-bundle-windows-x86_64-20140702.zip";
		File file = new File(path);
		File
		
		//MultipartFile file = new MultipartFile("upload");
	}

}
