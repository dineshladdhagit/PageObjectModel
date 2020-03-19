package com.crm.qa.base;

import java.awt.desktop.SystemSleepEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;


public class TestBase {
	//Global Variables
	public static WebDriver driver;
	public static Properties prop;
	
	//Constructor
	public TestBase() {
		try{		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/dineshladdha/eclipse-workspace/FreeCRMTest/src/main/java/com/crm"
				+ "/qa/config/config.properties");
		prop.load(ip);	
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}		
	}
	//Initialization Method
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/dineshladdha/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "/Users/dineshladdha/Downloads/geckodriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}