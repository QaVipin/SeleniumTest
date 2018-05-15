package com.eBayDDU.SmokeTest;


import org.testng.annotations.Test;


import com.eBay.Base.BaseTest;
import com.eBay.Page.SellingManagerAccount;
import com.eBay.Page.SignInPage;

public class FirstTime_SignIn_Test extends BaseTest{
	

	@Test
	public void TestSignUp() throws InterruptedException{
		SignInPage signIn = new SignInPage(driver);
		SellingManagerAccount sellerAccount = (SellingManagerAccount)signIn.signIn(configReader.getUserName(), configReader.getPassWord(), true);
		sellerAccount.sellerSignUp();
		
	}


}
