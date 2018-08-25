package com.index.testapplication;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestThree;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.DataFactory;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 3 section</h1> The TestThree program implements tests to
 * verify and validate Test 3 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestThree extends BaseTest {
	private static ExtentTest testThree;
	public static HashMap<String, String> tcData = null;
	public static String sheetName = "index";
	public static String tcName = "TestThree";

	/**
	 * This validateDropdownValues method is used to validate default option and to
	 * select any other option from the drop down in Test 3 section
	 * 
	 */
	@Test
	public static void validateDropdownValues() {
		try {
			// Initiate report sub section for TestThree
			testThree = report.startTest("Test Three");
			// Move application focus to the web element
			Activities.moveToElm(ORTestThree.dropDownBtn);
			// Highlight web element on the application
			Activities.highlightElm(ORTestThree.dropDownBtn);
			// Assert drop down presence on application
			assertTrue(Activities.verifyElmDisplayed(ORTestThree.dropDownBtn));
			// Update TestThree report section with result
			testThree.log(LogStatus.PASS, "Verify Drop Down", "Dropdown is displayed on the application");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Assert default value in drop down
			assertTrue(Activities.verifyText(ORTestThree.dropDownBtn, tcData.get("DefaultOption")));
			// Update TestThree report section with result
			testThree.log(LogStatus.PASS, "Verify Drop Down Default Value", "Default value selected in dropdown is "
					+ tcData.get("DefaultOption") + testThree.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestThree.dropDownBtn);
			// Click drop down on the application
			driver.findElement(ORTestThree.dropDownBtn).click();
			// Initiate WebDriverWait and pass driver instance as argument
			WebDriverWait wDriver = new WebDriverWait(driver, 10);
			// Wait until drop down element is clickable
			wDriver.until(ExpectedConditions.elementToBeClickable(ORTestThree.dropDownElm));
			// Assert and Select option in drop down which is coming from excel
			assertTrue(Activities.clickOptionInDropDown(ORTestThree.dropDownElm, tcData.get("SelectOption")));
			
			// Highlight web element on the application
			Activities.highlightElm(ORTestThree.dropDownBtn);
			// Update TestThree report section with result
			testThree.log(LogStatus.PASS, "Select Item In Dropdown", tcData.get("SelectOption")
					+ " is selected in dropdown" + testThree.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestThree.dropDownBtn);
		} catch (Exception e) {
			// Update TestThree report section with exception if any
			testThree.log(LogStatus.FAIL, "Test Three Validations",
					"Validations failed " + e.getMessage() + testThree.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestThree report section with assert exception if any
			testThree.log(LogStatus.FAIL, "Test Three Assertions",
					"Assertions failed " + a.getMessage() + testThree.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestThree
			report.endTest(testThree);
			// Append sub report section to main report
			test.appendChild(testThree);
		}
	}

	/**
	 * This getTCData method is used to get test data to execute tests for Test 3
	 * section
	 * 
	 */
	@BeforeMethod
	public static void getTCData() {
		try {
			// Retrieve test data from excel workbook
			tcData = DataFactory.getData(sheetName, tcName);
		} catch (IOException e) {
			// Update TestOne report section with exception if any
			testThree.log(LogStatus.FAIL, "Get TestThee Test Data", e.getMessage());
		}
	}
}
