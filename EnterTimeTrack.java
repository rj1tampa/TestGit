package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import repository.Webobjects;


public class EnterTimeTrack {

	@FindBy(xpath=Webobjects.EnterTimeTrackText)
	private WebElement EnterTimeTrackText;
	
	@FindBy(xpath=Webobjects.dropdownArrow)
	private WebElement dropdownArrow;
	
	@FindBy(linkText=Webobjects.actiTIMElink)
	private WebElement actiTIMElink;
	
	@FindBy(xpath=Webobjects.buildNumber)
	private WebElement buildNumber;
	
	//initialization
	public EnterTimeTrack(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	public void homeScreen() {
		Assert.assertEquals(EnterTimeTrackText.getText(),Webobjects.homeScreenAssertion);
		Reporter.log("Step3: User validates 'EnterTimeTrack' page and confirms successful logon");
	}
	
	public void clickMenu() {
		dropdownArrow.click();
		actiTIMElink.click();
		Reporter.log("Step4: User clicks on 'dropdownArrow' menu to select 'actiTIMElink'", true);
	}
	
	public void verifyBuild(String expectedBuildNum) {		
		String actualBuildNumber=buildNumber.getText();
		Assert.assertEquals(expectedBuildNum, actualBuildNumber);
		Reporter.log("Step5: Build# displayed on screen = "+actualBuildNumber, true);
	}
}