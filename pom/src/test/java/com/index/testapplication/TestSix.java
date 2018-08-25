package com.index.testapplication;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testapplication.pages.ORTestSix;
import com.testapplication.testbase.BaseTest;
import com.testapplication.utils.Activities;
import com.testapplication.utils.DataFactory;
import com.testapplication.utils.Report;

/**
 * <h1>To validate Test 6 section</h1> The TestSix program implements tests to
 * verify and validate Test 6 section
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */
public class TestSix extends BaseTest {
	private static ExtentTest testSix;
	public static HashMap<String, String> tcData = null;
	public static String sheetName = "index";
	public static String tcName = "TestSix";

	/**
	 * This validateTable method is used to get value of any cell and validate it in
	 * Test 6 section
	 * 
	 */
	@Test
	public static void validateTable() {
		try {
			// Initiate report sub section for TestSix
			testSix = report.startTest("Test Six");
			// Move application focus to the web element
			Activities.moveToElm(ORTestSix.elmTable);
			// Get cell row number from excel workbook and store in integer variable
			int rowNo = Integer.parseInt(tcData.get("Row No"));
			// Get cell column number from excel workbook and store in integer variable
			int colNo = Integer.parseInt(tcData.get("Col No"));
			
			// Assert cell value between from application and excel workbook
			assertEquals(Activities.getTableCellValue(ORTestSix.elmTableBody, rowNo, colNo),
					tcData.get("Expected Cell Value"));
			// Update TestSix report section with result
			testSix.log(LogStatus.PASS, "Get Cell Value From Table", "Cell (" + rowNo + " , " + colNo + ") value is "
					+ Activities.getTableCellValue(ORTestSix.elmTableBody, rowNo, colNo));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
			
			// Update TestSix report section with result
			testSix.log(LogStatus.PASS, "Validate Cell Value From Grid",
					testSix.addScreenCapture(Report.captureScreenShot()));
			// This is a wait to delay programming execution for 2 seconds
			Thread.sleep(2000);
		} catch (Exception e) {
			// Update TestSix report section with exception if any
			testSix.log(LogStatus.FAIL, "Test Six Validations",
					"Validations failed " + e.getMessage() + testSix.addScreenCapture(Report.captureScreenShot()));
		} catch (AssertionError a) {
			// Update TestSix report section with assert exception if any
			testSix.log(LogStatus.FAIL, "Test Six Assertions",
					"Assertions failed " + a.getMessage() + testSix.addScreenCapture(Report.captureScreenShot()));
		} finally {
			// End sub report section for TestSix
			report.endTest(testSix);
			// Append sub report section to main report
			test.appendChild(testSix);
		}
	}

	/**
	 * This method is used to get test data to execute tests for Test 6 section
	 * 
	 */
	@BeforeMethod
	public static void getTCData() {
		try {
			// Retrieve test data from excel workbook
			tcData = DataFactory.getData(sheetName, tcName);
		} catch (IOException e) {
			// Update TestOne report section with exception if any
			testSix.log(LogStatus.FAIL, "Get TestSix Test Data", e.getMessage());
		}
	}
}
