package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

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
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.Myaccountbtn();
		loginPOM.clickLoginBtn();
		loginPOM.sendUserName("Praneshsha@hotmail.com");
		loginPOM.sendPassword("Selenium@123");
		//loginPOM.Mainloginbtn();
		loginPOM.siginside();
		Thread.sleep(3000);
		loginPOM.changepwdlink();
		//WebElement firstpassword = driver.findElement(By.id("input-password")).sendKeys("sneha");
		//System.out.println("password is:" +firstpassword);
		loginPOM.firstpwd("sneha");
		Thread.sleep(3000);
		loginPOM.confirmpwd("mneha");
		//System.out.println("Confirm Password is: " +confirmpwd);
		Thread.sleep(3000);
		loginPOM.continuebutton();
		System.out.println("Password confirmation does not match password!");
		
		screenShot.captureScreenShot("First");
	}
}
