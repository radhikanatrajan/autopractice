package com.test.autopractice.pages;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class DressPage extends BasePage {
	private Actions actions;
	private Action action;
	public DressPage(WebDriver driver) {
		super(driver);
 		waitForPageLoad(header,"DRESSES");
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH,using ="//ul[contains(@class,'product_list')]//div[@class='product-container']//div[@class='right-block']//div[@class='content_price']/span[@itemprop='price']" )
	public List<WebElement> dressMenu;
	
	@FindBy(xpath="//h1[contains(@class,'page-heading product-listing')]/span[@class='cat-name']" )
	public WebElement header;
	
	String ADD_TO_CART_LINK="self::span/following::a[contains(@class,'ajax_add_to_cart_button')]/span[contains(text(),'Add to cart')]";
 	
 
	public ShoppingCartPage addHighPricedItem() throws ParseException {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        StringBuilder sbt=new StringBuilder();
        sbt.append("Price List : \n");
        BigDecimal maxvalue=new BigDecimal(0);
        WebElement maxElement = null;
        waitForListToPopulate(dressMenu);
		for(WebElement e: dressMenu) {
			String priceText=e.getText();
			        BigDecimal b1=new BigDecimal(nf.parse(priceText).toString());
			        sbt.append(priceText + "\n");
 			        if (b1.compareTo(maxvalue) == 1 || b1.compareTo(maxvalue) == 0) {
			        	maxvalue=b1;
			        	maxElement=e;
			        }
			}
         sbt.append("High Price :" + maxvalue+ "\n");
         Reporter.log(sbt.toString());
		 return addToCart(maxElement);
	 
		}
	
	 public ShoppingCartPage addToCart(WebElement e) {
		 actions = new Actions(driver);
		 actions.moveToElement(e);
		 actions.build().perform();
		 
		 waitAndClick(e.findElement(By.xpath(ADD_TO_CART_LINK)));
		 return new ShoppingCartPage(driver);
		 
	 }
 
	}
		 

