package utils;

import org.openqa.selenium.WebElement;

public class CommonFunctions {
	
	/***
	 * @description Method to get the boolean based on element is Present on screen or not
	 * @param element
	 * @return
	 */
	public static boolean isElementPresent(WebElement element)
	{
		try {
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
