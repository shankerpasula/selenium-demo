package com.fafiner.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.HomePage;
import com.fafiner.ui.LoginPage;

public class TestLoginUS016 
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void preTest()
	{
		driver = TestConfiguration.createDriverInstance();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	@Test
	public void testLoginWithValidCredentials()
	{
		loginPage.waitforLoginPage();
		loginPage.getUsernameTextbox().sendKeys("admin");
		loginPage.getPasswordTextbox().sendKeys("manager");
		loginPage.getLoginButton().click();
		
		homePage.waitForHomePage();
		boolean actualStatus =
				homePage.getLogoutButton().isDisplayed();
		
		Assert.assertEquals(actualStatus, true);
		homePage.getLogoutButton().click();
	}
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
}
