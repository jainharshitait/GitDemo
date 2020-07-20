package Fremeworks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ThreadLocal<ExtentTest> ex=new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		
		
		ex.get().fail(result.getThrowable());
		System.out.println("test failure detected");
		WebDriver driver = null;
		String name=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ex.get().addScreenCaptureFromPath(getScreenshot(name,driver),result.getMethod().getMethodName());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		
	}
	
	ExtentReports extent=ExtentReporterNG.config();

	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		ex.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		ex.get().log(Status.PASS, "Test Passed");
		
	}
	

}
