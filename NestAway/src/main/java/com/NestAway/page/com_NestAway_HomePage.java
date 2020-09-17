package com.NestAway.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NestAway.generic.com_NestAway_BaseClass;

public class com_NestAway_HomePage extends com_NestAway_BaseClass{
	@FindBy(id = "mainSearchBox")
	private WebElement MainSearchBox;
	@FindBy(xpath = "//*[text()='hsr layout']")
	private WebElement Hsr_Layout;
	@FindBy(xpath = "//*[@title='Komala Nest 301']")
	private WebElement Housepicker;
	@FindBy(xpath = "//div[@class='close']")
	private WebElement closealert;
	@FindBy(xpath = "//div[text()='LOGOUT']")
	private WebElement Logout;
	
	
	public com_NestAway_HomePage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	
	public void ClickMainSearchBox() throws InterruptedException 
	{
		waitInSeconds(2);
		waitFor(MainSearchBox);
		
	}
	public void ClickHsr_Layout()
	{
		waitFor(Hsr_Layout);
	
	}
	public void ScrollBy() throws InterruptedException
	{
		waitInSeconds(10);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,700)");
	}
	
	public void Housepicker()
	{
		waitFor(Housepicker);
	}
	
	public void closealert()
	{
		waitFor(closealert);
	}
	public void Logout()
	{
		waitFor(Logout);
	}
			
		
}	

