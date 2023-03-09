package org.disan.pageObject.ios;

import org.disan.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends IOSActions {
	
	IOSDriver driver;
	
	public AlertViews (IOSDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticTest[`label=='Text Entry'`]")
	private WebElement textEntryMenu;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement textBox;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement acceptPopUp;
	
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
	private WebElement confirmMenuItem;
	
	@iOSXCUITFindBy(iOSNsPredicate="name BEGINSWITH[c] 'A message'")
	private WebElement confirmMessage;
	
	@iOSXCUITFindBy(iOSNsPredicate="label=='CONFIRM'")
	private WebElement submit;
	
	public void fillTextLabel (String text) {
	
		textEntryMenu.click();
		textBox.sendKeys(text);
		acceptPopUp.click();
	}
	
	public String getConfirmMessage () {
		
		confirmMenuItem.click();
		return confirmMessage.getText();
	}
	
	public void submit () {
		
		submit.click();
	}
}
