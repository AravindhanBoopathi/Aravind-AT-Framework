package com.qa.stepdefinitions;

import com.qa.wrappers.ProjectSpecificMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LaunchUrlSteps extends ProjectSpecificMethods{

	@Given("^set testcase details$")
	public void set_testcase_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		testCaseName = "Test Automation Script";
	
	}

	@Then("^launch url$")
	public void launch_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		initialization();
	}
	
	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.close();
	}
	
}
