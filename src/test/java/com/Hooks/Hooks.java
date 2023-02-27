package com.Hooks;

import com.Base.CommonMethods;
import com.Base.InitDriver;
import com.Enum.browser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void start() {
		InitDriver.launchBrowser(browser.CHROME);
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

		InitDriver.tearDown();
	}

}
