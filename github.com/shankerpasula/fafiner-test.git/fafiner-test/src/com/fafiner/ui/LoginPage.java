package com.fafiner.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitforLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
		visibilityOfAllElementsLocatedBy(By.xpath("//td[@id='logoContainer']")));
	}
	public WebElement getUsernameTextbox()
	{
		WebElement elenent = 
				driver.findElement(By.id("username"));
		return elenent;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.id("loginButton"));
	}  
	public WebElement getErrorMsg()
	{
		return driver.findElement(
				By.xpath("(//span[@class='errormsg'])[1]"));
	}
}
