package com.eBay.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.eBay.Base.BasePage;

public class EbayDeveloperSignIn extends BasePage {

	public EbayDeveloperSignIn(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(signInBtn);
		
	}
	
	@FindBy(name="subject")
	WebElement developerID;
	
	
	@FindBy(name="password")
	WebElement developerPwd;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//a[@href='http://developer.ebay.com']")
	WebElement homeLink;
	
	@FindBy(xpath="//span[@class='icon-arrow-down']")
	WebElement dropDown;
	
	@FindBy(xpath="//div[@class='list-entries']")
	WebElement listEntriesElement;
	
	@FindBy(xpath="//a[contains(text(),'Auth tokens for eBay')]")
	WebElement authTokenLink;
	
	@FindBy(xpath="//a[contains(text(),'Register a new')]")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[contains(text(),'Create a keyset')]")
	WebElement createKeySetLink;
	public SellerSignUPPage SignInWithDeveloper(String userName,String passWord){
		
		waitForVisibilityOfElement(developerID).sendKeys(userName);
		waitForVisibilityOfElement(developerPwd).sendKeys(passWord);
		waitForVisibilityOfElement(signInBtn).click();
		waitForVisibilityOfElement(createKeySetLink);
		waitForVisibilityOfElement(dropDown).click();
		waitForVisibilityOfElement(listEntriesElement);
		waitForVisibilityOfElement(authTokenLink).click();
		waitForVisibilityOfElement(registerBtn).click();
		Set<String> handles=driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(handles);
		driver.switchTo().window(handleList.get(handleList.size()-1));
		
		return new SellerSignUPPage(driver);
		
	}

}
