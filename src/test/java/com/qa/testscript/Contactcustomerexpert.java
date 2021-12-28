package com.qa.testscript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Contactcustomerexpert extends TC_Login_001 {
	
	
	
	@Test (dataProvider="data-provider")
	public void customerexpert(String typeofproduct,String typeofchat) throws InterruptedException, IOException {
	
		
		  String parent= driver.getWindowHandle();
			Thread.sleep(3000);
			Actions actions = new Actions(driver);
			
	if (typeofproduct.equalsIgnoreCase("ordered product"))
	{
			
			actions.moveToElement(customer.getflipkartmagnifier_button()).perform();
			
			if (typeofchat.equalsIgnoreCase("new chat")) 
			{
			
			customer.getorderspage().click();
			Thread.sleep(3000);
			customer.getselectorderedproduct().click();
			Thread.sleep(3000);
			customer.getNeed_help().click();
			
			}
			else
			{
				actions.moveToElement(customer.getMychatsbutton()).click().perform();
			}
			
			System.out.println("user should contact the customer expert");
	}
	else
	{
		actions.moveToElement(customer.getflipkartmagnifier_button()).perform();
		Thread.sleep(3000);
		customer.getWishlistpage().click();
		Thread.sleep(3000);
		customer.getSelectWishlistproduct().click();
		
		Set<String> allwindows =driver.getWindowHandles();
		
		System.out.println(allwindows);
		for (String child : allwindows) 
		{
			if (!parent.equals(child)) 
			{
				driver.switchTo().window(child);

				customer.getAskexpert().click();
			}
			}
		}
	
	
	Thread.sleep(3000);
	
		  
		  
	}
	@DataProvider( name = "data-provider")
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		
		data[0][0]="ordered product";
		data[1][0]="new product";
		
		
		data[0][1]="new chat";
		data[1][1]="old chat";
		return data;
		
	}
	
	

}
