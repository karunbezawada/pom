package com.testapplication.pages;

import org.openqa.selenium.By;

/**
 * <h1>To maintain Test 5 section objects</h1> The ORTestFive program implements
 * methods to store all Test 5 section web objects
 *  
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class ORTestFive {
	public static By enabledBtn = By.id("test5-button");
	public static By txtMsg = By.xpath("//*[normalize-space(text())='You clicked a button!']");
}
