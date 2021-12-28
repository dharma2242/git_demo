package com.qa.testscript;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.excelUtility;

public class TC_FlipkartApplnSearch_003 extends TC_Login_001 {
	@Test(priority = 1,dataProvider = "getData")
	public void FlipkartSearch(String category,String pincode,String product , String item) throws InterruptedException, IOException
	{
		SoftAssert sAssert = new SoftAssert();
		SearchOR.getEnterCategory().sendKeys(category);
		SearchOR.getSearch().click();
		String parent = driver.getWindowHandle();
		String SearchItem = driver.getCurrentUrl();
		//System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		if(SearchItem.contains(category))
		{
			Reporter.log("The title is same as category",true);
			sAssert.assertTrue(true);
		}
		else
		{
			captureSS(driver,"FlipkartSearch");
			Reporter.log("The title is not same as category",true);
			sAssert.assertTrue(false);
		}
		Thread.sleep(3000);
		List<WebElement> PrintAllTitles1 = SearchOR.getAllTitles1();
		Thread.sleep(3000);
		List<WebElement> PrintAllTitles2 = SearchOR.getAllTitles2();
		Thread.sleep(3000);
 		int size1 = PrintAllTitles1.size();
		int size2 = PrintAllTitles2.size();
		Thread.sleep(3000);
		//System.out.println("All titles of size1: " +size1);
		Reporter.log("All titles of size1: "+size1,true);
		//sAssert.assertTrue(true);
		Thread.sleep(3000);
		//System.out.println("All titles of size2: "+size2);
		Reporter.log("All titles of size2: "+size2,true);
		//sAssert.assertTrue(true);
		if(size1 !=0 && size1 < 25 )
		{
			for(WebElement Titles1 : PrintAllTitles1)
			{
				System.out.println(Titles1.getText());
				/*Reporter.log(Titles1.getText(),true);
				sAssert.assertTrue(true);*/
				Thread.sleep(3000);
				if (Titles1.getText().contains(product)) 
				{
					Thread.sleep(3000);
					Reporter.log("list contains the product name",true);
					sAssert.assertTrue(true);
					Titles1.click();
					System.out.println(driver.getTitle());
					Set<String> allwindows = driver.getWindowHandles();
					for (String child1 : allwindows) 
					{
						if (!parent.equals(child1)) 
						{
							driver.switchTo().window(child1);
							Thread.sleep(5000);
							System.out.println(driver.getTitle());
							String producttitle = driver.getTitle();
							Thread.sleep(5000);
							if(producttitle.contains(item))
							{
								Reporter.log("User is landed on product page",true);
								sAssert.assertTrue(true);
							}
							else
							{
								captureSS(driver,"FlipkartSearch");
								Reporter.log("User is not landed on product page",true);
								sAssert.assertTrue(false);
							}
							SearchOR.getPincode().sendKeys(pincode);
						    SearchOR.getCheck().click();
						    Reporter.log("Pincode is validated",true);
							sAssert.assertTrue(true);
							//System.out.println("Pincode is validated");
							Thread.sleep(3000);
							SearchOR.getAddToCart().click();
							Thread.sleep(3000);
							//System.out.println("Product is added to cart Successfully");
							String title = driver.getTitle();
							Thread.sleep(3000);
							if(title.contains("Shopping Cart"))
							{
								Reporter.log("Product is added to cart Successfully",true);
							    sAssert.assertTrue(true);
							}
							else
							{
								captureSS(driver,"FlipkartSearch");
								Reporter.log("Product is not added to cart Successfully",true);
								sAssert.assertTrue(false);
							}
							Thread.sleep(3000);
						}
					}
				}
			/*	else 
				{
					//System.out.println("Titles does not contain product name");
					Reporter.log("Item is not available",true);
					sAssert.assertTrue(false);
				} */
			}
		}
		else if(size2!=0 && size2 > 25)
		{
			for(WebElement Titles2 : PrintAllTitles2)
			{
				Thread.sleep(3000);
				System.out.println(Titles2.getText());
				/*Reporter.log(Titles2.getText(),true);
				sAssert.assertTrue(true);*/
				Thread.sleep(3000);
				if(Titles2.getText().contains(product))
				{
					Reporter.log("list contains the product name",true);
					sAssert.assertTrue(true);
					Titles2.click();
					System.out.println(driver.getTitle());
					Set<String> allwindows = driver.getWindowHandles();
					for (String child1 : allwindows) 
					{
						if (!parent.equals(child1)) 
						{
							driver.switchTo().window(child1);
							Thread.sleep(3000);
							String producttitle = driver.getTitle();
							System.out.println(driver.getTitle());
							Thread.sleep(5000);
							if(producttitle.contains(item))
							{
								Reporter.log("User is landed on product page",true);
								sAssert.assertTrue(true);
							}
							else
							{
								captureSS(driver,"FlipkartSearch");
								Reporter.log("User is not landed on product page",true);
								sAssert.assertTrue(false);
							}
							SearchOR.getPincode().sendKeys(pincode);
							SearchOR.getCheck().click();
							//System.out.println("Pincode is validated");
							Reporter.log("Pincode is validated",true);
							sAssert.assertTrue(true);
							Thread.sleep(3000);
							SearchOR.getAddToCart().click();
							Thread.sleep(3000);
							//System.out.println("Product is added to cart Successfully");
							String title = driver.getTitle();
							if(title.contains("Shopping Cart"))
							{
								Reporter.log("Product is added to cart Successfully",true);
							    sAssert.assertTrue(true);
							}
							else
							{
								captureSS(driver,"FlipkartSearch");
								Reporter.log("Product is not added to cart Successfully",true);
								sAssert.assertTrue(false);
							}
							Thread.sleep(3000);
						}
					}
				}
				/*else 
				{
					//System.out.println("Titles does not contain product name");
					Reporter.log("Item is not available",true);
					sAssert.assertTrue(false);
				}*/
			}
		}
		else
		{
			captureSS(driver,"FlipkartSearch");
			//System.out.println("Size is not less than or greater than 25");
			Reporter.log("Size is not less than or greater than 25",true);
			sAssert.assertTrue(false);
		}
		sAssert.assertAll();
	}
	
