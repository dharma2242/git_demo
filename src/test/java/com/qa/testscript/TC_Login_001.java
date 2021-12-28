package com.qa.testscript;


import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Login_001 extends TestBase {
	
	
	@BeforeMethod
	public void loginTo() throws InterruptedException
	{
		
		User.getusernamelogin().sendKeys(prop.getProperty("username"));
		User.getPasswordlogin().sendKeys(prop.getProperty("password"));
		User.getLogIn_button().click();
	//Alert alert =driver.switchTo().alert().sendKeys(keysToSend);
		Thread.sleep(3000);
	}
	

}
