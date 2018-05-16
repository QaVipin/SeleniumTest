package com.eBay.Base;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class BaseTest {

	
	public static WebDriver driver=null;

	public static ConfigReader configReader=null;
	
	protected BaseTest(){
		
			configReader = ConfigReader.getConfig();
		
			
		}
	


	
	@BeforeTest
	public static void setup(final ITestContext testContext){
		System.setProperty("webdriver.chrome.driver",BaseTest.class.getResource("/drivers/chromedriver.exe").toString());
		
		driver=new ChromeDriver();		
		if(testContext.getName().contains("eBaySellerSignUP")){
			driver.get(configReader.getEbay_developer_url());
		}else{
			driver.get(configReader.getUrl());
		}
		
		driver.manage().window().maximize();
		//((JavascriptExecutor)driver).executeScript("document.body.style.zoom='1'");
	}
	@AfterTest
	public static void quitDriver(){
		driver.quit();
	}
}
