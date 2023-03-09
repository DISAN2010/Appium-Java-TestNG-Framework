package org.disan.pageObject.android;

import java.util.List;

import org.disan.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public CartPage (AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Cart']")
	private WebElement cartTitle;
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmount;
	
	@FindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@FindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsAndCondition;
	
	@FindBy(xpath="//android.widget.Button[@text='CLOSE']")
	private WebElement closeBtn;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement websiteBtn;
	
	public void verifyTitle (String attribute, String value) {
		
		waitForElement(driver, cartTitle, attribute, value);
	}
	
	public double expectedAmount (String text) {
		
		scrollToText(text);
		int count = productPrice.size();
		double ExpectedAmount = 0;
		
		for (int i=0; i<count; i++) {
			
			String Amount = productPrice.get(i).getText();
			double productAmount = formattedAmount(Amount);
			ExpectedAmount = ExpectedAmount + productAmount;
		}
		
		return ExpectedAmount;
	}
	
	public double actualAmount () {
		
		String amount = totalPurchaseAmount.getText();
		double ActualAmount = formattedAmount(amount);
		return ActualAmount;	
	}
	
	public void visitWebsite () {
		
		checkBox.click();
		longClickGesture(termsAndCondition);
		closeBtn.click();
		websiteBtn.click();
	}
}
