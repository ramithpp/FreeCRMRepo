package com.crm.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	// WebDriver driver;
	public HomePageTest() {
		super();
	}

	@BeforeTest
	public void Setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(
				title,
				"Free CRM software for customer relationship management, sales, marketing campaigns and support.",
				"****Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUsernameisDisplayed() {
		homepage.verifyUsernameisDisplayed();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
