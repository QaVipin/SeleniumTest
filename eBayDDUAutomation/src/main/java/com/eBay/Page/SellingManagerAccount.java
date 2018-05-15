package com.eBay.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.eBay.Base.BasePage;

public class SellingManagerAccount extends BasePage {

	public SellingManagerAccount(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(continueBtn);
	}
	
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='card-body']/form/button")
	WebElement continueBtnOnPaymentMethod;
	

	@FindBy(xpath="//div[@class='card-body']/form/div[2]/label")
	WebElement creditCardRadioBtn;
	
	
	
	@FindBy(xpath="//button[contains(text(),'Review Details')]")
	WebElement reviewDetailsBtn;
	
	@FindBy(id="c-ct")
	WebElement cardType;
	
	@FindBy(id="txtFirstNam")
	WebElement firstName;
	
	@FindBy(name="c-cn")
	WebElement creditCardNoInp;
	
	@FindBy(id="txtExpirationDate")
	WebElement expiryDate;
	
	@FindBy(id="txtCVV")
	WebElement cvvNoIP;
	
	@FindBy(id="activateAccount")
	WebElement activateAccountBtn;
	
	@FindBy(xpath="//app-root[@class='site-root']/div[1]/onboard-payment-activation/div[1]/iframe")
	WebElement paymentIframe;
	
	@FindBy(id="paymetrics_iframe")
	WebElement paymetricIframe;
	
	@FindBy(name="sgnBt")
	WebElement eBaySignInBtn;
	
	@FindBy(xpath="//div[@id='pri_signin']/div[4]/span[2]/input")
	WebElement eBayUserNameTxtBox;
	
	@FindBy(xpath="//div[@id='pri_signin']/div[5]/span[2]/input")
	WebElement eBayPassWordTxtBox;
	
	@FindBy(xpath="//input[@value='Agree']")
	WebElement agreeBtn;
	
	@FindBy(xpath="//button[contains(text(),\"Let's Start\")]")
	WebElement letsStartBtn;
	
	public void sellerSignUp() throws InterruptedException{
		
		setupShippingAccount();
		authorizeeBaySellerAccount();

	}
	
	
	public void setupShippingAccount(){
		
		System.out.println("started setting up the seller account on shipping platform");
		waitForVisibilityOfElement(continueBtn).click();
		selectPaymentMethod();
		selectPayMetric();
		System.out.println("Confirm the account information");
		waitForVisibilityOfElement(activateAccountBtn).click();
		waitForVisibilityOfElement(continueBtn);
		System.out.println("Seller Account successfully setup in shipping platform");
		

	}
	
	
	private void authorizeeBaySellerAccount() {
		
		waitForVisibilityOfElement(continueBtn).sendKeys(Keys.ENTER);
		
		waitForVisibilityOfElement(eBaySignInBtn);
		waitForVisibilityOfElement(eBayUserNameTxtBox).sendKeys("testuser_"+configReader.getSellerUserName());
		waitForVisibilityOfElement(eBayPassWordTxtBox).sendKeys(configReader.getSellerPassword());
		waitForVisibilityOfElement(eBaySignInBtn).click();
		waitForVisibilityOfElement(agreeBtn).click();
		waitForVisibilityOfElement(letsStartBtn).click();
		
		
		
	}


	private void selectPayMetric() {
		
		System.out.println("Starting selection of paymentDetails");
		switchToFrame(paymentIframe);
		switchToFrame(paymetricIframe);
		selectByVisibleText(cardType,"Visa");
		waitForVisibilityOfElement(creditCardNoInp).sendKeys("4111111111111111");
		switchToPage();
		switchToFrame(paymentIframe);
		waitForVisibilityOfElement(expiryDate).sendKeys("0222");
		waitForVisibilityOfElement(cvvNoIP).sendKeys("123");
		waitForVisibilityOfElement(reviewDetailsBtn).sendKeys(Keys.PAGE_DOWN);
	
		Actions act = new Actions(driver);
		act.moveToElement(reviewDetailsBtn).doubleClick().build().perform();

		System.out.println("clickable ");
		//waitForVisibilityOfElement(reviewDetailsBtn).click();
		waitForVisibilityOfElement(activateAccountBtn);
		
		System.out.println("successfully filled the details");
		
		
	}


	public void selectPaymentMethod(){
		
		System.out.println("Select payment method credit card/paypal");
		waitForVisibilityOfElement(creditCardRadioBtn).click();
		waitForVisibilityOfElement(continueBtnOnPaymentMethod).click();
		waitForVisibilityOfElement(paymentIframe);
		System.out.println("Payment method selection is successfully done");
		
	}
	

}
