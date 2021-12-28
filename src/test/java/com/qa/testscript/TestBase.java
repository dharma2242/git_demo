package com.qa.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.FlipkartSearchpages;
import com.qa.pages.Flipkart_Travel_Pages;
import com.qa.pages.expertchataccess;
import com.qa.pages.userloginpages;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	WebDriver driver=null;
	userloginpages User;
	expertchataccess customer;
	FlipkartSearchpages SearchOR;
	Flipkart_Travel_Pages TravelOR;
	   
	
	
	
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
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();		
		}
		else
		{	 		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		//driver.manage().window().maximize();
		User = new userloginpages(driver);
		customer = new expertchataccess(driver);
		SearchOR = new FlipkartSearchpages(driver);
		TravelOR= new Flipkart_Travel_Pages(driver);
		
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
	
	public void captureSS(WebDriver driver,String tName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is captured successfully");
	}
}
