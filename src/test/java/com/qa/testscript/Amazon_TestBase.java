package com.qa.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.pages.Amazon_pages;

public class Amazon_TestBase {
	WebDriver driver;
	String Browser= "Chrome";
	Amazon_pages Amazon;
	@BeforeClass
	public void setup() {
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\iampj\\Downloads\\chromedriver.exe");
		    driver = new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","\"E:\\edgedriver_win64 (1)\\msedgedriver.exe\"");
			driver=new ChromeDriver();
		}
		Amazon = new Amazon_pages(driver);
		driver.get("https://www.amazon.in/");
	}
	
		@AfterClass
	    public void teardown() throws InterruptedException 
		{
	    	Thread.sleep(3000);
	    	driver.close();
	    }


}
