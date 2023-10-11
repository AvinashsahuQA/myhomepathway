package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.Onboarding_GenerateCredit;
import PageObjects.Onboarding_PersonalInfo;
import PageObjects.Signin;

public class TC_07_Onboarding_GenerateCredit extends BaseClass {
	
	@Test(priority=0)
	public void test_ValidOnboarding_generateCredit() throws InterruptedException, AWTException {

		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);
		
		Onboarding_GenerateCredit userGenerateCredit=new Onboarding_GenerateCredit(driver);
		Thread.sleep(4000);
		userGenerateCredit.click_getStarted();
		Thread.sleep(4000);

		userGenerateCredit.clickContinue();
		Thread.sleep(12000);
		userGenerateCredit.input_SocialSecurityNumber();
		Thread.sleep(2000);

		userGenerateCredit.clickNextButton();
		Thread.sleep(2000);
		userGenerateCredit.printAnswers();
		
	}
}
