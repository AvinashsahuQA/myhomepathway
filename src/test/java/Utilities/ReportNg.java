package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportNg {
	
	public static ExtentReports getReport() {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="Test Report-" +timestamp+ ".html";
		String path=System.getProperty("user.dir")+ "//Report//" + reportName ;
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Web Automation Results");
		spark.config().setDocumentTitle("Test Results");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("QA Tester","Avinash");
		extent.setSystemInfo("Application", "My HomePathWay");	
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("System Name", "Lenovo Thinkpad");
		extent.setSystemInfo("Environment", "QA");
		return extent;
	}

}
