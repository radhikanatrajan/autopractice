package com.test.autopractice.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ShoppingCartPage extends BasePage{
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
 		waitForElementToAppear(cartInfo);
		// TODO Auto-generated constructor stub
	}
		@FindBy(how = How.XPATH,using ="//div[contains(@class,'layer_cart_product_info')]" )
		public WebElement cartInfo;
		
		@FindBy(id="layer_cart_product_title" )
		public WebElement title;
		
		
		public String printDressTitle() {
			return title.getText();
			
		}
		
}


