package com.eBay.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;


import com.eBay.Base.BasePage;


public class SignUp extends BasePage {



	public SignUp(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(firstName);
	}
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[1]/div[1]/input")
	WebElement firstName;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[1]/div[2]/input")
	WebElement lastName;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[2]/div[1]/input")
	WebElement emailId;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[2]/div[2]/input")
	WebElement passWord;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[3]/div[1]/input")
	WebElement companyName;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[3]/div[2]/input")
	WebElement phoneNo;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[4]/div[1]/input")
	WebElement address1;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[4]/div[2]/input")
	WebElement address2;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[5]/div[1]/input")
	WebElement city;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[5]/div[2]/select")
	WebElement state;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[5]/div[3]/input")
	WebElement zipCode;
	
	@FindBy(xpath="//div[@class='signin-box']/form/div[6]/div[2]/button")
	WebElement signUpbtn;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement addressUpdateAlert;
	
	public SignInPage signUP() throws InterruptedException{
		firstName.sendKeys("vipins");
		lastName.sendKeys("rawat");
		emailId.sendKeys(configReader.getUserName());
		passWord.sendKeys(configReader.getPassWord());
		companyName.sendKeys("PitneyBowes");
		phoneNo.sendKeys("2037921600");
		address1.sendKeys("37 Executive Dr");
		city.sendKeys("Danbury");
		Select select = new Select(state);
		select.selectByVisibleText("CT");
		zipCode.sendKeys("06810");
		signUpbtn.click();
		waitForVisibilityOfElement(addressUpdateAlert);
		signUpbtn.click();
		return new SignInPage(driver);
	}

}
