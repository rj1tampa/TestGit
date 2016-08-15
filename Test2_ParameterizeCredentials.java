package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.LoginPage;

public class Test2_ParameterizeCredentials extends BaseTest {
	@Test
	public void multipleUsers() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		String usr="";
		String passwd="";
		String cName="";
		int UNcolumn = 0;
		int PWDcolumn = 0;
		//Step1: User logs on to required URL
		LoginPage l = new LoginPage(driver);
		Reporter.log("Step1: User logs on to ActiTime URL", true);
		//Obtain lastRow
		int lastRowNum = x.getLastRow(xlPath,"Test2_ParameterizeCredentials");
		int lastCellNum = x.fileIp().getSheet("Test2_ParameterizeCredentials").getRow(0).getLastCellNum();
   		for(int colNumUsr=0;colNumUsr<lastCellNum;colNumUsr++) {
   			cName = x.getCellData(xlPath,"Test2_ParameterizeCredentials", 0,colNumUsr);//0,0
			if(cName.equalsIgnoreCase("currentUserName"))
   				UNcolumn=colNumUsr;
			if(cName.equalsIgnoreCase("currentPassword"))
   				PWDcolumn=colNumUsr;
				//PWDcolumn=x.getCellData(xlPath, "Test2_ParameterizeCredentials",j,UNcolumn);//0,0			
   		}
   		for(int row=1;row<=lastRowNum;row++) {
   			usr = x.getCellData(xlPath,"Test2_ParameterizeCredentials",row,UNcolumn);
   			passwd = x.getCellData(xlPath,"Test2_ParameterizeCredentials",row,PWDcolumn);
				//Step2: User logs in with valid userID and password
				l.Logon(usr, passwd);	
				//Reporter.log("Step2: User logs in with valid userID = '"+usr+"' and password = '"+passwd+"'");		
		}
	}	
}
