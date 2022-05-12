package com.test.autopractice.pages;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
	
	private SelectionMenu sMenu;
	
 	@FindBy(how = How.XPATH,using = "//div[@id='block_top_menu']/ul/li/a[text()='Dresses']")

	public WebElement header;
	
	public HomePage(WebDriver driver) throws Exception{
		super(driver);
		sMenu=new SelectionMenu(driver);
		waitForPageLoad(header,"DRESSES");
	}
	
	
	 
		  

		
	 
	public SelectionMenu ChooseMenu( ) {

		return sMenu;
	}
	


}
