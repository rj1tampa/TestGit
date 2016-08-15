package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import repository.Config;
import utilities.GetProperty;
import utilities.Xcel;

public class BaseTest extends GetProperty {	
	Xcel x= new Xcel();
	WebDriver driver;
	String url="";
	
	@BeforeMethod
	public void openBrowser() throws IOException {	
		//Obtains handle of Browser
		driver=new FirefoxDriver();
		//Obtains URL from properties file
		url=PropertyKey(Config.currentURL);
		Reporter.log(url);
		//Opens the Browser with required URL 
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed successfully");
		Reporter.log(url, true);
	}
}