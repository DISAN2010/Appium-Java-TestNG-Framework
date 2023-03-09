package org.disan.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.HashMap;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startAppiumServer (String ipAddress, int port) {
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Lenovo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}
	
	public void waitForElement(AppiumDriver driver, WebElement element, String attribute, String value) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public double formattedAmount (String amount) {
		
		Double Amount = Double.parseDouble(amount.substring(1));
		return Amount;
	}
	
	public List<HashMap<String, String>> getJsonData (String jsonPath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
				
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>(){
				});
		return data;
	}
	
	public String getScreenshot (AppiumDriver driver, String testcaseName) throws IOException {
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		String detinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(detinationFile));
		return detinationFile;
	}
}
