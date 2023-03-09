package org.disan;

import org.disan.pageObject.ios.AlertViews;
import org.disan.pageObject.ios.HomePage;
import org.disan.testUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IOSBaseTest {
	
	@Test	
	public void IOSBasicsTest () throws InterruptedException {
		
		HomePage homepage = new HomePage(driver);
		homepage.selectAlertViews();
		
		AlertViews alertViews = new AlertViews(driver);
		alertViews.fillTextLabel("Hello World");
		String actualMsg = alertViews.getConfirmMessage();
		Assert.assertEquals(actualMsg, "A message should be short, complete sentence.");
		alertViews.submit();
	}
}
