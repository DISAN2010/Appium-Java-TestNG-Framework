package org.disan;

import org.disan.pageObject.android.CartPage;
import org.disan.pageObject.android.FormPage;
import org.disan.pageObject.android.ProductCatalogue;
import org.disan.pageObject.android.WebActivity;
import org.disan.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ShoppingApplication extends AndroidBaseTest {
	
	@Test
	public void eCommerceTest () throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		formPage.setName("Swetha");
		formPage.setGender("Female");
		formPage.setCountry("Australia");
		formPage.submitForm();
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addToCartByIndex(0);
		productCatalogue.addToCartByIndex(0);
		productCatalogue.addToCartByScroll("Jordan 6 Rings");
		productCatalogue.cartPage();
		
		CartPage cartPage = new CartPage(driver);
		cartPage.verifyTitle("text", "Cart");
		double expectedAmount = cartPage.expectedAmount("Jordan 6 Rings");
		double actualAmount = cartPage.actualAmount();		
		Assert.assertEquals(actualAmount, expectedAmount);		
		cartPage.visitWebsite();
		
		Thread.sleep(5000);
		
		WebActivity webActivity = new WebActivity(driver);
		driver.context("WEBVIEW_com.androidsample.generalstore");
		webActivity.search("Youtube");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		Thread.sleep(2000);		
	}
}
