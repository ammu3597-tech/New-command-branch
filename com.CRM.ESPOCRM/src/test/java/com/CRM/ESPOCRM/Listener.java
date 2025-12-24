package com.CRM.ESPOCRM;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listener implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;
	//ITestListener
	public void onTestStart(ITestResult result) {
	           System.out.println("========"+result.getMethod().getMethodName()+"======START======");
	           test = report.createTest(result.getMethod().getMethodName());
	           UtilityClassObject.setTest(test);
	           test.log(Status.INFO, result.getMethod().getMethodName()+"======START======");
	           }

	public void onTestSuccess(ITestResult result) {
	 System.out.println("========"+result.getMethod().getMethodName()+"======END======");
	 test.log(Status.INFO, result.getMethod().getMethodName()+"======END======");
	 }

	public void onTestFailure(ITestResult result) {
	   String TestName = result.getMethod().getMethodName();
	   TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
	   //temporary location
	 File srcFile = ts.getScreenshotAs(OutputType.FILE);
	  String time = new Date().toString().replace(" ","_").replace(":","_");
	 File destFile = new File("./Screenshot/"+TestName+"+"+time+".png");
	 try {
	org.openqa.selenium.io.FileHandler.copy(srcFile, destFile);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	 String Filepath =ts.getScreenshotAs(OutputType.BASE64);
	 test = report.createTest(result.getMethod().getMethodName());
	 test.addScreenCaptureFromBase64String(Filepath, TestName+time);

	 System.out.println("Screenshot saved successfully!");

	 }
	public void onTestSkipped(ITestResult result) {
	   // not implemented
	 }
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   // not implemented
	 }
	public void onTestFailedWithTimeout(ITestResult result) {
	   onTestFailure(result);
	 }
	public void onStart(ITestContext context) {
	System.out.println("Report configuration");
	}
	public void onFinish(ITestContext context) {
	   System.out.println("report Backup");
	   }
	//ISuiteListener

	public void onStart(ISuite suite) {
	//spark report configuration
	   String time = new Date().toString().replace(" ","_").replace(":","_");
	spark = new ExtentSparkReporter("./AdvanceReport/Report_"+time+".html");
	spark.config().setDocumentTitle("CRM test suite result");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.STANDARD);

	//Add environment information
	report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows-11");
	report.setSystemInfo("Browser", "Chrome");
	   
	 }
	public void onFinish(ISuite suite) {
	   // not implemented
	report.flush();
	 }


}
