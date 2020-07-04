package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.qa.wrappers.ProjectSpecificMethods;

import ru.sbtqa.tag.pagefactory.PageFactory;

public class SamplePage extends ProjectSpecificMethods {

	//Page Factory - Object Repository:
	@FindBy(xpath = "")
	public WebElement test;

	//Initializing the Page Objects
	public SamplePage(RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		
	
	
}
