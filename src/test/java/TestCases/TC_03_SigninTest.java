package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import Utilities.DataReader;
import PageObjects.Signin;

public class TC_03_SigninTest extends BaseClass {
	
	@Test(priority=0)
	public void test_ValidSignin() throws InterruptedException, AWTException {

		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(rb.getString("email_staging"));
		userSignin.inputPassword(rb.getString("password_staging"));
		userSignin.clickSignin();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1)
	public void test_Signout() throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		userSignin.clickSignout();
	}
}
