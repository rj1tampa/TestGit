package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import repository.Webobjects;
import utilities.Xcel;

public class LoginPage extends Xcel {
	@FindBy(id=Webobjects.userName)
	private WebElement userName;
	
	@FindBy(name=Webobjects.pwd)
	private WebElement password;
	
	@FindBy(id=Webobjects.loginButton)
	private WebElement loginButton;
	
	@FindBy(xpath=Webobjects.Error)
	private WebElement Error;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void Logon(String un, String pd) throws InterruptedException{
		userName.sendKeys(un);
		password.sendKeys(pd);
		loginButton.click();
		Thread.sleep(10000);
	}
	
	public void ErrorMsg() {
		Assert.assertTrue(Error.isDisplayed());
	}
	
}
