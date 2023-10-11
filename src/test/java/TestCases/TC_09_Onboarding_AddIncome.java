package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.Onboarding_AddIncome;
import PageObjects.Onboarding_BankAccount;
import PageObjects.Onboarding_GenerateCredit;
import PageObjects.Onboarding_PersonalInfo;
import PageObjects.Signin;

public class TC_09_Onboarding_AddIncome extends BaseClass {
	
	@Test(priority=0)
	public void test_ValidOnboarding_addIncome() throws InterruptedException, AWTException {

		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);
		
		Onboarding_AddIncome userIncome=new Onboarding_AddIncome(driver);
		Thread.sleep(3000);
		userIncome.click_getStarted();
		Thread.sleep(4000);
		userIncome.click_addProvider();
		Thread.sleep(7000);
		userIncome.clickAgree();
		Thread.sleep(3000);
		userIncome.click_verifyInstantlyButton();
		Thread.sleep(3000);
		userIncome.add_payrollProvider();
		Thread.sleep(3000);
		userIncome.plaidLogin();
		Thread.sleep(3000);
		userIncome.click_submitButton();
		Thread.sleep(3000);
		userIncome.click_plaidEmployee_Radio();
		Thread.sleep(3000);
		userIncome.click_continueButton();
		Thread.sleep(3000);
		userIncome.click_allowButton();
		Thread.sleep(3000);
		userIncome.click_ContinueAgain();
		Thread.sleep(4000);
		userIncome.switchfromIframe();
		userIncome.click_CompleteButton();
		
	}
}
