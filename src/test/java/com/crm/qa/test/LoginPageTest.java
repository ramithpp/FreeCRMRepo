package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void Setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitle() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(
				title,
				"Free CRM software for customer relationship management, sales, marketing campaigns and support.");

	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
		homepage = loginpage.Login(prop.getProperty("username"),
				prop.getProperty("password"));

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
