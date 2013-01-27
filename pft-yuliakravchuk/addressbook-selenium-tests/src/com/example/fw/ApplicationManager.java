package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;	
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = this.properties.getProperty("browser");
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.firefox.bin",
					"D:/Program Files (x86)/Mozilla Firefox/firefox.exe"); 
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver",
					"D:/Installs/Programming/Selenium/IEDriverServer.exe"); 
			driver = new InternetExplorerDriver();
			break;
		default:
			throw new Error("Unsupported browser: " + browser);
		}
					
		baseUrl = this.properties.getProperty("baseurl");
		driver.get(baseUrl);
	}
	
	public void stop() {
		driver.quit();
	}
	
	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
}
