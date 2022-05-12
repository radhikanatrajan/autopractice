package com.test.autopractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectionMenu extends BasePage {
	DressPage dressPg;
 	public SelectionMenu(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(how = How.XPATH,using = "//div[@id='block_top_menu']/ul/li/a[text()='Dresses']")
	public WebElement dressMenu;
	
	public DressPage clickDresses() throws Exception
	{
		  waitForPageLoad(dressMenu,"DRESSES");
		  waitAndClick(dressMenu);
		//  dressMenu.click();
		  dressPg=new DressPage(driver);
		  return dressPg;
	}
	
	
 
	
}
