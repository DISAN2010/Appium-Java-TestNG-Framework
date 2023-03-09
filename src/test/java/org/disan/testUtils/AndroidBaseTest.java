package org.disan.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.disan.utils.AppiumUtils;
import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void AppiumSetUp() throws IOException {
		
		Properties prop = new Properties();
		File path = new File(System.getProperty("user.dir")+"\\src\\main\\java\\org\\swetha\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		//String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String deviceName = prop.getProperty("deviceName");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setChromedriverExecutable("G:\\Mobile Testing\\chromedriver\\chromedriver.exe");
		options.setApp("C:\\Users\\Lenovo\\eclipse-workspace-2\\AppiumFrameworkDesign\\src\\test\\java\\org\\swetha\\resources\\General-Store.apk");
		
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown () {
		
		driver.quit();
		service.stop();
	}
}
