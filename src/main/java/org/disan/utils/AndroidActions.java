package org.disan.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	
	AndroidDriver driver;
	
	public AndroidActions (AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	public void longClickGesture (WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId", element,
				"duration", 2000));
	}
	
	public void scrollToText (String text) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView"
				+ "(new UiSelector().textContains(\""+text+"\"));")).click();
	}
	
	public void scrollGesture (String direction) {
		
		boolean scrollForMore;
		
		do {			
			scrollForMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
									"left", 100, "top", 100, "width", 200, "height", 200,
									"direction", direction,
									"percent", 3.0));
		} while(scrollForMore);
	}
	
	public void swipeGesture (WebElement element, String direction) {
		
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", element,
				"direction", direction,
				"percent", 0.75));
	}
	
	public void dragGesture (WebElement element, int XCoordinate, int YCoordinate) {
		
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", element,
				"endX", XCoordinate,
				"endY", YCoordinate));
	}
}
