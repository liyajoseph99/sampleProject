package com.sampleProject.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sampleProject.utilities.WaitUtilities;

public class FlightsPage {
	
	public WebDriver driver;
	public Select selectobj;
	
	@FindBy(xpath="//a[text()='Flights']")
	WebElement flights;
	@FindBy(xpath="//input[@name='tripType']")
	List<WebElement> objTripType;
	@FindBy(xpath="//select[@name='passCount']")
	WebElement passenger;
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement departFrom;
	
	public FlightsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void clickFlights() {
		flights.click();
	}
	
	 public boolean flightTypeisSelected() {
		WaitUtilities.explicitWait(driver,objTripType.get(0));
		boolean TypeisSelected=objTripType.get(0).isSelected();
		return TypeisSelected;
	} 
	
	public String passengerSelect() {
		selectobj=new Select(passenger);
		selectobj.selectByIndex(3); 
		String passengerSelectedValue= selectobj.getFirstSelectedOption().getText();
		return passengerSelectedValue;
	}
	
	public String departFromSelect() {
		selectobj=new Select(departFrom);
		selectobj.selectByValue("London");  
		String departFromValue= selectobj.getFirstSelectedOption().getText();
		return departFromValue;
	}
	
	public String getFlightsPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	
}
