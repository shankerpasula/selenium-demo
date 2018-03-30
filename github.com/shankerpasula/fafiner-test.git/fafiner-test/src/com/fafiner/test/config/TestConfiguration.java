package com.fafiner.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fafiner.utils.GetData;

public class TestConfiguration 
{
	public static WebDriver createDriverInstance()
	{
		WebDriver driver = null;
		String browser = GetData.
				fromProperties("configuration", "browser");
		String url = GetData.
				fromProperties("configuration", "url");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",
					"./browser-drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./browser-drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					"./browser-drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.err.print("Invalid browser option");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}


/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
testLoginValidTC118*/
