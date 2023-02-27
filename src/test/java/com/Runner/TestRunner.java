package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/Feature File/",
		glue = "com.Steps",
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				"html:TestReport/login.html"})
public class TestRunner {

}
