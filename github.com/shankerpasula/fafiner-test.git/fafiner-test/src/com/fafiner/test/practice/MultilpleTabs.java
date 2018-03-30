package com.fafiner.test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.HomePage;
import com.fafiner.ui.LoginPage;

public class MultilpleTabs {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void preTest() {
		driver = TestConfiguration.createDriverInstance();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void testLoginValidTC118() {

		
		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");

		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window //Switch to new window open

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

			driver.get("https://facebook.com/");
		}
	}
}
