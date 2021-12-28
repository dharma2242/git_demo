package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports exReports;
	public ExtentTest exTest;
	
	public void onStart(ITestContext testContext) {
		String dateStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
	 	String reportName = "Flipkart -TestAutomation Report"+dateStamp+ ".html";
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("Flipkart Test Automation");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		exReports = new ExtentReports();
		exReports.attachReporter(htmlReporter);
		exReports.setSystemInfo("QA Name", "Dharma");
		exReports.setSystemInfo("OS", "Windows 10");
		//exReports.setSystemInfo("HostName","DESKTOP-9QVPT6D");
		//exReports.setSystemInfo("Port Number", "192.168.29.158:54778");		
	}
	
	public void onFinish(ITestContext testContext) {
		exReports.flush();	
	}
	
	public void onTestSuccess(ITestResult tr) {
	   exTest=exReports.createTest(tr.getName());
	   exTest.log(Status.PASS, "The Test is Passed");
	   exTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	  }

	 
	  public void onTestFailure(ITestResult tr) {
		  
		   exTest=exReports.createTest(tr.getName());
		   exTest.log(Status.FAIL, "The Test is Failed!!");
		   exTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		   exTest.log(Status.FAIL, tr.getThrowable());
		   String SSPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		   File file = new File(SSPath);
		   if(file.exists())
		   {
			   try {
				exTest.fail("Screenshot for the failed test is: "+exTest.addScreenCaptureFromPath(SSPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		  }

	
	  public void onTestSkipped(ITestResult tr) {
		   exTest=exReports.createTest(tr.getName());
		   exTest.log(Status.SKIP, "The Test is Skipped!");
		   exTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREY));
		   exTest.log(Status.SKIP, tr.getThrowable());
	  }

	  public void onTestFailedWithTimeout(ITestResult tr) {
		  exTest=exReports.createTest(tr.getName());
		   exTest.log(Status.ERROR, "The Test is Failed and Timeout!");
		   exTest.log(Status.ERROR, MarkupHelper.createLabel(tr.getName(),ExtentColor.BLACK));
	  }
	

}
