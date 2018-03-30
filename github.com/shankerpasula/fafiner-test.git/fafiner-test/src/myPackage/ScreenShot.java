package myPackage;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot {
	public static void getScreenShotofDesktop() {
		try {
			Robot r = new Robot();
			// get the current size of the desktop
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect = new Rectangle(d);
			// take screen shot of complete desktop
			BufferedImage img = r.createScreenCapture(screenRect);
			// save to disk
			ImageIO.write(img, "jpg", new File("d:/desktop.jpg"));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver",
				"D:\\workspaces\\Maven-Project\\fafiner-test\\browser-drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://docs.selenium.org/download/");
		driver.get("https://www.seleniumhq.org/download/");
		
		driver.findElement(By.linkText("2.52.0")).click();
		Thread.sleep(3000);
		getScreenShotofDesktop();
		driver.close();
	}
}