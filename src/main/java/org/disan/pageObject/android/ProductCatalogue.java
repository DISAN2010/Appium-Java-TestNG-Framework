package org.disan.pageObject.android;

import java.util.List;

import org.disan.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class ProductCatalogue extends AndroidActions {
	
	AndroidDriver driver;
	
	public ProductCatalogue (AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@FindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartBtn;
	
	public void addToCartByIndex (int index) {
		
		addToCart.get(index).click();
	}
	
	public void addToCartByScroll (String productName) {
		
		scrollToText(productName);
		int count = productNames.size();
		
		for (int i=0; i<count; i++) {
			
			String product = productNames.get(i).getText();
				
			if (product.contains(productName)) {
				
				addToCart.get(i).click();
			}
		}
	}
	
	public void cartPage () {
		
		cartBtn.click();	
	}
}
