package org.disan.pageObject.android;

import org.disan.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage (AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@FindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelectionDropdown;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopBtn;
	
	public void setName (String name) {
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender (String gender) {
		
		if (gender.contains("Male")) {	
			maleOption.click();
		}else {
			femaleOption.click();
		}
	}
	
	public void setCountry (String country) {
		
		countrySelectionDropdown.click();
		scrollToText(country);		
	}
	
	public void submitForm () {
		
		shopBtn.click();
	}
}
