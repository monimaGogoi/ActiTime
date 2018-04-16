package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.actitime.generic.BasePage;
import com.actitime.generic.GenericUtils;

public class EnterTimeTrackPage extends BasePage {
	

	//declaration
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutBTN;
	
	@FindBy(xpath="//div[contains(@class,'popup_menu_icon support_icon')]")
	private WebElement helpBTN;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement abtActitimeLink;
	
	@FindBy(xpath="//span[contains(text(),'build')]")
	private WebElement buildVersion;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	//initialization
	public EnterTimeTrackPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	
	public void logout()
	{
		logoutBTN.click();
	}
	
	public void clickHelp()
	{
		helpBTN.click();
	}
	
	public void aboutActitimeLink()
	{
		abtActitimeLink.click();
	}
	
	public String handlePopup()
	{
		String text = GenericUtils.hiddenDisionPopup(buildVersion,closeBTN);
		return text;
	}
	
	
}
