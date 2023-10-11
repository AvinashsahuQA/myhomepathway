package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.ForgotPassword;
import PageObjects.Signin;

public class TC_05_ResetPassword extends BaseClass {
	
	@Test(priority=0)
	public void test_ResetPassword() throws InterruptedException, AWTException {

		ForgotPassword userResetPassword=new ForgotPassword(driver);
		userResetPassword.click_ForgotPassword();
		userResetPassword.inputEmail(rb.getString("email_signin_ResetPassword"));
		
		userResetPassword.click_Submit();
		Thread.sleep(2000);
		userResetPassword.inputOtp(rb.getString("signup_otp"));
		Thread.sleep(2000);
		userResetPassword.click_ResetPassword();
		//Thread.sleep(3000);
		userResetPassword.input_NewPassword(rb.getString("user_newPassword"));
		userResetPassword.confirm_NewPassword(rb.getString("user_confirmPassword"));
		Thread.sleep(2000);
		userResetPassword.click_ResetPassword();
		Thread.sleep(2000);
		userResetPassword.signIn();
	}
		
	
	@Test(priority=1)
	public void test_VerifyResetPassword() throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_signin_ResetPassword"));
		userSignin.inputPassword(rb.getString("user_newPassword"));
		userSignin.clickSignin();
		Thread.sleep(3000);
	}
}
