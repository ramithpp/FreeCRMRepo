package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Object Repo

	@FindBy(xpath = "//*[text()='Login']")
	WebElement clickLogin;

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[text()='Login']")
	WebElement loginBtn;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage Login(String usr, String pwd) throws InterruptedException {
		Thread.sleep(3000);
		clickLogin.click();
		Thread.sleep(3000);
		username.sendKeys(usr);
		Thread.sleep(3000);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(3000);
		return new HomePage();

	}

}
