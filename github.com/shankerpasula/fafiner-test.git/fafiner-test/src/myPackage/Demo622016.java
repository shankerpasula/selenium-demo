package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo622016 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement un = driver.findElement(By.id("username"));
		String fs = un.getCssValue("font-size");
		System.out.println(fs);
		String fc = un.getCssValue("color");
		System.out.println(fc);
		String ff = un.getCssValue("font-family");
		System.out.println(ff);
		driver.close();
	}
}