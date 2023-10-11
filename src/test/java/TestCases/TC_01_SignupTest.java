package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import TestBase.BaseClassv2;
import Utilities.DataReader;
import PageObjects.Signup;

public class TC_01_SignupTest extends BaseClassv2 {
	
	@Test(priority=0)
	public void test_ValidSignup() throws InterruptedException, AWTException {

		Signup userSignup=new Signup(driver);
		Thread.sleep(2000);
//		userSignup.clickCreateAccount();
//		Thread.sleep(3000);
		userSignup.inputEmail(rb.getString("email_signup")); 
		userSignup.clickContinue();
		Thread.sleep(3000);
		userSignup.inputOtp(rb.getString("signup_otp"));
		Thread.sleep(3000);
		userSignup.inputFirstName("test");
		userSignup.inputLastName("automation");
		Thread.sleep(2000);
		userSignup.inputPassword(rb.getString("password_signup"));
		Thread.sleep(1000);
		userSignup.confirmPassword(rb.getString("confirmPassword_signup"));
		userSignup.accountCreate();
		Thread.sleep(3000);
		userSignup.clickAgreeandTerms();
	}
	
	@Test(priority=1)
	public void test_VerifyCompleteSignup() throws InterruptedException {
		Signup userSignup=new Signup(driver);
		Thread.sleep(4000);
		userSignup.verifyCompleteSignup();
	}
}
