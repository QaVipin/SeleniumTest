package com.eBay.Base;

import java.io.IOException;

import java.util.Properties;




public class ConfigReader {
	
	private Properties config;
	private volatile static ConfigReader configObj;
	private String userName;
	private String passWord;
	private String environment;
	private String sm_url;
	private String ebay_developer_url;
	private String eBayDevUserName;
	private String eBayDevPassWord;


	private String sellerUserName;
	private String sellerEmail;
	private String sellerPassword;
	private String sellerFName;
	private String sellerLName;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getUrl() {
		return sm_url;
	}

	public void setUrl(String url) {
		this.sm_url = url;
	}


	public String getEbay_developer_url() {
		return ebay_developer_url;
	}

	public void setEbay_developer_url(String ebay_developer_url) {
		this.ebay_developer_url = ebay_developer_url;
	}

	public String geteBayDevUserName() {
		return eBayDevUserName;
	}

	public void seteBayDevUserName(String eBayDevUserName) {
		this.eBayDevUserName = eBayDevUserName;
	}

	public String geteBayDevPassWord() {
		return eBayDevPassWord;
	}

	public void seteBayDevPassWord(String eBayDevPassWord) {
		this.eBayDevPassWord = eBayDevPassWord;
	}


	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerFName() {
		return sellerFName;
	}

	public void setSellerFName(String sellerFName) {
		this.sellerFName = sellerFName;
	}

	public String getSellerLName() {
		return sellerLName;
	}

	public void setSellerLName(String sellerLName) {
		this.sellerLName = sellerLName;
	}
	


	/*ConfigReader constructor*/
	private ConfigReader(){
		setProperties();
		
	}
	
	
	 
	public static ConfigReader getConfig(){
		if(configObj==null){
			
			synchronized(ConfigReader.class){
				if(configObj==null)
					configObj=new ConfigReader();
			}
		}
		return configObj;
	}
	
	/*Function to set the properties*/
	private void setProperties(){
		this.config=new Properties();
		try{
			config.load(ConfigReader.class.getResourceAsStream("/config/config.properties"));
			setUserName(config.getProperty("emailId"));
			setPassWord(config.getProperty("password"));
			setEnvironment(config.getProperty("environment"));

			setEbay_developer_url(config.getProperty("ebay_developer_url"));
			seteBayDevUserName(config.getProperty("eBayDevUserName"));
			seteBayDevPassWord(config.getProperty("eBayDevPassWord"));
			setSellerUserName(config.getProperty("sellerUserName").split("_")[1]);
			setSellerPassword(config.getProperty("sellerPassword"));
			setSellerEmail(config.getProperty("emailId"));
			setSellerFName(config.getProperty("sellerFName"));
			setSellerLName(config.getProperty("sellerLName"));

			
			
			if("SYSTEST1".equalsIgnoreCase(config.getProperty("environment"))){
				
				setUrl(config.getProperty("systest1_SM_URL"));
				
				
				
			}/*else if("SYSTEST1".equals(config.getProperty("environment"))){
				
				setUrl(config.getProperty("systest1_SM_URL"));
				
				
				
			}else if("SYSTEST1".equals(config.getProperty("environment"))){
				
				setUrl(config.getProperty("systest1_SM_URL"));
				
				
				
			}*/else{
				System.out.println("Invalid Environment");
			}
			
		}
		catch(IOException ex){
			System.out.println("Exception occurred while read the config file "+ex.getMessage());
			
		}
	}
	
}
