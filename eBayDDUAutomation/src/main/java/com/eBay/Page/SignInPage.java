package com.eBay.Page;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.eBay.Base.BasePage;

public class SignInPage extends BasePage{

	
	public SignInPage(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(userName);
	}
	
	@FindBy(xpath="//app-login[@class='signin']/div/div/form/div[1]/input")
	WebElement userName;
	
	@FindBy(xpath="//app-login[@class='signin']/div/div/form/div[2]/input")
	WebElement passWord;
	
	@FindBy(xpath="//a[@href='#/signup']")
	WebElement signUpLink;
	
	
	@FindBy(xpath="//app-login[@class='signin']/div/div/form/button")
	WebElement signInBtn;
	
	

	
	
	public BasePage signIn(String userName,String passWord,Boolean isNewSignUp){
		try{
			this.userName.sendKeys(userName);
			this.passWord.sendKeys(passWord);
			signInBtn.click();
		}catch(TimeoutException ex){
			Assert.fail("Sign to Page is failed becasue of :" + ex.getMessage());
		}catch(NoSuchElementException ex){
			Assert.fail("Sign to Page is failed because of :" + ex.getMessage());
		}catch(Exception ex){
			Assert.fail("Sign to Page is failed becasue of :" + ex.getMessage());
		}
		if(isNewSignUp){
			return new SellingManagerAccount(driver);
		}else{
			return new ListingEligibility(driver);
		}
	}
	
	public SignUp signUp(){
		try{
			
		this.signUpLink.click();
		}catch(Exception ex){
			Assert.fail("Not able to click on Signup link because :"+ex.getMessage());
			
		}
		return new SignUp(driver);
	}
	
	
	
	
	
	

}
