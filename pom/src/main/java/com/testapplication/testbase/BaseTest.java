package com.testapplication.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.testapplication.utils.DriverFactory;
import com.testapplication.utils.Report;

/**
 * <h1>This is act like Driver program for all tests!</h1> The BaseTest program
 * implements re-usable methods to execute before and after each test
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static int PAGE_LOAD_TIME = 10;
	public static int IMPLICT_WAIT = 10;

	/**
	 * This startReport method is used to start reporting
	 * 
	 */
	@BeforeSuite
	public void startReport() {
		// Create report.html for all tests in testng xml file
		report = new ExtentReports("src//..//Reports//TestApplicationResults" + Report.getUniqueId() + ".html");
	}

	/**
	 * This openApplication method is used to open application
	 * 
	 */
	@BeforeClass
	@Parameters({ "browser", "url" })
	public void openApplication(String appBrowser, String appUrl) {

		// Start main report section in report.html file
		test = report.startTest(this.getClass().getSimpleName());
		// Open required browser to execute tests
		driver = DriverFactory.getDriver(appBrowser);
		// Maximize the browser window
		driver.manage().window().maximize();
		// Set browser page load time
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME, TimeUnit.SECONDS);
		// Set implicit wait for finding web elements
		driver.manage().timeouts().implicitlyWait(IMPLICT_WAIT, TimeUnit.SECONDS);
		// Open test application in the browser
		driver.get(System.getProperty("user.dir") + appUrl);
	}

	/**
	 * This closeApplication method is used to close application
	 * 
	 */
	@AfterClass
	public void closeApplication() {
		// Close current browser opened by webdriver
		driver.close();
		// Close all browsers opened by webdriver
		driver.quit();

		report.endTest(test);
	}

	/**
	 * This stopReport method is used to stop reporting
	 * 
	 */
	@AfterSuite
	public void stopReport() {
		// Flush the report
		report.flush();
		// Close the report
		report.close();
	}
}
