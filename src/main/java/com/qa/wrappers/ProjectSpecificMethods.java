package com.qa.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.qa.utils.ExtentReport;
import com.qa.utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.sbtqa.tag.pagefactory.PageFactory;

public class ProjectSpecificMethods extends ExtentReport{

	public static RemoteWebDriver driver;
	public static Properties prop;

	public static String testCaseName;
	public static String browser,url;
	public static int pageLoadTimeOut,implicitwait;


	//Page Factory - Object Repository:
	@FindBy(xpath = "")
	public WebElement test;

	//Initializing the Page Objects
	public ProjectSpecificMethods(RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProjectSpecificMethods(){
		try{
			prop = new Properties();
//			FileInputStream fis = new FileInputStream(this.getClass().getClassLoader().getResource("config.properties").getFile());	
//			prop.load(fis);

			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			pageLoadTimeOut = Integer.valueOf(prop.getProperty("pageLoadTimeOut"));
			implicitwait = Integer.valueOf(prop.getProperty("implicitWait"));

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void initialization(){
		try{
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			}else if(browser.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();


			}else if(browser.equalsIgnoreCase("ie")){
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();


			}else if(browser.equalsIgnoreCase("edge")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}else{
				System.out.println("Invalid browser name");
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut , TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait( implicitwait , TimeUnit.SECONDS);
			driver.get(url);

			String snapshotpath = TestUtil.getScreenshot(driver);
			reportStep("The browser:" + browser + " launched successfully", snapshotpath, "PASS");

		}catch(Exception e){

			String snapshotpath = TestUtil.getScreenshot(driver);
			reportStep("The browser:" + browser + " could not be launched", snapshotpath, "FAIL");


		}
	}

}
