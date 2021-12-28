package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_Travel_Pages {
	
WebDriver driver;
	
	@FindBy(xpath="//div[@class = 'IiD88i _351hSN'] //input[@type= 'text']")
	WebElement MobileNumber;
	
	public WebElement getMobileNumber() {
		return MobileNumber;
	}
	
	@FindBy(xpath="//div[@class = 'IiD88i _351hSN'] //input[@type= 'password']")
	WebElement Password;
	
	public WebElement getPassword() {
		return Password;
	}
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	WebElement LogIn;
	
	public WebElement getLogIn() {
		return LogIn;
	}
	
	@FindBy(xpath="//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]")
	WebElement Travel;
	

	public WebElement getTravel() {
		return Travel;
		
	}
	
	@FindBy(xpath="//div[contains(text(),'Travel')]")
	WebElement TravelClick;
	

	public WebElement getTravelClick() {
		return TravelClick;
		
	}
	
	
	
	@FindBy(xpath="//*[@class='_1w3ZZo _1YBGQV _2EjOJB lZd1T6 _2vegSu _2mFmU7']")
	WebElement FromCity;
	

	public WebElement getFromCity() {
		return FromCity;
		
	}
	
	@FindBy(xpath = "//*[@id='container']/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div/div[2]")
	List<WebElement> titles;
	
	public List<WebElement> gettitles(){
		return titles;
	}
	
	@FindBy(xpath="//span[contains(text(),'Hyderabad')]")
	WebElement ToCity;
	

	public WebElement getToCity() {
		return ToCity;
		
	}
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div/table[1]/tbody/tr[4]/td[3]/div/button")
	WebElement Date1;
	
	public WebElement getDate1() {
		return Date1;	
	}
	
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div[1]/div[2]/form/div/div[3]/div[2]/div/input")
	WebElement Date2;
	

	public WebElement getDate2() {
		return Date2;
		
	}
	
	@FindBy(xpath="//*[@id='container']/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div[3]/button")
	WebElement Travelers;
	

	public WebElement getTravelers() {
		return Travelers;
		
	}
	
	@FindBy(xpath="//*[@id='container']/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div[1]/div[2]/div/label[2]/div[1]")
	WebElement CabinClass;
	
	public WebElement getCabinClass() {
		return CabinClass;
		}
	
	
	
	@FindBy(xpath="//*[@id='container']/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/div[3]/div[1]/div[2]/div/div/div/div[2]/button")
	WebElement Done;
	

	public WebElement getDone() {
		return Done;
		
	}
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[2]/div[1]/div/div[2]/div/div[2]/form/div/button")
	WebElement Search;
	

	public WebElement getSearch() {
		return Search;
		
	}
	
	
	
	
	
	public Flipkart_Travel_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

}
