package TestCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import PageObjects.Signin;
import TestBase.BaseClass;
import PageObjects.Summary;

public class TC_Summary extends BaseClass {
	
	@Test
	public void test_SelectBuilder_Journey() throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging_builder"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);	
		
		Summary userSummary=new Summary(driver);
		userSummary.clickSelectJourney();
		userSummary.clickBuilder();
		Thread.sleep(3000);	
		
	}
	
	@Test
	public void test_SelectDesigner_Journey() throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		Thread.sleep(3000);	
		userSignin.inputEmail(rb.getString("email_staging_designer"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);	
		
		Summary userSummary=new Summary(driver);
		userSummary.clickSelectJourney();
		userSummary.clickDesigner();
		Thread.sleep(3000);	
		
		
	}

}
