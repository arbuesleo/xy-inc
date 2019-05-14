package go.zup.xyinc.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.util.ResourceUtils;

public class TestUtils {
	
	public static String getFile(String fileName) {
		File file = null;
	    
		try {	
	        file = ResourceUtils.getFile("classpath:" + fileName);
	        return new String(Files.readAllBytes(file.toPath()));	        
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	    return "";
	}

}
