package org.task.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utilities {
	public static WebDriver driver;

	public static void browserOpen(String browserName) {
		switch (browserName.toLowerCase())

		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/browserDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/browserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "./src/test/resources/browserDrivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		}

	}

	public static void quitBrowser() {
		driver.quit();
	}
public static void launchURL(String url){
	driver.get(url);
}

}
