package com.fafiner.test.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.LoginPage;

public class TestLoginUS13 
{
	WebDriver driver;
	LoginPage login;
	@BeforeMethod
	public void preTest()
	{
		driver = TestConfiguration.createDriverInstance();
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginErrorTC102()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("gadkhfvkha");
		login.getLoginButton().click();
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(login.getErrorMsg()));
	    String actualErrorMsg = login.getErrorMsg().getText();
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	@AfterMethod
	public void postTest()
	{
		driver.close();
	}
		
}
