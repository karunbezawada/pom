package com.testapplication.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.testapplication.testbase.BaseTest;

/**
 * <h1>List of common activities!</h1> The Activities program implements
 * re-usable methods required to validate features of the application
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class Activities extends BaseTest {

	/**
	 * This method is used to verify page tile
	 * 
	 * @param actTitle
	 *            This is the first parameter to verifyPgTitle method
	 * @param expTitle
	 *            This is the second parameter to verifyPgTitle method
	 * @return boolean This returns true or false
	 */

	public static boolean verifyPgTitle(String actTitle, String expTitle) {
		if (expTitle.equalsIgnoreCase(actTitle.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to click on web element
	 * 
	 * @param elmLocator
	 *            This is the first parameter to clickOnElm method
	 * @return boolean This returns true or false
	 */

	public static boolean clickOnElm(By elmLocator) {
		boolean isElmClicked = false;
		try {
			driver.findElement(elmLocator).click();
			isElmClicked = true;
		} catch (Exception e) {
			isElmClicked = false;
		}
		return isElmClicked;
	}

	/**
	 * This method is used to verify web element is displayed or not
	 * 
	 * @param elmLocator
	 *            This is the first parameter to verifyElmDisplayed method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyElmDisplayed(By elmLocator) {
		if (driver.findElement(elmLocator).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to verify web element is enabled or not
	 * 
	 * @param elmLocator
	 *            This is the first parameter to verifyElmEnabled method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyElmEnabled(By elmLocator) {
		if (driver.findElement(elmLocator).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to verify web element is disabled or not
	 * 
	 * @param elmLocator
	 *            This is the first parameter to verifyElmDisabled method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyElmDisabled(By elmLocator) {
		if (driver.findElement(elmLocator).isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to compare text
	 * 
	 * @param elmLocator
	 *            This is the first parameter to verifyText method
	 * @param expText
	 *            This is the second parameter to verifyText method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyText(By elmLocator, String expText) {
		boolean isTextPresent = false;
		String actText = driver.findElement(elmLocator).getText();
		if (expText.trim().equals(actText.trim())) {
			isTextPresent = true;
		}
		return isTextPresent;
	}

	/**
	 * This method is used to verify option in drop down
	 * 
	 * @param seLst
	 *            This is the first parameter to verifyOptionInDropDown method
	 * @param expOption
	 *            This is the second parameter to verifyOptionInDropDown method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyOptionInDropDown(Select seLst, String expOption) {
		boolean isOptionPresent = false;
		List<WebElement> lst = seLst.getOptions();
		for (WebElement elm : lst) {
			if (elm.getText().equals(expOption.trim())) {
				isOptionPresent = true;
				break;
			}
		}
		return isOptionPresent;
	}

	/**
	 * This method is used to select option in drop down
	 * 
	 * @param seLst
	 *            This is the first parameter to selectOptionInDropDown method
	 * @param optionToBeSelected
	 *            This is the second parameter to selectOptionInDropDown method
	 * @return boolean This returns true or false
	 */
	public static boolean selectOptionInDropDown(Select seLst, String optionToBeSelected) {
		boolean isOptionSelected = false;
		try {
			seLst.selectByVisibleText(optionToBeSelected);
			isOptionSelected = true;
		} catch (NoSuchElementException e) {
			isOptionSelected = false;
		}
		return isOptionSelected;
	}

	/**
	 * This method is used to click option in drop down
	 * 
	 * @param elmLocator
	 *            This is the first parameter to clickOptionInDropDown method
	 * @param optionToBeSelected
	 *            This is the second parameter to clickOptionInDropDown method
	 * @return boolean This returns true or false
	 */
	public static boolean clickOptionInDropDown(By elmLocator, String optionToBeSelected) {
		boolean isOptionClicked = false;
		try {
			List<WebElement> lst = driver.findElements(elmLocator);
			for (WebElement elm : lst) {
				if (elm.getText().equals(optionToBeSelected)) {
					elm.click();
					isOptionClicked = true;
					break;
				}
			}
		} catch (NoSuchElementException e) {
			isOptionClicked = false;
		}
		return isOptionClicked;
	}

	/**
	 * This method is used to verify number of items in list
	 * 
	 * @param elmXpath
	 *            This is the first parameter to verifyListOptions method
	 * @param expListItems
	 *            This is the second parameter to verifyListOptions method
	 * @return boolean This returns true or false
	 */
	public static boolean verifyListOptions(By elmXpath, int expListItems) {
		boolean isOptionsExists = false;
		try {
			if (driver.findElements(elmXpath).size() == expListItems) {
				isOptionsExists = true;
			}
		} catch (NoSuchElementException e) {
			isOptionsExists = false;
		}
		return isOptionsExists;
	}

	/**
	 * This method is used to retrieve cell value from table
	 * 
	 * @param elmLocator
	 *            This is the first parameter to getTableCellValue method
	 * @param rowNum
	 *            This is the second parameter to getTableCellValue method
	 * @param colNum
	 *            This is the third parameter to getTableCellValue method
	 * @return String This returns cell value
	 */
	public static String getTableCellValue(By elmLocator, int rowNum, int colNum) {
		String cellValue = null;
		try {
			WebElement elmTable = driver.findElement(elmLocator);
			List<WebElement> trLst = elmTable.findElements(By.tagName("tr"));
			List<WebElement> tdLst = trLst.get(rowNum).findElements(By.tagName("td"));
			cellValue = tdLst.get(colNum).getText().toString();
		} catch (Exception e) {
			cellValue = e.getMessage();
		}
		return cellValue;
	}

	/**
	 * This method is used to move mouse cursor
	 * 
	 * @param elmLocator
	 *            This is the first parameter to moveToElm method
	 */
	public static void moveToElm(By elmLocator) {
		Actions actDriver = new Actions(driver);
		actDriver.moveToElement(driver.findElement(elmLocator)).build().perform();
		driver.manage().timeouts().implicitlyWait(IMPLICT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to highlight web element on the application
	 * 
	 * @param elmLocator
	 *            This is the first parameter to highlightElm method
	 */
	public static void highlightElm(By elmLocator) {
		WebElement elm = driver.findElement(elmLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", elm);
	}

	/**
	 * This method is used to reset web element style attribute to default value
	 * 
	 * @param elmLocator
	 *            This is the first parameter to removeHighlightElm method
	 */
	public static void removeHighlightElm(By elmLocator) {
		WebElement elm = driver.findElement(elmLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', '');", elm);
	}
}
