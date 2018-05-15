package com.eBayDDU.SmokeTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.eBay.Base.BaseTest;
import com.eBay.Page.eBaySignInPage;

public class OrderPurchaseAutomation extends BaseTest{
	
	
	@Test
	public void eBayOrderAutomation(){
		
		System.out.println(driver.getCurrentUrl());
		eBaySignInPage signIn= new eBaySignInPage(driver);
		signIn.buyerSignIn("testuser_vibuyertest", "Pitney1!");
		System.out.println(driver.getCurrentUrl());
	}

}