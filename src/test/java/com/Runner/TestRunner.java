package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "D:\\eclipse-workspace\\AutomationFramework\\src\\Feature File\\addNewCustomer.feature",
		dryRun = false,
		glue = "com.Steps",
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		plugin = {"pretty",
				"html:TestReport/login.html"})
public class TestRunner {

}
