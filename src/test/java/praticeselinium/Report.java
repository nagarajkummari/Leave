package praticeselinium;


import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	static ExtentReports report;
	
	public static ExtentReports report()
	{
	String path = System.getProperty("user.dir")+"\\Rport\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Booking Ticket");
	reporter.config().setDocumentTitle("Testing");
	
	report = new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("Tester", "Nagaraj");
	
	return report;
	}
}
