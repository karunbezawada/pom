package com.testapplication.pages;

import org.openqa.selenium.By;

/**
 * <h1>To maintain Test 2 section objects</h1> The ORTestTwo program implements
 * methods to store all Test 2 section web objects
 *  
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class ORTestTwo {
	
	public static By listElm = By.xpath("//*[@class='list-group-item justify-content-between']");
	public static By listItem1Value = By.xpath("//*[normalize-space(text())='List Item 1']");
	public static By listItem2Value = By.xpath("//*[normalize-space(text())='List Item 2']");
	public static By listItem3Value = By.xpath("//*[normalize-space(text())='List Item 3']");
	public static By listItem1Span = By.xpath("//*[normalize-space(text())='List Item 1']//span");
	public static By listItem2Span = By.xpath("//*[normalize-space(text())='List Item 2']//span");
	public static By listItem3Span = By.xpath("//*[normalize-space(text())='List Item 3']//span");
}
