package com.sampleProject.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sampleProject.Base.TestBase;
import com.sampleProject.constants.Constants;
import com.sampleProject.constants.ExtentLogMessage;
import com.sampleProject.pages.LoginPage;
import com.sampleProject.utilities.ExcelUtilities;
import com.sampleProject.Listners.TestListner;

public class LoginTest extends TestBase {
	
	LoginPage objLogin;
	ThreadLocal<ExtentTest> extentTest = TestListner.getTestInstance();
	
  @Test(priority = 1,enabled = true,retryAnalyzer = com.sampleProject.Listners.ReTryAnalyzer.class)
  public void verifyLoginInvalidUserInvalidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(0, 0);
	  String password=ExcelUtilities.getCellStringData(0, 1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE1);
	  extentTest.get().log(Status.PASS, ExtentLogMessage.LOGIN_FAILED_MESSAGE);
  }
  
  @Test(priority = 2,enabled = false)
  public void verifyLoginValidUserInvalidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(1, 0);
	  String password=ExcelUtilities.getCellStringData(1, 1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE1);
  }
  
  @Test(priority = 3,enabled = false)
  public void verifyLoginInvalidUserValidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(2, 0);
	  String password=ExcelUtilities.getCellStringData(2, 1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE1);
  }
  
  @Test(priority = 4,enabled = false)
  public void verifyLoginValidUserValidPassword() throws IOException {
	  objLogin=new LoginPage(driver);
	  String username=ExcelUtilities.getCellStringData(3, 0);
	  String password=ExcelUtilities.getCellStringData(3, 1);
	  objLogin.setUsername(username);
	  objLogin.setPassword(password);
	  objLogin.clickSubmit();
	  Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE2);
  }
}
