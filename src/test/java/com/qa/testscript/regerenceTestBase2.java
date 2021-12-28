package com.qa.testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pages.FlipkartCustomerExpertpages;
import com.qa.pages.expertchataccess;
import com.qa.pages.userloginpages;


public class regerenceTestBase2 {
	WebDriver driver=null;
	userloginpages User;
	FlipkartCustomerExpertpages customer;
	
	//FlipkartMyProfilePages MyProfile;
	FileInputStream location;
	Properties prop;
	
	@Parameters({"Browser"})
	@BeforeMethod
	public void setUp(String Browser) throws IOException
	{
		
		location = new FileInputStream("D:\\dharma\\selenium software\\New folder\\ECLIPSE WORKPATH2020-06\\FlipKart\\src\\test\\java\\com\\qa\\testdata\\Credentials.properties");
		prop = new Properties();
		prop.load(location);
		//1. Invoke the browser
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\iampj\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver(); //Recommended	 		
		}
		else
		{	 		
			System.setProperty("webdriver.edge.driver", "C:\\Users\\iampj\\Downloads\\edge.exe");
			driver = new EdgeDriver();
		}
		//driver.manage().window().maximize();
		User = new userloginpages(driver);
		customer = new FlipkartCustomerExpertpages(driver);
		//MyProfile = new FlipkartMyProfilePages(driver);
		
		//2. Launch the amazon.in url
		driver.get("https://www.flipkart.com/");			
	}

	@AfterMethod
	public void tearDown()
	{
		//9. close the browser.
		driver.close();
		driver.quit();
	}

}
