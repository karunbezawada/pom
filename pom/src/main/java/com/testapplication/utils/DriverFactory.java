package com.testapplication.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * <h1>List of common webdriver handling methods!</h1> The DriverFactory
 * program implements re-usable methods required to invoke required web browser
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class DriverFactory {

	public static WebDriver driver;

	/**
	 * This method is used to invoke required web browser
	 * 
	 * @param brName
	 *            This is the first parameter to getDriver method
	 * @return WebDriver This returns webdriver
	 */

	public static WebDriver getDriver(String brName) {

		switch (brName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\browserexe\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			driver = new ChromeDriver(co);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\browserexe\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.dirver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\browserexe\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\browserexe\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.drier",
					System.getProperty("user.dir") + "\\src\\main\\resources\\browserexe\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
