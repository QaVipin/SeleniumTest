package com.eBayDDU.SmokeTest;

import org.testng.annotations.Test;

import com.eBay.Base.BaseTest;
import com.eBay.Page.SignInPage;
import com.eBay.Page.SignUp;

public class Registration_Test extends BaseTest{

	
	@Test
	public void Registration() throws InterruptedException{
		SignInPage signIn= new SignInPage(driver);
		SignUp signUp = signIn.signUp();
		signUp.signUP();
			
	
		
	}
}
