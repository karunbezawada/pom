package com.testapplication.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <h1>List of common data handling methods!</h1> The DataFactory program
 * implements re-usable methods required to read and write data to excel
 * workbooks
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class DataFactory {

	/**
	 * This method is used to read data from excel work book
	 * 
	 * @param sheetName
	 *            This is the first parameter to getData method
	 * @param tcName
	 *            This is the second parameter to getData method
	 * @return HashMap This returns test data in key, value combination
	 */

	public static HashMap<String, String> getData(String sheetName, String tcName)
			throws FileNotFoundException, IOException {

		HashMap<String, String> tcData = null;
		String flPath = "src/test/resources/testdata/testapplicationdata.xlsx";
		Workbook wb = new XSSFWorkbook(flPath);
		Sheet sh = wb.getSheet(sheetName);

		int rr = sh.getLastRowNum();
		int cc = sh.getRow(0).getLastCellNum();
		tcData = new HashMap<String, String>();
		for (int r = 1; r <= rr; r++) {
			if (sh.getRow(r).getCell(0).toString().equals(tcName)) {
				for (int c = 0; c < cc; c++) {
					String kName = sh.getRow(0).getCell(c, MissingCellPolicy.RETURN_BLANK_AS_NULL).toString();
					String kValue = sh.getRow(r).getCell(c, MissingCellPolicy.RETURN_BLANK_AS_NULL).toString();
					tcData.put(kName, kValue);
				}
				break;
			}
		}
		wb.close();
		return tcData;
	}
}
