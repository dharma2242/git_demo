package com.qa.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSearchpages {
	 WebDriver driver;
		
	 @FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	   //@FindBy(xpath="//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
		WebElement EnterCategory;
		
		public WebElement getEnterCategory() {
			return EnterCategory;
		}
		
		@FindBy(className="_34RNph")
		WebElement Search;
		
		public WebElement getSearch(){
			return Search;		
		}
		
		@FindBy(xpath = "//div[@class='_4rR01T']")
		List<WebElement> AllTitles1;
		
		public List<WebElement> getAllTitles1(){
			return AllTitles1;
		}
		
		@FindBy(xpath = "//*[@class='s1Q9rs']")
		List<WebElement> AllTitles2;
		
		public List<WebElement> getAllTitles2(){
			return AllTitles2;
		}
		
		@FindBy(xpath="//input[@class='_36yFo0']")
		WebElement Pincode;
		
		public WebElement getPincode() {
			return Pincode;
		}
		
		@FindBy(xpath="//span[@class='_2P_LDn']")
		WebElement Check;
		
		public WebElement getCheck() {
			return Check;
		}
		
		@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
		WebElement AddToCart;
		
		public WebElement getAddToCart() {
			return AddToCart;
		}
		
		public FlipkartSearchpages(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			}

}
