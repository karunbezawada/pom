package com.index.testapplication;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestFive;
import com.testapplication.pages.ORTestSix;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.DataFactory;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 5 section</h1> The TestFive program implements tests to
 * verify and validate Test 5 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestFive extends BaseTest {
	private static ExtentTest testFive;
	public static HashMap<String, String> tcData = null;
	public static String sheetName = "index";
	public static String tcName = "TestFive";

	/**
	 * This validateConfirmMsg method is used to validate default state of button and
	 * confirmation message in Test 5 section
	 * 
	 */
	@Test
	public static void validateConfirmMsg() {
		try {
			// Initiate report sub section for TestFive
			testFive = report.startTest("Test Five");
			// Initiate WebDriverWait and pass driver instance as argument
			WebDriverWait wDriver = new WebDriverWait(driver, 10);
			// Wait until drop down element is clickable
			wDriver.until(ExpectedConditions.elementToBeClickable(ORTestFive.enabledBtn));
			// Assert enabled button state
			assertTrue(Activities.verifyElmEnabled(ORTestFive.enabledBtn));
			// Move application focus to web element
			Activities.moveToElm(ORTestSix.secHeading);
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Highlight web element on the application
			Activities.highlightElm(ORTestFive.enabledBtn);
			// Update TestFive report section with result
			testFive.log(LogStatus.PASS, "Validate Enabled Button",
					"Button is in enabled state" + testFive.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestFive.enabledBtn);
			// Assert and Click on button
			assertTrue(Activities.clickOnElm(ORTestFive.enabledBtn));
			// Update TestFive report section with result
			testFive.log(LogStatus.PASS, "Click Buuton", "Button is clicked");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Assert disabled button state
			assertFalse(Activities.verifyElmEnabled(ORTestFive.enabledBtn));
			// Assert success message on application
			assertTrue(Activities.verifyText(ORTestFive.txtMsg, tcData.get("Success Message")));
			// Move application focus to the web element
			Activities.moveToElm(ORTestSix.secHeading);
			// Highlight web element on the application
			Activities.highlightElm(ORTestFive.txtMsg);
			// Update TestFive report section with result
			testFive.log(LogStatus.PASS, "Validate Disabled Button",
					"Button is in disabled state" + testFive.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestFive.txtMsg);
		} catch (Exception e) {
			// Update TestFive report section with exception if any
			testFive.log(LogStatus.FAIL, "Test Five Validations",
					"Validations failed " + e.getMessage() + testFive.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestFive report section with assert exception if any
			testFive.log(LogStatus.FAIL, "Test Five Assertions",
					"Assertions failed " + a.getMessage() + testFive.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestFive
			report.endTest(testFive);
			// Append sub report section to main report
			test.appendChild(testFive);
		}
	}

	/**
	 * This method is used to get test data to execute tests for Test 5 section
	 * 
	 */
	@BeforeMethod
	public static void getTCData() {
		try {
			// Retrieve test data from excel workbook
			tcData = DataFactory.getData(sheetName, tcName);
		} catch (IOException e) {
			// Update TestOne report section with exception if any
			testFive.log(LogStatus.FAIL, "Get TestFive Test Data", e.getMessage());
		}
	}
}
