package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C://Users/Ramith/workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			File file = new File("C:\\Users\\Ramith\\Downloads\\chromedriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramith\\Downloads\\chromedriver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",
					"C://Users//Ramith//Downloads//chromedriver//geckdriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
}
