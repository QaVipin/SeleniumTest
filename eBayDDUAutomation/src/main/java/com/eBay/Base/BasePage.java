package com.eBay.Base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	protected WebDriverWait wait=null;
	protected WebDriver driver=null;
	protected WebElement element;
	protected static ConfigReader configReader=null;
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,40);
		configReader=ConfigReader.getConfig();
	}
	
	/*wait function*
	 */
	public WebElement waitForVisibilityOfElement(WebElement element){
		try{
			this.element =wait.until(ExpectedConditions.visibilityOf(element));
		}catch(TimeoutException ex){
			Assert.fail("Not able to find the element in Time" );
		}catch(NoSuchElementException ex){
			Assert.fail("Unable to locate the element");
		}
		return this.element;
		
	}
	
	
	/*switch to a frame*/
	public void switchToFrame(WebElement frameElement){
		driver.switchTo().frame(waitForVisibilityOfElement(frameElement));
		
	}
	
	
	/*switch to default document*/
	public void switchToPage(){
		driver.switchTo().defaultContent();
	}
	
	/*Function:SelectByVisibleText
	 * 
	 */
	
	public void selectByVisibleText(WebElement selectElement,String text){
		Select select = new Select(waitForVisibilityOfElement(selectElement));
		try{
			select.selectByVisibleText(text);
		}catch(NoSuchElementException ex){
			Assert.fail("failed to select element because: " + ex.getMessage());
		}
	}
	
	
	public void switchToNewWindow(){

		List<String> handleList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handleList.get(handleList.size()-1));
		
	}

}
