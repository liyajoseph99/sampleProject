package com.sampleProject.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sampleProject.Base.TestBase;
import com.sampleProject.constants.Constants;
import com.sampleProject.pages.FlightsPage;

public class FlightTest extends TestBase{
	
	FlightsPage objFlights;
	
  @Test(priority=5,description = "verifying the flights page is loaded and roundTrip is selected by default")
  public void verifyLoadingFlightsPage() {
	  objFlights=new FlightsPage(driver);
	  objFlights.clickFlights();
	  boolean TypeisSelectedActual=objFlights.flightTypeisSelected();
	  Assert.assertEquals(TypeisSelectedActual,Constants.TYPEISSELECTEDEXPECTED );
  }
  
  @Test(priority = 6,description="Verifying the selected value 4 in the dropdown Passenger")
  public void verifyTheSelectedNumberOfPassengers() {
	  objFlights=new FlightsPage(driver);
	  String passengerSelectedValueActual=objFlights.passengerSelect();
	  Assert.assertEquals(passengerSelectedValueActual, Constants.PASSENGERSELECTEDVALUEEXPECTED);
  }
  
  @Test(priority = 7,description = "Verifying the selected value London in the dropdown departFrom")
  public void verifyTheDepartFrom() {
	  objFlights=new FlightsPage(driver);
	  String departFromValueActual=objFlights.departFromSelect();
	  Assert.assertEquals(departFromValueActual, Constants.DEPARTFROMVALUEEXPECTED);
  }
}
