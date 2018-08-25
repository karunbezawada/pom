package com.testapplication.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.testapplication.testbase.BaseTest;

/**
 * <h1>List of common reporting handling methods!</h1> The Report program
 * implements re-usable methods required to take screenshot and generate
 * timestammp
 * 
 * @author Karun Bezawada
 * @version 1.0
 * @since 2018-08-25
 */

public class Report extends BaseTest {

	/**
	 * This getUniqueId method is used to generate unique time stamp
	 * 
	 * @return String This returns current time stamp
	 */

	public static String getUniqueId() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddhhmmss");
		return sd.format(new Date());
	}

	/**
	 * This captureScreenShot method is used to take screenshot
	 * 
	 * @return String This returns screenshot location
	 */

	public static String captureScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("src\\..\\Reports\\Screeshots\\testapplication" + getUniqueId() + ".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dst.getAbsolutePath();
	}
}
