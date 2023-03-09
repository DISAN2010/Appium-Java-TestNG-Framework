package org.disan.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.disan.utils.AppiumUtils;
import org.testng.annotations.AfterClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils {
	
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	
	@BeforeClass
	public void AppiumSetUp() throws IOException {
		
		Properties prop = new Properties();
		File path = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\swetha\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String deviceName = prop.getProperty("deviceName");
		String platformVersion = prop.getProperty("platformVersion");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName(deviceName);
		options.setPlatformVersion(platformVersion);
		options.setApp("/Users/judedisan/Desktop/UIKitCatalog.app");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@AfterClass
	public void tearDown () {
		
		driver.quit();
		service.stop();
	}
}
