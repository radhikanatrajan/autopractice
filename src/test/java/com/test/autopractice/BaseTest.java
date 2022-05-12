package com.test.autopractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.test.autopractice.utils.ReadConfigProperties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class BaseTest {

	protected WebDriver driver;
	protected ReadConfigProperties readConfigProp;
	public void init(String browser) throws InterruptedException{
		
        Reporter.log("Opening "+browser + "Browser");


		if(browser.equals("Chrome"))
		{
	    
	 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	 
		    
		}
		if (browser.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(readConfigProp.getExplicitWait(),TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(readConfigProp.getExplicitWait()));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(readConfigProp.getExplicitWait()));

	}
		
 
	public void openApp() {
		driver.navigate().to(readConfigProp.getApplicationUrl());
		 
 	    JavascriptExecutor j = (JavascriptExecutor)driver;
	      if (j.executeScript("return document.readyState").toString().equals("complete")){
	         Reporter.log("Application Loaded");
	      }
	}
	
	@BeforeSuite
		public void setup(){
		 
			try 
			{
				 

				readConfigProp= ReadConfigProperties.getInstance(System.getProperty("user.dir")+File.separator+"configs"+File.separator+"config.properties");
				init("Chrome");
				openApp();
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
		}

			
 
	
	@AfterSuite
	public void quit(){
		 
		if(driver!=null) {
        Reporter.log("Quitting the Browser");

			driver.quit();
	}
	}	
		public void takeScreenShot(){
			 
			Date d=new Date();
			
			File directory = new File(System.getProperty("user.dir")+File.separator+"Screenshots");
			
			if(!directory.exists())
				directory.mkdirs();
			
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(directory.getAbsolutePath() + File.separator + "ScreenShot"+d.getTime()+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
}
 