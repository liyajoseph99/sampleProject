package com.sampleProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@name='userName']") 					 //instance variable, driver.FindElement
	WebElement user;
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	@FindBy(xpath="//input[@name='submit']")
	WebElement submit;
	
	public LoginPage(WebDriver driver) { 					 //constructor, passing the parameter driver,calling from  LoginTest
		this.driver=driver;
		PageFactory.initElements(driver, this);				 //to pass the driver value to pagefactory(ie, @FindBy)
	}
	
	public void setUsername(String username) {
		user.sendKeys(username);
	}
	
	public void setPassword(String password) {
		pass.sendKeys(password);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public String getHomePageTitle() {
		String title=driver.getTitle();
		return title;
	}
}
