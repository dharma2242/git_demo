package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class expertchataccess {
WebDriver driver;
	
	
	
	@FindBy(xpath="//div[@class = 'go_DOp'] //div[contains (text() , 'Flipkart')]")
	WebElement flipkartmagnifier_button;
	public WebElement getflipkartmagnifier_button() {
		return  flipkartmagnifier_button;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Orders')]")
	WebElement orderspage;
	public WebElement getorderspage() 
	{
		return orderspage;
	}
	@FindBy(xpath="//span[contains(text(),'SharpDart USB Micro Cable V3.1 3.1 A 1.0...')]")
	WebElement selectorderedproduct;
	public 	WebElement getselectorderedproduct() {
		return selectorderedproduct;
	}
@FindBy(xpath="//span[contains(text(),'Need help?')]")
WebElement Need_help;
public WebElement getNeed_help() {
	return Need_help;
}
@FindBy(xpath="//div[contains(text(),'My Chats')]")
WebElement Mychatsbutton;
public WebElement getMychatsbutton() {
	return  Mychatsbutton;
}
@FindBy(xpath="//div[contains(text(),'Wishlist')]")
WebElement Wishlistpage;
public WebElement getWishlistpage() {
	return Wishlistpage;
}
@FindBy(xpath="//div[contains(text(),'IFB 6.5 kg 3D Wash technology, Triadic Pulsator, Smart Sense Fully Automatic Top Load Grey')]")
WebElement SelectWishlistproduct;
public WebElement getSelectWishlistproduct() {
	return SelectWishlistproduct;
}
	
@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[2]/div[1]/button[1]")
WebElement Askexpert;
public WebElement getAskexpert() {
	return Askexpert;
}

 public expertchataccess(WebDriver driver) {
	 this.driver= driver;
	 PageFactory.initElements(driver, this);
	 
 }

}
