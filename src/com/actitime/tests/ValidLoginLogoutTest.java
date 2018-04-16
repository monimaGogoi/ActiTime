package com.actitime.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
@Test
public void testValidLoginLogout() throws InterruptedException
{
	LoginPage lp=new LoginPage(driver);
	EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
	lp.verifyTheTitle("actiTIME - Login");
	lp.enterUserName("admin");		
	lp.enterPassword("manager");
	lp.clickLoginBTN();
	Thread.sleep(1000);
	ep.verifyTheTitle("actiTIME - Enter Time-Track");
	ep.logout();	
}
}
