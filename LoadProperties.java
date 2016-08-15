package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class LoadProperties extends Xcel {

	public  Set<String> s;
	public static  Properties p;
	Enumeration<?> e1;
	
	public Set<String> keyValue() throws IOException {
		
		FileInputStream fis=new FileInputStream("E:\\BSSM3.NEWFRAMEWORK/Automation/properties/Property");
		p=new Properties();
		p.load(fis);
		// 1st method
		s = p.stringPropertyNames();
		return s;
	}
}
