package com.index.testapplication;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestOne;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.DataFactory;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 1 section</h1> The TestOne program implements tests to
 * verify and validate Test 1 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestOne extends BaseTest {

	private static ExtentTest testOne;
	public static HashMap<String, String> tcData = null;
	public static String sheetName = "index";
	public static String tcName = "TestOne";

	/**
	 * This validaeSignIn method is used to validate Sign In section and to enter
	 * email address and password in respective fields
	 * 
	 */
	@Test
	public void validaeSignIn() {
		try {
			// Initiate report sub section for TestOne
			testOne = report.startTest("Test One");
			// Assert Email Address input field
			assertTrue(Activities.verifyElmDisplayed(ORTestOne.emailInput));
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Verify Email Address", "Email Address input field is displayed on test application");
			// Assert Password input field
			assertTrue(Activities.verifyElmDisplayed(ORTestOne.pwdInput));
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Verify Password", "Password input field is displayed on test application");
			// Assert Sign In button
			assertTrue(Activities.verifyElmDisplayed(ORTestOne.signInBtn));
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Verify Sign In", "Sign In button is displayed on test application");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);

			// Highlight web element on the application
			Activities.highlightElm(ORTestOne.emailInput);
			// Enter email in Email Address field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Email Address"));
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Input Email Address",
					tcData.get("Email Address") + " entered in Email Address text box");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);

			// Highlight web element on the application
			Activities.highlightElm(ORTestOne.pwdInput);
			// Enter password in Password field
			driver.findElement(ORTestOne.pwdInput).sendKeys(tcData.get("Password"));
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Input Password", tcData.get("Password") + " entered in Passwrod text box");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);

			// Highlight web element on the application
			Activities.highlightElm(ORTestOne.signInBtn);
			// Update TestOne report section with result
			testOne.log(LogStatus.PASS, "Sign In Page Validation",
					"Sign In page validation successful" + testOne.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);

			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestOne.emailInput);
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestOne.pwdInput);
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestOne.signInBtn);
		} catch (Exception e) {
			// Update TestOne report section with exception if any
			testOne.log(LogStatus.FAIL, "Test One Valiadations",
					"Validations failed" + e.getMessage() + testOne.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestOne report section with assert exception if any
			testOne.log(LogStatus.FAIL, "Test One Assertions",
					"Assertions failed" + a.getMessage() + testOne.addScreenCapture(Report.captureScreenShot()));
		}
	}

	/**
	 * This validateWarningMsgs method is used to validate various possible error
	 * messages
	 * 
	 */
	@Test(dependsOnMethods = "validaeSignIn")
	public void validateWarningMsgs() throws InterruptedException {
		try {
			// Initiate Screen class to validate images
			Screen sc = new Screen();
			// Initiate Pattern class and store required images for error messages
			// validations in Pattern variables
			Pattern pNoEmail = new Pattern("src\\test\\resources\\testimages\\No Email Address.png");
			Pattern pNoPwd = new Pattern("src\\test\\resources\\testimages\\No Password.png");
			Pattern p1 = new Pattern("src\\test\\resources\\testimages\\Invalid Email One.png");
			Pattern p2 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Two.png");
			Pattern p3 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Three.png");
			Pattern p4 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Four.png");
			Pattern p5 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Five.png");
			Pattern p6 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Six.png");
			Pattern p7 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Seven.png");
			Pattern p8 = new Pattern("src\\test\\resources\\testimages\\Invalid Email Eight.png");

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Clear Password input field
			driver.findElement(ORTestOne.pwdInput).clear();

			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(pNoEmail) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation",
						"Error message for blank email address" + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 3 seconds
			Thread.sleep(3000);

			// Enter email in Email Address field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Email Address"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(pNoPwd) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation",
						"Error message for blank password" + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip One"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p1) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip One") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Two"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p2) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Two") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);
			
			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Three"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p3) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Three") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Four"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p4) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Four") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Five"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p5) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Five") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Six"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p6) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Six") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Seven"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p7) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Seven") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);

			// Clear Email Address input field
			driver.findElement(ORTestOne.emailInput).clear();
			// Enter invalid value in Email Address input field
			driver.findElement(ORTestOne.emailInput).sendKeys(tcData.get("Invalid Ip Eight"));
			// Click on Sign In button
			driver.findElement(ORTestOne.signInBtn).click();
			// Verify whether relevant error message displayed on current browser or not
			if (sc.exists(p8) != null) {
				// Update TestOne report section with result
				testOne.log(LogStatus.PASS, "Error Message Validation", "Error Message for email address input as "
						+ tcData.get("Invalid Ip Eight") + testOne.addScreenCapture(Report.captureScreenShot()));
			}
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(3000);
		} catch (Exception e) {
			// Update TestOne report section with exception if any
			testOne.log(LogStatus.FAIL, "Error Message Validation",
					testOne.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestOne
			report.endTest(testOne);
			// Append sub report section to main report
			test.appendChild(testOne);
		}
	}

	/**
	 * This getTCData method is used to get test data to execute tests for Test 1
	 * section
	 * 
	 */
	@BeforeMethod
	public void getTCData() {
		try {
			// Retrieve test data from excel workbook
			tcData = DataFactory.getData(sheetName, tcName);
		} catch (IOException e) {
			// Update TestOne report section with exception if any
			testOne.log(LogStatus.FAIL, "Get TestOne Test Data", e.getMessage());
		}
	}
}
