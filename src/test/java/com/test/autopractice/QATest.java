package com.test.autopractice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import com.test.autopractice.pages.DressPage;
import com.test.autopractice.pages.HomePage;
import com.test.autopractice.pages.ShoppingCartPage;
import com.test.autopractice.BaseTest;
public class QATest extends BaseTest{
	
     
	@Test
	public void chooseHighPriceDress()
	{
		try {
			HomePage hPg=new HomePage(driver);
			DressPage dressPg=hPg.ChooseMenu().clickDresses();
			ShoppingCartPage sCartPg=dressPg.addHighPricedItem();
			Reporter.log(sCartPg.printDressTitle());
			 takeScreenShot();
		}
		catch(Exception e) {
			e.printStackTrace();
			takeScreenShot();
			Reporter.log("Failed to add item to Cart");
			
		}
		
		
		
	}
	
	 


}
