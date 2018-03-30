package com.fafiner.test.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.HomePage;
import com.fafiner.ui.LoginPage;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class JavaScriptPractice{
	 WebDriver	driver = TestConfiguration.createDriverInstance();
	
	 @Test
	 public void runjavascripts()
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("document.getElementsByName('username').values = 'shanker';");
		 js.executeScript("document.getElementsByName('pwd').values = 'shanker'");
		 
		 
		 
		/* document.getElementById('searchText').value='shanker.p[asula';
		 document.getElementById('searchSubmit').click();
		 document.getElementsByName('username').values = 'shanker'
		 document.getElementsByName('pwd').values = 'shanker'*/
	 }
}