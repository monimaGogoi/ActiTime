package com.actitime.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest{
	@Test
	public void testVerifyVersion() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		lp.verifyTheTitle("actiTIME - Login");
		Thread.sleep(3000);
		String aVersion = lp.verifyVersion();
		String eVersion="actiTIME 2017.4";
		Assert.assertEquals(aVersion, eVersion);
		
	}

}
