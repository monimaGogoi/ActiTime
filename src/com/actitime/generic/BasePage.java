package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
//declaration
	public WebDriver driver;
	
//initialization
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
//utilization
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching "+eTitle,true);
			
		}
		catch(Exception e)
		{
			Reporter.log(eTitle+" does not match with "+driver.getTitle(),true);
			Assert.fail();
		}
	}
	
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present",true);
			
		}
		catch(Exception e)
		{
			Reporter.log("element not present",true);
			Assert.fail();
		}
	}
	
}
