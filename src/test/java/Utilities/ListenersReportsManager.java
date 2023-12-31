package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ListenersReportsManager extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ReportNg.getReport();

	@Override

	/*public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}*/

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// test.fail(result.getThrowable());

		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