	@DataProvider
	public String[][] getData() throws IOException
      {
		String exFile = "D:\\dharma\\selenium software\\New folder\\ECLIPSE WORKPATH2020-06\\FlipKart\\src\\test\\java\\com\\qa\\testdata\\Flipkart_Test_Data.xlsx";
		String exSheet= "Sheet2";
		
		int rowCount =excelUtility.getRowCount(exFile, exSheet);
		int cellCount =excelUtility.getCellCount(exFile, exSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		for (int i = 1 ; i<=rowCount ; i++) 
		{
			for (int j =0 ; j<cellCount ; j++) 
			{
				data [i-1][j]= excelUtility.getCellData(exFile, exSheet, i, j);
				System.out.println(data);
			}
		}
		return data;
      }

	/*@Test(priority = 1,dataProvider = "getData")
	public void FlipkartSearch(String category,String pincode,String product) throws InterruptedException
	{
		SoftAssert sAssert = new SoftAssert();
		SearchOR.getEnterCategory().sendKeys(category);
		SearchOR.getSearch().click();
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		Thread.sleep(3000);
		List<WebElement>  PrintAllTitles1 = SearchOR.getAllTitles1();
		Thread.sleep(3000);
		List<WebElement> PrintAllTitles2 = SearchOR.getAllTitles2();
		Thread.sleep(3000);
 		int size1 = PrintAllTitles1.size();
		int size2 = PrintAllTitles2.size();
		Thread.sleep(3000);
		//System.out.println("All titles of size1: " +size1);
		Reporter.log("All titles of size1: "+size1,true);
		sAssert.assertTrue(true);
		Thread.sleep(3000);
		//System.out.println("All titles of size2: "+size2);
		Reporter.log("All titles of size2: "+size2,true);
		sAssert.assertTrue(true);
		if(size1 !=0 && size1 < 25 )
		{
			for(WebElement Titles1 : PrintAllTitles1)
			{
				//System.out.println(Titles1.getText());
				Reporter.log(Titles1.getText(),true);
				sAssert.assertTrue(true);
				Thread.sleep(3000);
				if (Titles1.getText().contains(product)) 
				{
					Reporter.log("Titles contains product name",true);
					sAssert.assertTrue(true);
					Titles1.click();
					Set<String> allwindows = driver.getWindowHandles();
					for (String child1 : allwindows) 
					{
						if (!parent.equals(child1)) 
						{
							driver.switchTo().window(child1);
							Thread.sleep(3000);
							SearchOR.getPincode().sendKeys(pincode);
						    SearchOR.getCheck().click();
						    
						String contains =    driver.findElement(By.xpath("//div[contains(text(),'Not a valid pincode')]")).getText();
						    if(contains!= "valid pincode")
						    	
							//System.out.println("Pincode is validated");
							Reporter.log("Pincode is validated",true);
							sAssert.assertTrue(true);
							Thread.sleep(3000);
							SearchOR.getAddToCart().click();
							Thread.sleep(3000);
							//System.out.println("Product is added to cart Successfully");
							String title = driver.getTitle();
							if(title.contains("Shopping Cart"))
							{
								Reporter.log("Product is added to cart Successfully",true);
							    sAssert.assertTrue(true);
							}
							else
							{
								Reporter.log("Product is not added to cart Successfully",true);
								sAssert.assertTrue(true);
							}
							Thread.sleep(3000);
						}
					}
				}
				else 
				{
					//System.out.println("Titles does not contain product name");
					Reporter.log("Titles does not contain product name",true);
					sAssert.assertTrue(true);
				}
			}
		}
		else if(size2!=0 && size2 > 25)
		{
			for(WebElement Titles2 : PrintAllTitles2)
			{
				Thread.sleep(3000);
				//System.out.println(Titles2.getText());
				Reporter.log(Titles2.getText(),true);
				sAssert.assertTrue(true);
				Thread.sleep(3000);
				if(Titles2.getText().contains(product))
				{
					Reporter.log("Titles contains product name",true);
					sAssert.assertTrue(true);
					Titles2.click();
					Set<String> allwindows = driver.getWindowHandles();
					for (String child1 : allwindows) 
					{
						if (!parent.equals(child1)) 
						{
							driver.switchTo().window(child1);
							Thread.sleep(3000);
							SearchOR.getPincode().sendKeys(pincode);
							SearchOR.getCheck().click();
							//System.out.println("Pincode is validated");
							Reporter.log("Pincode is validated",true);
							sAssert.assertTrue(true);
							Thread.sleep(3000);
							SearchOR.getAddToCart().click();
							Thread.sleep(3000);
							//System.out.println("Product is added to cart Successfully");
							String title = driver.getTitle();
							if(title.contains("Shopping Cart"))
							{
								Reporter.log("Product is added to cart Successfully",true);
							    sAssert.assertTrue(true);
							}
							else
							{
								Reporter.log("Product is not added to cart Successfully",true);
								sAssert.assertTrue(true);
							}
							Thread.sleep(3000);
						}
					}
				}
				else 
				{
					//System.out.println("Titles does not contain product name");
					Reporter.log("Titles does not contain product name",true);
					sAssert.assertTrue(true);
				}
			}
		}
		sAssert.assertAll();
	}
	
	@DataProvider
	public String[][] getData() throws IOException
      {
		String exFile = "D:\\\\dharma\\\\selenium software\\\\New folder\\\\ECLIPSE WORKPATH2020-06\\\\FlipKart\\\\src\\\\test\\\\java\\\\com\\\\qa\\\\testdata\\\\Flipkart_Test_Data.xlsx";
		String exSheet= "Sheet2";
		
		int rowCount =excelUtility.getRowCount(exFile, exSheet);
		int cellCount =excelUtility.getCellCount(exFile, exSheet, rowCount);
		
		String[][] data=new String[rowCount][cellCount];
		for (int i = 1 ; i<=rowCount ; i++) 
		{
			for (int j =0 ; j<cellCount ; j++) 
			{
				data [i-1][j]= excelUtility.getCellData(exFile, exSheet, i, j);
				System.out.println(data);
			}
		}
		return data;
      }*/



}
	
			
	
	
	
	



