package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title=\"My Account\"]")
	private WebElement myaccbtn;
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(partialLinkText="Login")
	private WebElement loginBtn; 
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement logintomyaccount; 
	
	@FindBy(partialLinkText="Change your password")
	private WebElement changepasswordlink;
	
	@FindBy(id="input-password")
	private WebElement firstpwd;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpwd;
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	private WebElement continuebtn;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void Myaccountbtn() {
		this.myaccbtn.click();
	}
	public void siginside() {
			this.logintomyaccount.click();
		
	}
	public void changepwdlink() {
		this.changepasswordlink.click();
	}
	public void firstpwd(String firstpassword) {
		this.firstpwd.clear();
		this.firstpwd.sendKeys(firstpassword);
	}
	public void confirmpwd(String confirmpassword) {
		this.confirmpwd.clear();
		this.confirmpwd.sendKeys(confirmpassword);
	}
	
	public void continuebutton() {
		this.continuebtn.click();
	}

	
}
