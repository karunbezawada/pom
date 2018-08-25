package com.index.testapplication;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestFour;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 4 section</h1> The TestFour program implements tests to
 * verify Test 4 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestFour extends BaseTest {
	private static ExtentTest testFour;

	/**
	 * This validateButtons method is used to validate state of buttons displayed in
	 * Test 4 section
	 * 
	 */
	@Test
	public static void validateButtons() {
		try {
			// Initiate report sub section for TestFour
			testFour = report.startTest("Test Four");
			// Move application focus to the web element
			Activities.moveToElm(ORTestFour.enabledBtn);
			// Assert enabled button state
			assertTrue(Activities.verifyElmEnabled(ORTestFour.enabledBtn));
			// Highlight web element on the application
			Activities.highlightElm(ORTestFour.enabledBtn);
			// Update TestFour report section with result
			testFour.log(LogStatus.PASS, "Validate Enabled Button", "First button is in enabled state");
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestFour.enabledBtn);
			// Assert disabled button state
			assertFalse(Activities.verifyElmEnabled(ORTestFour.disabledBtn));
			// Move application focus to the web element
			Activities.moveToElm(ORTestFour.disabledBtn);
			// Update TestFour report section with result
			testFour.log(LogStatus.PASS, "Validate Disabled Button",
					"Second button is in disabled state" + testFour.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			// Remove highlight on web element from the application
			Activities.removeHighlightElm(ORTestFour.disabledBtn);
		} catch (Exception e) {
			// Update TestFour report section with exception if any
			testFour.log(LogStatus.FAIL, "Test Four Validations",
					"Validations failed " + e.getMessage() + testFour.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestFour report section with assert exception if any
			testFour.log(LogStatus.FAIL, "Test Four Assertions",
					"Assertions failed " + a.getMessage() + testFour.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestFour
			report.endTest(testFour);
			// Append sub report section to main report
			test.appendChild(testFour);
		}
	}

}
