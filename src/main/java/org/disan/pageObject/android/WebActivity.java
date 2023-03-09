package org.disan.pageObject.android;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class WebActivity {
	
	AndroidDriver driver;
	
	public WebActivity (AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(name="q")
	private WebElement searchField;
	
	public void search (String text) {
		
		searchField.sendKeys(text);
		searchField.sendKeys(Keys.ENTER);
	}

}
