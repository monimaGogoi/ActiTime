package com.actitime.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils {
	
	//handling screenshot
	public static void getSceenShot(WebDriver driver,String name)
	{
		try {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+name+".png");
		//copy source to destination
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//handling listbox
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement element,String val)
	{
		Select sel=new Select(element);
		sel.selectByValue(val);
	}
	
	public static void selectByVisibleText(WebElement element,String vt)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(vt);
	}
	
	public static void selectAllOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allOptions=sel.getOptions();
		for(int i=0;i<=allOptions.size();i++)
		{
			//allOptions.get(i);
			sel.selectByIndex(i);
		}
		
		sel.getAllSelectedOptions();
	}
	
	public static void deselectALL(WebElement element)
	{
		Select sel=new Select(element);
		sel.deselectAll();
	}
	
	public static String getFirstSelectedOption(WebElement element)
	{
		Select sel=new Select(element);
		WebElement option=sel.getFirstSelectedOption();
		String text= option.getText();
		return text;
	}
	
	public static void getAllSelectedOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allOptions=sel.getAllSelectedOptions();
		for(WebElement option:allOptions)
		{
			String text=option.getText();
			//return text;
		}
	}
	
	public static void getOptions(WebElement element)
	{
		Select sel=new Select(element);
		List<WebElement> allOptions=sel.getOptions();
		for(WebElement option:allOptions)
		{
			String text=option.getText();
			//return text;
		}
	}
	
	
	public static void dragAndDrope(WebDriver driver,WebElement source,WebElement target)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	//handling double click
	public static void doubleClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick();
	}
	
	//handling pop ups
	public static void javaScriptPopup_alert(WebDriver driver,WebElement element)
	{
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	public static void javaScriptPopup_confirmation(WebDriver driver,String input)
	{
		Alert a=driver.switchTo().alert();
		if(input.equals("Ok"))
		{
		a.accept();
		}
		else
		{
			a.dismiss();
		}
	}
	
	public static void javaScriptPopup_prompt(WebDriver driver,String text,WebElement element,String input)
	{
		Alert a=driver.switchTo().alert();
		element.sendKeys(text);
		Reporter.log("the input entered is: ");
		if(input.equals("Ok"))
		{
		a.accept();
		}
		else
		{
			a.dismiss();
		}
		
	}
	
	public static String hiddenDisionPopup(WebElement elementText,WebElement elementClose)
	{
		try {
			String text=elementText.getText();
			Reporter.log(text);
			Thread.sleep(3000);
			elementClose.click();
			return text;
		} catch (InterruptedException e) {
			return " ";
		}
		
	}
	
	public static void fileDownloadPopup(WebDriver driver,WebElement element,String pathname)
	{
		element.sendKeys(pathname);
	}
	

	public static void fileUploadPopup(WebDriver driver,WebElement element)
	{
		try {
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_S);
			Thread.sleep(1000);
			
			r.keyRelease(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_ALT);
			
		} catch (AWTException e) 
		{
			e.printStackTrace();
		}
		
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	

	public static void childBrowserPopup(WebDriver driver,WebElement element)
	{
		Set<String> allHandles=driver.getWindowHandles();
		for(String wh:allHandles )
		{
			driver.switchTo().window(wh);
			driver.getTitle();
			//get the name of parent bowser
		String parentPage=driver.getWindowHandle();
			//close only child browsers
		for (String wh1:allHandles)
		{
			driver.switchTo().window(wh1);
			String text=driver.getTitle();
			Reporter.log(text);
			if(!(text.equals(parentPage)))
			{
				driver.close();
			}
		}
			
		}
	}
	
	public static void windowPopup(String path)
	{
		try {
			Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//handling auto suggestions
	
	public static void autoSuggestion(WebDriver driver,WebElement element,String input,By expression,int index)
	{
		
		try {
			element.sendKeys(input);	
			Thread.sleep(1000);
			List<WebElement> allOptions=driver.findElements(expression);
			for(WebElement option:allOptions)
			{
				String text = option.getText();
				Reporter.log(text);
			}
			allOptions.get(index).click();
		} 
		
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	//handling drop down menu
	
	public static void dropDownMenu(WebDriver driver,WebElement target,WebElement option)
	{
		try {
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
		Thread.sleep(1000);
		option.click();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//context click
	
	public static void contextClick(WebDriver driver,WebElement element)
	{
		try {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		
		} 
		catch (Exception e) 
		{
			//catches both InterruptedException and AWTException
			e.printStackTrace();
		}
	}
	
	
	//composite actions
	
	public static void compositeActions(WebDriver driver, Keys key,WebElement element)
	{
		Actions act=new Actions(driver);
		act.sendKeys(key).click(element).perform();//type of keys?
	}
	
	
	public static void scrollBy(WebDriver driver,String jsExpression)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript(jsExpression);
	}
}
