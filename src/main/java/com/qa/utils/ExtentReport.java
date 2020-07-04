package com.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.wrappers.ProjectSpecificMethods;

public abstract class ExtentReport {

	ExtentHtmlReporter reporter;
	ExtentReports extent;
	
	public static String reportName;
	
	public void reportStep(String desc,String snapshotpath, String testresult) {
		
		try{
			setReportName();
			reporter = new ExtentHtmlReporter("./reports/"+reportName+".html");
			reporter.loadXMLConfig("./src/main/resources/extent-config.xml");
			reporter.setAppendExisting(true);
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			
			ExtentTest logger= extent.createTest(ProjectSpecificMethods.testCaseName);
			
			if(testresult.toUpperCase().equals("PASS")){
				logger.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/screenshots/"+snapshotpath+".png").build());
			}
			else{
				logger.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/screenshots/"+snapshotpath+".png").build());
			}
			
			extent.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void setReportName(){
		String dateName = new SimpleDateFormat("yyyyMMdd_hhmm").format(new Date());
		reportName = "Automation Testing Report"+dateName;
	}
	
}
