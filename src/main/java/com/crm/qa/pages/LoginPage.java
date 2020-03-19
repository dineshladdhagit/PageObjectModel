package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//button[contains(type(),'submit')]")
		WebElement loginBtn;
		
		@FindBy(xpath="//img[contains(@class, 'gumtree-logo-svg')]")
		WebElement Gumtreelogo;
		
	//Constructor to initialize my pageobjects
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
	//Actions or Methods
		public String validateLoginPagetitle() {
			return driver.getTitle();
		}
		
		public boolean validateGumtreeImage() {
			return Gumtreelogo.isDisplayed();
		}
		
		public HomePage login(String uName, String pwd) {
			username.sendKeys(uName);
			password.sendKeys(pwd);
			loginBtn.click();
			
			return new HomePage();			//returning homepage class object
			
		}
}
