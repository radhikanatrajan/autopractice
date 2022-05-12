package com.test.autopractice.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.autopractice.utils.ReadConfigProperties;

import static org.awaitility.Awaitility.await;

 
public class BasePage {
	protected WebDriver driver;
	ReadConfigProperties readConfigProp;
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
	  
		PageFactory.initElements(driver,this);
		readConfigProp= ReadConfigProperties.getInstance();
	}
	
	protected WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(Exception.class);
		return wait; 
		
	 
	}
 
	public void waitForPageLoad(  WebElement element,String txt) {
		 
		try {
			
		await().atMost(readConfigProp.getExplicitWait(),TimeUnit.SECONDS).pollInterval(500,TimeUnit.MILLISECONDS)
		.ignoreExceptions()	
		.until(() -> element.getText().toUpperCase().contains(txt.toUpperCase()),Is.is(true));
 		}
		catch(Exception e) {
			
		}

	}
	
	public void waitForElementToAppear(  WebElement element) {
		 
		try {
			
		await().atMost(readConfigProp.getExplicitWait(),TimeUnit.SECONDS).pollInterval(500,TimeUnit.MILLISECONDS)
		.ignoreExceptions()	
		.until(() -> element.isEnabled() & element.isDisplayed(),Is.is(true));
 		}
		catch(Exception e) {
			
		}

	}
	
	public void waitForListToPopulate(  List<WebElement> dressMenu) {
		 
		try {
			
			await().atMost(readConfigProp.getExplicitWait(),TimeUnit.SECONDS).pollInterval(500,TimeUnit.MILLISECONDS)
			.ignoreExceptions()	
			.until(() -> dressMenu.size()>=1,Is.is(true));
			System.out.println(dressMenu.size());
		}
		catch(Exception e) {
			
		}

	}
	
	public void waitAndClick(  WebElement element) {
		 
		try {
			 getWait().until(ExpectedConditions.elementToBeClickable(element));
			 element.click();
			 
		}
		catch(Exception e) {
			
		}

	}
	
	
}
