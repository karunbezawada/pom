package com.testapplication.pages;

import org.openqa.selenium.By;

/**
 * <h1>To maintain Test 1 section objects</h1> The ORTestOne program implements
 * methods to store all Test 1 section web objects
 *  
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class ORTestOne {

	public static By emailInput = By.id("inputEmail");
	public static By pwdInput = By.id("inputPassword");
	public static By signInBtn = By.xpath("//*[contains(text(),'Sign in')]");

}
