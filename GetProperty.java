package utilities;

import java.io.IOException;
import java.util.Set;

public class GetProperty extends LoadProperties {
	
	//To obtain current URL value from key-value pair present in LoadProperties file
	public static String returnValue;
		
	public static String PropertyKey(String PropKey) throws IOException {		
		Set<String> k1 = (Set<String>) new LoadProperties().keyValue();		
		for(String s1:k1) {
			if(s1.equals(PropKey))
				returnValue=p.getProperty(s1);
		}
		System.out.println(returnValue);
		return returnValue;	
	}
}