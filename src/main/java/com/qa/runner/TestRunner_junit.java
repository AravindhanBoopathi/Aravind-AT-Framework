package com.qa.runner;

import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { 
				".\\src\\main\\java\\com\\qa\\features\\LaunchUrl.feature" 
				
		}, 
		glue = {"com/qa/stepdefinitions"},
		
		plugin = { "pretty", "json:target/cucumber/cucumber.json" }
		
		)
 
public class TestRunner_junit {
 
}

