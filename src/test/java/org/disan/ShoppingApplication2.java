package org.disan;

import org.disan.pageObject.android.FormPage;
import org.disan.testUtils.AndroidBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class ShoppingApplication2 extends AndroidBaseTest {
	
	@Test(dataProvider = "getData", groups= {"Smoke"})
	public void eCommerceTest (String name, String gender, String country) throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setName(name);
		formPage.setGender(gender);
		formPage.setCountry(country);
		formPage.submitForm();		
		Thread.sleep(2000);		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void preSetUp () {
		
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	@DataProvider
	public Object [][] getData () {
		
		return new Object[][] { {"Swe", "Female", "Australia"}, {"Disan", "Male", "Brazil"} };
	}
	
}
