package com.eBay.Page;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eBay.Base.*;

public class SellerSignUPPage extends BasePage {

	public SellerSignUPPage(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(registerBtn);
	}
	
	@FindBy(name="user_name")
	WebElement userNametxtBox;
	
	@FindBy(name="email")
	WebElement emailtxtBox;
	
	@FindBy(name="Re-enter-email")
	WebElement reEnterEmailtxtBox;
	
	@FindBy(name="password")
	WebElement passwordtxtBox;
	
	@FindBy(name="first_name")
	WebElement firstNametxtBox;
	
	@FindBy(name="last_name")
	WebElement lastNametxtBox;
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[contains(text(),'here')]")
	WebElement popUpElement;
	
	public void registereBaySeller(){
		waitForVisibilityOfElement(userNametxtBox).sendKeys(configReader.getSellerUserName());
		waitForVisibilityOfElement(emailtxtBox).sendKeys(configReader.getSellerEmail());
		waitForVisibilityOfElement(reEnterEmailtxtBox).sendKeys(configReader.getSellerEmail());
		waitForVisibilityOfElement(passwordtxtBox).sendKeys(configReader.getSellerPassword());
		waitForVisibilityOfElement(firstNametxtBox).sendKeys(configReader.getSellerFName());
		waitForVisibilityOfElement(lastNametxtBox).sendKeys(configReader.getSellerLName());
		waitForVisibilityOfElement(registerBtn).click();
		waitForVisibilityOfElement(popUpElement);
		
	}

}
