package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.EnterTimeTrack;
import pom.LoginPage;
import repository.StepSequence;
import repository.Webobjects;

public class Test1_ValidateBuildNumber extends BaseTest {
	@Test
	public void logonScreen() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		//Step1: User logs on to required URL
		LoginPage l = new LoginPage(driver);
		Reporter.log(StepSequence.Test1Step1, true);
		
		String usr = x.getCellData(xlPath, "Test1_ValidateBuildNumber", 1, 2);
		String pwd = x.getCellData("Test1_ValidateBuildNumber","Test1", "currentPassword");
		//String pwd = x.getCellData(xlPath, "Test1_ValidateBuildNumber", 1, 2);
		
		//Step2: User logs in with valid userID and password
		l.Logon(usr, pwd);	
		Reporter.log(StepSequence.Test1Step2+usr+','+pwd);
		
		//Step3: User validates home page and confirms successful logon
		EnterTimeTrack e = new EnterTimeTrack(driver);
		e.homeScreen();
		
		//Step5: User Clicks on Menu drop down to choose 'actiTIMElink' option
		e.clickMenu();		
		//Step6: Pop up is display and script validates build number
		e.verifyBuild(Webobjects.build);
	}
}
