package com.qa.testscript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mongodb.assertions.Assertions;
import com.qa.utility.excelUtility;


public class TC_CustomerChat_004 extends TC_Login_001 {
	
	
	
	@Test (dataProvider="data-provider")
	public void CustomerExpert(String typeofproduct,String typeofchat) throws InterruptedException, IOException {
	
		SoftAssert sAssert = new SoftAssert();
		  String parent= driver.getWindowHandle();
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			
		
	if (typeofproduct.equalsIgnoreCase("ordered product"))
	{
			
			actions.moveToElement(customer.getflipkartmagnifier_button()).perform();
			
			if (typeofchat.equalsIgnoreCase("new chat")) 
			{
			customer.getorderspage().click();
			boolean ordered_page= driver.getCurrentUrl().contains("home_orders");
			if(ordered_page)
			{
				Reporter.log("user is landed on ordered page", true);
				sAssert.assertTrue(true);
			}
			else 
			{
				captureSS(driver,"CustomerExpert");
				Reporter.log("user is not landed on ordered page", true);
				sAssert.assertTrue(false);
			}
			
			Thread.sleep(3000);
			customer.getselectorderedproduct().click();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(3000);
			customer.getNeed_help().click();
			
			boolean mychats_page = driver.getCurrentUrl().contains("my-chats");
			
			if(mychats_page) 
			{
				
			Reporter.log("customer is allowed to chat with agent", true);
			sAssert.assertTrue(true);
			}
			else {
				captureSS(driver,"CustomerExpert");
				Reporter.log("customer is not allowed to chat with agent", true);
				sAssert.assertTrue(false );
				}
		
			}
			else
			{
				actions.moveToElement(customer.getMychatsbutton()).click().perform();
				
				boolean mychats = driver.getCurrentUrl().contains("my-chats");
				
				if(mychats) 
				{
				Reporter.log("customer is allowed to chat with agent", true);
				sAssert.assertTrue(true);
				}
				else {
					captureSS(driver,"CustomerExpert");
					Reporter.log("customer is not allowed to chat with agent", true);
					sAssert.assertTrue(false );
				}
			}
			
	}

	else
	{
		actions.moveToElement(customer.getflipkartmagnifier_button()).perform();
		Thread.sleep(3000);
		customer.getWishlistpage().click();
		System.out.println(driver.getCurrentUrl());
		boolean contains = driver.getCurrentUrl().contains("home_wishlist");
		if(contains) {
		Reporter.log("user is landed on Wishlist page", true);
		sAssert.assertTrue(true);
		}
		else
		{
			captureSS(driver,"CustomerExpert");
			Reporter.log("user is not landed on Wishlist page", true);
			sAssert.assertTrue(false);
		}
		Thread.sleep(3000);
		customer.getSelectWishlistproduct().click();
		Thread.sleep(3000);
	//boolean Selectproduct =customer.getSelectWishlistproduct().isSelected();
		//System.out.println(customer.getSelectWishlistproduct().isSelected());
	/*if(customer.getSelectWishlistproduct().isSelected()) {
		Reporter.log("user is landed product information page", true);
		sAssert.assertTrue(true);
	}
	else {
		Reporter.log("user is not landed product information page", true);
		sAssert.assertTrue(false);
	}
		*/
		Set<String> allwindows =driver.getWindowHandles();
		
		System.out.println(allwindows);
		for (String child : allwindows) 
		{
			if (!parent.equals(child)) 
			{
				driver.switchTo().window(child);
				Thread.sleep(3000);
				customer.getAskexpert().click();
				Thread.sleep(3000);
			
				boolean newproductchat = driver.getCurrentUrl().contains("my-chats");
				if(newproductchat )		
				{
				Reporter.log("customer is allowed to chat with agent", true);
				sAssert.assertTrue(true);
						}
				else {
					captureSS(driver,"CustomerExpert");
					Reporter.log("customer is not allowed to chat with agent", true);
					sAssert.assertTrue(true);
				}			
			}
			}
		}
	
	sAssert.assertAll();
	Thread.sleep(3000);
	
		  
		  
	}
	
	@DataProvider (name = "data-provider")
	public String[][] getData() throws IOException {
		
		String exFile = "D:\\dharma\\selenium software\\New folder\\ECLIPSE WORKPATH2020-06\\FlipKart\\src\\test\\java\\com\\qa\\testdata\\Flipkart_Test_Data.xlsx";
		String exSheet= "Sheet1";
		
		int rowCount =excelUtility.getRowCount(exFile, exSheet);
		int cellCount =excelUtility.getCellCount(exFile, exSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		for (int i = 1 ; i<=rowCount ; i++) {
			for (int j =0 ; j<cellCount ; j++) {
				data [i-1][j]= excelUtility.getCellData(exFile, exSheet, i, j);
				
			}
		}
		
		return data;
		
	}
	

}
