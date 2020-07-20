package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
		public static ExtentReports config()
		{
			String path=System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			reporter.config().setReportName("Web automation results");
			reporter.config().setDocumentTitle("Test Results");
			extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Harshita");
			return extent;
		} 
	

}
