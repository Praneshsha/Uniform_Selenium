package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class UFM__008_Uniform_product {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

  @BeforeMethod
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
  }

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
  }

  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
  }
  @Test
  public void uniformtestcase() throws InterruptedException {
	  //Clicking Shop Uniform button on Premium School uniforms
	  driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='banner1']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@class='img-responsive' and @title='REGULAR T-SHIRTS (YELLOW)']")).click();
	  Thread.sleep(3000);
	  WebElement chestsize = driver.findElement(By.id("input-option382"));
	  Thread.sleep(3000);
	  Select chsize = new Select(chestsize);
	  Thread.sleep(3000);
	  chsize.selectByVisibleText("34");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@type=\"button\" and @data-toggle=\"dropdown\"]")).click();
	  Thread.sleep(3000);
	  
	  
	  
  }
}
