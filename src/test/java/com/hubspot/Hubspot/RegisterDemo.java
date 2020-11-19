package com.hubspot.Hubspot;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterDemo extends LaunchAndExitDriver {

	@Test
	public void mains() {
		
		Reusables re = new Reusables(driver);

		re.clickOngetADemo();

		re.RegisterADemo();

	}

}
