package com.hubspot.Hubspot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reusables {
	protected WebDriver driver;

	String xpathFile = System.getProperty("user.dir") + "/Xpath.properties";
	String testdataFile = System.getProperty("user.dir") + "/TestData.properties";

	public Reusables(WebDriver driver) {
		this.driver = driver;
	}

	public String ReadProperty(String File, String Property) {
		File f = new File(File);
		Properties p = new Properties();
		try {
			FileInputStream FI = new FileInputStream(f);
			p.load(FI);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (p.getProperty(Property));
	}

	public String ReadXpath(String Property) {
		String xpath = ReadProperty(xpathFile, Property);
		System.out.println(xpath + "xpathhhh");
		return xpath;
	}

	public String ReadTestData(String Property) {
		String testdata = ReadProperty(testdataFile, Property);
		System.out.println(testdata + "testdata");
		return testdata;
	}

	public void scrollIntoView(String objectProperty) {
		System.out.println("\"" + objectProperty + "\"");

		WebElement element = driver.findElement(By.xpath(objectProperty));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void test() {
		driver.findElement(By.xpath("//div[@class='homepage-hero__content']//a[text()='Get HubSpot free']")).click();

	}

	public void actions(Actions action, String testdata, String objectProperty) {

		switch (action) {
		case Click:
			driver.findElement(By.xpath(objectProperty)).click();
			break;
		case Enter:
			driver.findElement(By.xpath(objectProperty)).sendKeys(testdata);
			break;
		case Select:
			WebElement element = driver.findElement(By.xpath(objectProperty));
			Select sc = new Select(element);
			sc.selectByVisibleText(testdata);
			break;
		}

	}

	public void scrollToGetHubSpot() {
		String GetHubspotfree = ReadXpath("GetHubspotfree");
		scrollIntoView(GetHubspotfree);
	}

	public void scrollToCmsHub() {
		String CmsHub = ReadXpath("Cmshub");
		scrollIntoView(CmsHub);
	}

	public void clickOngetADemo() {
		String Getademo = ReadXpath("Getademo");
		actions(Actions.Click, "", Getademo);
	}

	public void RegisterADemo() {
		String FirstName = ReadXpath("FirstName");
		String FirstNameData = ReadTestData("FirstName");
		actions(Actions.Enter, FirstNameData, FirstName);

		String LastName = ReadXpath("LastName");
		String LastNameData = ReadTestData("LastName");
		actions(Actions.Enter, LastNameData, LastName);

		String Email = ReadXpath("Email");
		String EmailData = ReadTestData("Email");
		actions(Actions.Enter, EmailData, Email);

		String Phone = ReadXpath("Phone");
		String PhoneData = ReadTestData("Phone");
		actions(Actions.Enter, PhoneData, Phone);

		String Company = ReadXpath("Company");
		String CompanyData = ReadTestData("Company");
		actions(Actions.Enter, CompanyData, Company);

		String Website = ReadXpath("Website");
		String WebsiteData = ReadTestData("Website");
		actions(Actions.Enter, WebsiteData, Website);

		String EmployeeCount = ReadXpath("EmployeeCount");
		String EmployeeCountData = ReadTestData("EmployeeCount");
		actions(Actions.Select, EmployeeCountData, EmployeeCount);

		String GetFreeDemo = ReadXpath("GetFreeDemo");
		scrollIntoView(GetFreeDemo);
	}

}
