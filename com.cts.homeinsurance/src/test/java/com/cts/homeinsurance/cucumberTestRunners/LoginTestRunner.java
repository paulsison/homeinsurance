package com.cts.homeinsurance.cucumberTestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/cts/homeinsurance/features/LoginTest.feature",
		glue = "com/cts/homeinsurance/definitions")
public class LoginTestRunner {
	/* A demonstration of a CUCUMBER implementation similar to Scenario_03.java*/

}