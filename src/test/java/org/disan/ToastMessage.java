package org.disan;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

import org.disan.pageObject.android.FormPage;
import org.disan.testUtils.AndroidBaseTest;
import org.openqa.selenium.By;

public class ToastMessage extends AndroidBaseTest{
	
	@Test
	public void  failed_Scenario () throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setGender("Female");
		formPage.setCountry("Australia");
		formPage.submitForm();
		String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
		Assert.assertEquals(toastMsg, "Please your name");
		Thread.sleep(2000);
	}
	
	@BeforeMethod
	public void preSetUp () {
		
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
}
