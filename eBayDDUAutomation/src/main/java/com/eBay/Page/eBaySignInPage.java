package com.eBay.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.eBay.Base.BasePage;

public class eBaySignInPage extends BasePage{

	public eBaySignInPage(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(signIn);
		System.out.println("done");
		
	}

	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;
	
	@FindBy(xpath="//div[@id='pri_signin']/div[4]/span[2]/input")
	WebElement eBayUserNameTxtBox;
	
	@FindBy(xpath="//div[@id='pri_signin']/div[5]/span[2]/input")
	WebElement eBayPassWordTxtBox;
	
	@FindBy(name="sgnBt")
	WebElement eBaySignInBtn;
	
	
	public void buyerSignIn(String userName,String passWord){
		waitForVisibilityOfElement(signIn).click();
		waitForVisibilityOfElement(eBayUserNameTxtBox).sendKeys(userName);
		waitForVisibilityOfElement(eBayPassWordTxtBox).sendKeys(passWord);
		waitForVisibilityOfElement(eBaySignInBtn).click();
		wait.until(ExpectedConditions.titleContains("Electronics, Cars, Fashion, Collectibles"));
	}
}
