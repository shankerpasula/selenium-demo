package com.fafiner.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandlers
{
	public static void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static void enterTextInAlert(WebDriver driver,
			String text)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}
	public static String getAlertMsg(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String alertMsg = alt.getText();
		return alertMsg;
	}
}
