package com.Steps;

import com.Base.CommonMethods;
import com.Base.InitDriver;
import com.Enum.browser;
import com.Utils.ExtendReport;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void start() {
		InitDriver.launchBrowser(browser.CHROME);
		ExtendReport.reportName("Guru99 Bank Application");
		
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;
		if (scenario.isFailed()) {
			// take screenshot and save it in /failed
			picture = CommonMethods.screenShot("failed/" + scenario.getName());
		} else {
			// take screenshot and put it in /passed folder
			picture = CommonMethods.screenShot("passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());
		
		ExtendReport.reportFlush();

		InitDriver.tearDown();
	}

}
