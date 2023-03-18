package com.sampleProject.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement register;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstname;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastname;
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmpassword;
	@FindBy(xpath="//input[@name='submit']")
	WebElement submit;
	@FindBy(xpath="//font//b")
	List<WebElement> registerDetails;
	
	public RegisterPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void setFirstName(String firstName) {
		firstname.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		lastname.sendKeys(lastName);
	}
	
	public void setUserName(String userName) {
		username.sendKeys(userName);
	}
	
	public void setPassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void setConfirmPassword(String confirmPassWord) {
		confirmpassword.sendKeys(confirmPassWord);
	}
	
	public void clickSubmit() {
		submit.click();
	}
	
	public String getRegisterDetailsFirstNameLastName() {
		String FirstNameLastNameActual=registerDetails.get(0).getText();
		return FirstNameLastNameActual;
	}
	
	public String getRegisterDetailsUserName() {
		String UserNameActual=registerDetails.get(1).getText();
		return UserNameActual;
	}
}
