package com.eBayDDU.SmokeTest;

import org.testng.annotations.Test;

import com.eBay.Base.BaseTest;
import com.eBay.Page.EbayDeveloperSignIn;
import com.eBay.Page.SellerSignUPPage;

public class Ebay_SellerSignUp_Test extends BaseTest {

	
	@Test
	public void eBaySellerSignUP(){
		System.out.println("Starting the setup on eBay platform");
		EbayDeveloperSignIn eBaySignIn = new EbayDeveloperSignIn(driver);
		SellerSignUPPage eBaySignUp = eBaySignIn.SignInWithDeveloper(configReader.geteBayDevUserName(), configReader.geteBayDevPassWord());
		eBaySignUp.registereBaySeller();
	}
	
}
