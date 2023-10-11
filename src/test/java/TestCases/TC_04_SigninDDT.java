package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Signin;
import TestBase.BaseClass;
import Utilities.DataReader;

public class TC_04_SigninDDT extends BaseClass{

	@Test(priority=0)
	public void test_WithoutInput() {
		Signin userSignin=new Signin(driver);
		userSignin.clickSignin();
	}
	
	@Test(dataProvider="SigninData",priority=1)
	public void test_SigninDataDrivenTest(HashMap<String,String> input) throws InterruptedException, AWTException {
		
		Signin userSignin=new Signin(driver);
		userSignin.inputEmail(input.get("email"));
		userSignin.inputPassword(input.get("password"));
		userSignin.clickSignin();
		userSignin.clearInput();
	}
	
	@DataProvider
	public Object[][] SigninData() throws IOException
	{

		DataReader dr=new DataReader();
		List<HashMap<String,String>> data = dr.getJsonData(System.getProperty("user.dir")+"//src//test//java//TestData//SigninData.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) },{data.get(2)},{data.get(3)} };
		
	}


}
