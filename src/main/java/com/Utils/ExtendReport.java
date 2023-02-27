package com.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {

	public static void main(String[] args) {

		// blank report 
		ExtentSparkReporter reporter = new ExtentSparkReporter("./report.html");
		
		// report
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);

		ExtentTest test = extend.createTest("Test name");
		test.assignAuthor("Tamil").assignCategory("Smoke");
		test.pass("No failure observed");
		test.pass("No issue found");
		test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		
		// last
		extend.flush();
	}

}
