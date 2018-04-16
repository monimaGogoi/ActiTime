package com.actitime.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstant {

	public WebDriver driver;
	
	@Parameters({"nodeurl","browser","appurl"})
	@BeforeMethod
	public void preCondition(String nodeurl,String browser,String appurl ) throws MalformedURLException
	{
		URL url=new URL(nodeurl);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(appurl);
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		//get the status
		int status = res.getStatus();
		String name = res.getMethod().getMethodName();
		if(status==2)
		{
			GenericUtils.getSceenShot(driver,name);
			Reporter.log("test status failed, please find the screen shot",true);
		}
		
		else
		{
			Reporter.log("status passed");
		}
		driver.close();
	}
	
}
