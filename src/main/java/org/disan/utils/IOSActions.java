package org.disan.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils {
	
	IOSDriver driver;
	
	public IOSActions (IOSDriver driver) {
		
		this.driver = driver;
	}
	
	public void touchAndHold (WebElement element) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", element);
		params.put("duration", 5);
		driver.executeScript("mobile: touchAndHold", params);
	}
	
	public void scroll (WebElement element, String direction) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", element);
		params.put("direction", direction);
		driver.executeScript("mobile: scroll", params);
	}
	
	public void swipe (WebElement element, String direction) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", element);
		params.put("direction", direction);
		driver.executeScript("mobile: swipe", params);
	}
	
	public void launchApp (String bundleIdValue) {
		
		Map<String, String> params = new HashMap<>();
		params.put("bundleId", bundleIdValue);
		driver.executeScript("mobile: launchApp", params);
	}
}
