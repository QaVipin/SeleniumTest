package com.eBay.Page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.eBay.Base.BasePage;

public class ListingEligibility extends BasePage {

	public ListingEligibility(WebDriver driver) {
		super(driver);
		waitForVisibilityOfElement(listingEligibilyHeading);
	}
	
	
	@FindBy(xpath="//div[@class='toolbar-left']/h")
	WebElement listingEligibilyHeading;
	

}
