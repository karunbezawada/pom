package com.testapplication.pages;

import org.openqa.selenium.By;

/**
 * <h1>To maintain Test 6 section objects</h1> The ORTestSix program implements
 * methods to store all Test 6 section web objects
 *  
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class ORTestSix {
	public static By secHeading = By.xpath("//*[contains(text(),'Test 6')]");
	public static By elmTable = By.xpath("//*[@class='table table-bordered table-dark']");
	public static By elmTableHead = By.xpath("//*[@class='table table-bordered table-dark']//thead");
	public static By elmTableBody = By.xpath("//*[@class='table table-bordered table-dark']//tbody");
}
