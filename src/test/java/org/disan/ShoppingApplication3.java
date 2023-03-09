package org.disan;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.disan.pageObject.android.FormPage;
import org.disan.testUtils.AndroidBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class ShoppingApplication3 extends AndroidBaseTest {
	
	@Test(dataProvider = "getData")
	public void eCommerceTest (HashMap <String, String> input) throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setName(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountry(input.get("country"));
		formPage.submitForm();		
		Thread.sleep(2000);		
	}
	
	@BeforeMethod
	public void preSetUp () {
		
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	@DataProvider
	public Object [][] getData () throws IOException {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\org\\swetha\\testData\\eCommerce.json";
		List<HashMap<String, String>> data = getJsonData(path);
		return new Object[][] { {data.get(0)}, {data.get(1)}, {data.get(2)} };
	}
	
}
