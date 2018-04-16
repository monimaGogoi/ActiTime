package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generic.BasePage;

public class LoginPage extends BasePage
{
	//declaration
	@FindBy(name="username")
	private WebElement usernameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="(//nobr[contains(.,'actiTIME')])[1]")
	private WebElement version;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;
	
	
	//initialization
	public LoginPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);	
	}
	
	//utilization
	public void enterUserName(String un)
	{
		usernameTB.sendKeys(un);
	}

	public void enterPassword(String pw)
	{
		passwordTB.sendKeys(pw);
	}
	
	public void clickLoginBTN()
	{
		loginBTN.click();
	}
	
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public String verifyErrorMessage()
	{
		verifyElement(errMsg);
		//get the error message
		String aErrorMessage = errMsg.getText();
		Reporter.log("Error Message is: "+aErrorMessage,true);
		return aErrorMessage;
	}
	
	public String verifyVersion()
	{
		String aVersion = version.getText();
		Reporter.log("Version number is: "+aVersion,true);
		return aVersion;
	}
	
}
