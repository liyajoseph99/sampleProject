package com.sampleProject.Base;

import org.testng.annotations.Test;

import com.sampleProject.utilities.WaitUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TestBase {
	public static Properties prop=null;
	public static WebDriver driver;
	
  @Test
  public static void testBase() {
		  try
		  {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources"+ "\\config.properties"); //path of the file config.properties
			prop.load(ip);
		  }
		  catch(FileNotFoundException e)
		  {
			  e.printStackTrace();
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
		  }
  }
  
  @AfterMethod
  public void afterMethod(ITestResult r) throws IOException {
	  if(ITestResult.SUCCESS==r.getStatus()) {
			//checking the status of the @Test is same as ITestResult.SUCCESS or not.
			  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(f, new File("C:\\Users\\ASUS\\Desktop\\screenshots\\"+r.getName()+".jpeg"));
		  }
  }

  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(String browser1) {
	  
	  testBase();    																				//calling the method testBase()
	  
	  if(browser1.equalsIgnoreCase("edge")) {														//getting the browser from xml -parameterisation
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }
	  else if(browser1.equalsIgnoreCase("chrome")) {														
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  
	  else if(browser1.equalsIgnoreCase("gecko")) {														
		 /* WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();*/
		 System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\New\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
	  
	  driver.manage().window().maximize();
	  WaitUtilities.implicitWait(driver);
	  
	  String baseUrl=prop.getProperty("url");													//getting the url from prop
	  driver.get(baseUrl);
  }

  @AfterTest
  public void afterTest() {
  }

}
