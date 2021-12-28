package com.qa.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart_Travel_005 extends TC_Login_001 {
	
	@Test
	public void Travel() throws InterruptedException {
	
Actions option= new Actions(driver);
	
      option.moveToElement(TravelOR.getTravel()).perform();
      option.moveToElement(TravelOR.getTravelClick()).click().perform();
	Thread.sleep(5000);
	TravelOR.getFromCity().click();
	TravelOR.getFromCity().sendKeys("Mumbai");
	Thread.sleep(3000);
	List<WebElement> titles = TravelOR.gettitles();
	for (WebElement title : titles) 
	{
		System.out.println(title.getText());
		if (title.getText().contains("Mumbai, India")) 
		{
			title.click();
		}
	}
	Thread.sleep(3000);
	TravelOR.getToCity().click();
	Thread.sleep(3000);
	TravelOR.getDate1().click();
	Thread.sleep(3000);
	TravelOR.getTravelers().click();
	Thread.sleep(3000);
	TravelOR.getCabinClass().click();
	Thread.sleep(3000);	
	TravelOR.getDone().click();
	Thread.sleep(3000);
	TravelOR.getSearch().click();
}

}
