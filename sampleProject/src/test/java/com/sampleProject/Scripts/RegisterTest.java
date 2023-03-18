package com.sampleProject.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sampleProject.Base.TestBase;
import com.sampleProject.constants.Constants;
import com.sampleProject.pages.RegisterPage;
import com.sampleProject.utilities.ExcelUtilitiesBook2;

public class RegisterTest extends TestBase{
	
	RegisterPage objRegister;
	
	@Test(priority = 8,description ="")
	public void verifyLoadingRegisterPage() {
		objRegister=new RegisterPage(driver);
		objRegister.clickRegister();
	}
	
	@Test(priority = 9)
	  public void fillingTheFields() throws IOException {
		objRegister=new RegisterPage(driver);
		String firstName=ExcelUtilitiesBook2.getCellStringData(0, 0);
		objRegister.setFirstName(firstName);
		String lastName=ExcelUtilitiesBook2.getCellStringData(0, 1);
		objRegister.setLastName(lastName);
		String userName=ExcelUtilitiesBook2.getCellStringData(0, 2);
		objRegister.setUserName(userName);
		String passWord=ExcelUtilitiesBook2.getCellStringData(0, 3);
		objRegister.setPassword(passWord);
		String confirmPassword=ExcelUtilitiesBook2.getCellStringData(0, 4);
		objRegister.setConfirmPassword(confirmPassword);
		objRegister.clickSubmit();
		String firstNameLastNameExpected=Constants.FIRSTNAMELASTNAMEEXPECTED+firstName+" "+lastName+",";
		Assert.assertEquals(objRegister.getRegisterDetailsFirstNameLastName(),firstNameLastNameExpected);
		String userNameExpected=Constants.USERNAMEEXPECTED+userName+".";
		Assert.assertEquals(objRegister.getRegisterDetailsUserName(), userNameExpected);
	}
}
