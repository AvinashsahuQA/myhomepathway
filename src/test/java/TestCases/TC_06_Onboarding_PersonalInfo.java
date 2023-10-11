package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.Onboarding_PersonalInfo;
import PageObjects.Signin;

public class TC_06_Onboarding_PersonalInfo extends BaseClass {
	
	@Test(priority=0)
	public void test_ValidOnboarding_personalInfo() throws InterruptedException, AWTException {

		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);
		
		Onboarding_PersonalInfo userOnboarding=new Onboarding_PersonalInfo(driver);
		userOnboarding.click_getStarted();
		Thread.sleep(2000);
		userOnboarding.uploadProfileIcon();
		Thread.sleep(4000);
		userOnboarding.inputDOB();
		Thread.sleep(3000);
		userOnboarding.inputAddress();
		Thread.sleep(2000);
		userOnboarding.clickContinue();
		Thread.sleep(3000);
		userOnboarding.select_MilitaryServiceOption();
		Thread.sleep(2000);
		userOnboarding.select_RentOption();
		Thread.sleep(2000);
		userOnboarding.select_buyHomeOption();
		Thread.sleep(2000);
		userOnboarding.select_HomeGoal();
		Thread.sleep(2000);
		userOnboarding.select_TimelineForHome();
		Thread.sleep(2000);
		userOnboarding.select_homeAddressToBuy();
		Thread.sleep(2000);
		userOnboarding.add_Contact();
		Thread.sleep(2000);
		
		
		
	}
}
