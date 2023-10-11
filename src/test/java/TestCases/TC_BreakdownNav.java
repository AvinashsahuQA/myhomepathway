package TestCases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import PageObjects.Signin;
import PageObjects.Summary;
import TestBase.BaseClass;

public class TC_BreakdownNav extends BaseClass {
	
	@Test
	public void test_AddDownPayment() throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging_builder"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);	
		
		Summary userSummary=new Summary(driver);
		Thread.sleep(3000);
		userSummary.clickAddSavings();
		userSummary.chooseCategory();
		userSummary.addAmount();
		userSummary.addDownpayment();
		
	}

}
