package com.actitime.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.GenericUtils;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest{
	
	@Test
	public void testInvalidLogin() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		lp.verifyTheTitle("actiTIME - Login");
		lp.enterUserName("admin");		
		lp.enterPassword("damager");
		lp.clickLoginBTN();
		Thread.sleep(3000);
		String eErrorMessage = lp.verifyErrorMessage();
		String aErrorMessage="Username or Password is invalid. Please try again.";
		
		Assert.assertEquals(eErrorMessage, aErrorMessage);
		
	}

}
