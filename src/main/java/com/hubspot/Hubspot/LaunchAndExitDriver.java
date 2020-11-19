package com.hubspot.Hubspot;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class LaunchAndExitDriver {

	public WebDriver driver;

	@BeforeClass
	public void initilizeWebDriver() {

		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");

		driver.get("https://www.hubspot.com/");

		driver.navigate().refresh();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@AfterClass
	public void exitBrowser() {
		driver.quit();
	}
}
