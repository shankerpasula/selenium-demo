package com.fafiner.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage
{
	WebDriver driver;
	public DropdownPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitforLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
		visibilityOfAllElementsLocatedBy(By.id("//body")));
	}
	
	public WebElement getMultipleSelectDropdownList()
	{
		 return driver.findElement(By.xpath("//select[@multiple='true']"));
		
	}
}