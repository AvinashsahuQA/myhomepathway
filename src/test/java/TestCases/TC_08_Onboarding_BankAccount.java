package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.Onboarding_BankAccount;
import PageObjects.Onboarding_GenerateCredit;
import PageObjects.Onboarding_PersonalInfo;
import PageObjects.Signin;

public class TC_08_Onboarding_BankAccount extends BaseClass {
	
	@Test(priority=0)
	public void test_ValidOnboarding_bankAccount() throws InterruptedException, AWTException {

		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);
		
		Onboarding_BankAccount userBankAccount=new Onboarding_BankAccount(driver);
		Thread.sleep(4000);
		userBankAccount.click_getStarted();
		Thread.sleep(4000);
		userBankAccount.click_AddAccount();
		Thread.sleep(7000);
		userBankAccount.clickAgree();
		Thread.sleep(3000);
		userBankAccount.click_selectInstitution();
		Thread.sleep(3000);
		userBankAccount.click_continueToLogin();
		Thread.sleep(3000);
		/*userBankAccount.inputUsernamePlaid();
		Thread.sleep(3000);
		userBankAccount.inputPasswordPlaid();
		Thread.sleep(3000);
		userBankAccount.click_SigninPlaid();
		Thread.sleep(3000);
		userBankAccount.click_getCode();
		Thread.sleep(3000);
		userBankAccount.enterCode();
		Thread.sleep(3000);
		userBankAccount.click_submitCode();
		Thread.sleep(3000);
		userBankAccount.click_plaidChecking_Checkbox();
		Thread.sleep(3000);
		userBankAccount.click_additionalInfo_Checkbox();
		Thread.sleep(3000);
		userBankAccount.click_additionalInfo1_Checkbox();
		Thread.sleep(3000);
		userBankAccount.clickContinue();
		Thread.sleep(3000);
		userBankAccount.termsConditions_Checkbox();
		Thread.sleep(3000);
		userBankAccount.click_connectAccount();*/
//		userBankAccount.click_finishAccount();
//		userBankAccount.complete_Account();
	}
}
