package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userloginpages {

WebDriver driver;
	
	@FindBy(xpath="//div[@class = 'IiD88i _351hSN'] //input[@type= 'text']")
	WebElement usernamelogin;
	
	public WebElement getusernamelogin() {
		return usernamelogin;
	}
	
	@FindBy(xpath="//div[@class = 'IiD88i _351hSN'] //input[@type= 'password']")
	WebElement Passwordlogin;
	
	public WebElement getPasswordlogin() {
		return Passwordlogin;
	}
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
	WebElement LogInbutton;
	
	public WebElement getLogIn_button() {
		return LogInbutton;
	}
	
	public userloginpages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
