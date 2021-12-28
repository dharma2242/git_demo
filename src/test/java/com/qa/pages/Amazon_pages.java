package com.qa.pages;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_pages  {
	WebDriver driver;
	@FindBy(id = "searchDropdownBox")
	WebElement Dropdown;
	public WebElement getDropdown() {
		return Dropdown;
	}
	@FindBy(id = "twotabsearchtextbox")
	WebElement ProductName;
	public WebElement getProductName() {
		return ProductName;
	}
	@FindBy(id ="nav-search-submit-button")
	WebElement Search;
	public WebElement getSearch() {
		return Search;
	}
	/*@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
	List AllTitles;
	public List getAllTitles()
	{
		return AllTitles;
	}*/
	public Amazon_pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
