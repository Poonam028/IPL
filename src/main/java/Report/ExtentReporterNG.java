package Report;

import java.io.File;

import org.testng.ITestListener;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements ITestListener {
//  private static ExtentReports extent;
//
//	
//	public static ExtentReports getReportObject() {
//      if (extent == null) {
//		{
//			
//			String path = System.getProperty("user.dir")+"\\Reports\\index.html";
//			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
//			reporter.config().setReportName("Poonam sawant");
//			reporter.config().setDocumentTitle("IPL Automation Test Result");
//			
//		    extent = new ExtentReports();
//			extent.attachReporter(reporter);
//			extent.setSystemInfo("Tester", "Poonam Sawant");
//		}
//			}
//		return extent;
//		
//		
//	}
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Poonam Sawant");
		return extent;	
	}
}
