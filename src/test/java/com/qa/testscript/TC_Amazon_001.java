package com.qa.testscript;

import java.awt.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_Amazon_001 extends Amazon_TestBase{
	@Test(dataProvider="getInput",priority=1)
	public void AmazonSearch(String Category,String Product) throws InterruptedException {
		Select category = new Select(Amazon.getDropdown());
		category.selectByVisibleText(Category);
		Thread.sleep(3000);
		Amazon.getProductName().clear();
		Thread.sleep(1000);
		Amazon.getProductName().sendKeys(Product);
		Thread.sleep(1000);
		Amazon.getSearch().click();
		String SearchItem = driver.getTitle();
		if(SearchItem.contains(Product)) 
		{
			System.out.println("The title is same as search Item");
		}
		java.util.List<WebElement> PrintAllTitles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("All Titles = "+PrintAllTitles.size());
		for(WebElement Titles : PrintAllTitles) {
			System.out.println(Titles.getText());
		}
	}
	@DataProvider()
	public Object[][] getInput(){
		Object[][] data = new Object[3][2];
		
		data[0][0]="Books";
		data[1][0]="Appliances";
		data[2][0]="Electronics";
		
		data[0][1]="Da Vinci Code";
		data[1][1]="Washing machines";
		data[2][1]="Mobile phones";
		return data;
		
		
	}

}
