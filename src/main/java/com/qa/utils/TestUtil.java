package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	public static String getScreenshot(WebDriver driver){
		TakesScreenshot ts =(TakesScreenshot) driver;
	
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = new SimpleDateFormat("yyyyMMdd_hhmm").format(new Date());
		String imagepath = "./reports/screenshots/"+path+".png";
		
		File dest = new File(imagepath);
		
		try{
			FileUtils.copyFile(src, dest);
		}catch(IOException e){
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
	
/*	public static String getFullScreenshot(WebDriver driver){
		
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000).takeScreenshot(driver));
	
		String path = new SimpleDateFormat("yyyyMMdd_hhmm").format(new Date());
		String imagepath = System.getProperty("user.dir")+"./../reports/screenshots/"+path+".png";
			
		try{
			ImageIO.write(s.getImage(), "png", new File(imagepath));
		}catch(IOException e){
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
	}
*/	
}
