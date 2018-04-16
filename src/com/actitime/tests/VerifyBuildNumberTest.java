package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildNumberTest extends BaseTest
{
	@Test
	public void testVerifyBuildNumber() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		lp.verifyTheTitle("actiTIME - Login");
		lp.enterUserName("admin");		
		lp.enterPassword("manager");
		lp.clickLoginBTN();
		Thread.sleep(3000);
		ep.verifyTheTitle("actiTIME - Enter Time-Track");
		Thread.sleep(2000);
		ep.clickHelp();
		Thread.sleep(2000);
		ep.aboutActitimeLink();
		String text = ep.handlePopup();
		Reporter.log(text);
	}

}
