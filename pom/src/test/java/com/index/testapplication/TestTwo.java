package com.index.testapplication;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestTwo;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.DataFactory;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 2 section</h1> The TestTwo program implements tests to
 * verify and validate Test 2 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestTwo extends BaseTest {

	private static ExtentTest testTwo;
	public static HashMap<String, String> tcData = null;
	public static String sheetName = "index";
	public static String tcName = "TestTwo";

	/**
	 * This validateListItems method is used to validate total number of items with
	 * in Test 2 section
	 * 
	 */
	@Test
	public static void validateListItems() {
		try {
			// Initiate report sub section for TestTwo
			testTwo = report.startTest("Test Two");
			// Store number of web elements from excel workbook in integer variable
			int expItems = Integer.parseInt(tcData.get("ListItems"));
			// Store number of web elements from application in integer variable
			int actItems = driver.findElements(ORTestTwo.listElm).size();
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Assert between number of actual and expected web elements
			assertEquals(actItems, expItems);
			// Highlight web element on the application
			Activities.highlightElm(ORTestTwo.listElm);
			// Update TestTwo report section with result
			testTwo.log(LogStatus.PASS, "Verify Number of List Items",
					"Number of List Items displayed on page : " + Integer.parseInt(tcData.get("ListItems")));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			// Highlight web element on the application
			Activities.removeHighlightElm(ORTestTwo.listElm);

		} catch (Exception e) {
			// Update TestTwo report section with exception if any
			testTwo.log(LogStatus.FAIL, "Test Two Validations",
					"Validations failed " + e.getMessage() + testTwo.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestTwo report section with assert exception if any
			testTwo.log(LogStatus.FAIL, "Test Two Assertions",
					"Assertions failed " + a.getMessage() + testTwo.addScreenCapture(Report.captureScreenShot()));
		}
	}

	/**
	 * This validateListItemValues method is used to validate all inner text values
	 * under any one list item under Test 2 section
	 * 
	 */
	@Test(dependsOnMethods = "validateListItems")
	public static void validateListItemValues() {
		try {
			// Move application focus to the web element
			Activities.moveToElm(ORTestTwo.listItem3Value);
			// Get web element text and store in String variable
			String str = driver.findElement(ORTestTwo.listItem2Value).getText();
			// Highlight web element on the application
			Activities.highlightElm(ORTestTwo.listItem2Value);
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Assert between web element text from application and excel workbook
			assertEquals(str.substring(0, str.indexOf("2") + 1), tcData.get("Text2"));
			// Update TestTwo report section with result
			testTwo.log(LogStatus.PASS, "Verfiy " + tcData.get("Text2") + " Text",
					"List Item 2 inner text is " + tcData.get("Text2"));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Assert between web element span text from application and excel workbook
			assertEquals(driver.findElement(ORTestTwo.listItem2Span).getText(), tcData.get("SpanText2"));
			// Update TestTwo report section with result
			testTwo.log(LogStatus.PASS, "Verfiy " + tcData.get("Text2") + " - Span Innter Text ",
					"List Item 2 - Badge (inner) text is " + tcData.get("SpanText2")
							+ testTwo.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			// Highlight web element on the application
			Activities.removeHighlightElm(ORTestTwo.listItem2Value);
		} catch (Exception e) {
			// Update TestTwo report section with exception if any
			testTwo.log(LogStatus.FAIL, "Test Two Validations",
					"Validations failed " + e.getMessage() + testTwo.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestTwo report section with assert exception if any
			testTwo.log(LogStatus.FAIL, "Test Two Assertions",
					"Assertions failed " + a.getMessage() + testTwo.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestTwo
			report.endTest(testTwo);
			// Append sub report section to main report
			test.appendChild(testTwo);
		}
	}

	/**
	 * This getTCData method is used to get test data to execute tests for Test 2
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
			testTwo.log(LogStatus.FAIL, "Get TestTwo Test Data", e.getMessage());
		}
	}
}
