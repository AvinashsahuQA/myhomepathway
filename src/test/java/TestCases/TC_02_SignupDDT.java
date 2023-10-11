package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Signin;
import PageObjects.Signup;
import TestBase.BaseClass;
import TestBase.BaseClassv2;
import Utilities.DataReader;

public class TC_02_SignupDDT extends BaseClassv2{

	
	@Test(priority=0)
	public void enterEmailandOtp() throws InterruptedException, AWTException {
		Signup userSignup=new Signup(driver);
		userSignup.inputEmail(rb.getString("email_signupDDT"));
		userSignup.clickContinue();
		Thread.sleep(3000);
		userSignup.inputOtp(rb.getString("signup_otp"));
		Thread.sleep(3000);
	}
	
	
	@Test(dataProvider="SignupData",priority=1)
	public void test_SignupDataDrivenTest(HashMap<String,String> input) throws InterruptedException, AWTException {
		
		Signup userSignup=new Signup(driver);
		Thread.sleep(0);
		userSignup.inputFirstName(input.get("firstName"));
		userSignup.inputLastName(input.get("lastName"));
		Thread.sleep(2000);
		userSignup.inputPassword(input.get("password"));
		Thread.sleep(1000);
		userSignup.confirmPassword(input.get("confirmPassword"));
		userSignup.accountCreate();
		Thread.sleep(1000);
		userSignup.clearInput();
	}
	
	@DataProvider
	public Object[][] SignupData() throws IOException
	{

		DataReader dr=new DataReader();
		List<HashMap<String,String>> data = dr.getJsonData(System.getProperty("user.dir")+"//src//test//java//TestData//SignupData.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) },{data.get(2)},{data.get(3)} };
		
	}


}
