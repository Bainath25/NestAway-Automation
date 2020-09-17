package com.NestAway.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NestAway.generic.com_NestAway_BaseClass;

public class com_NestAway_SelectedHousePage extends com_NestAway_BaseClass {

	@FindBy(xpath = "//div[@id='hdp']/div[2]/div[2]/div/div/div/div[2]/div/div[2]")
	private WebElement Book;	
	@FindBy(xpath = "//div[contains(text(),'PAY ')]")
	private WebElement PayTokenAmount;
	@FindBy(xpath = "(//button[text()='Select this bed'])[1]")
	private WebElement SelectthisBed;
	@FindBy(xpath = "//div[@class='booking-move-in__date-box']")
	private WebElement MoveinDate;
	@FindBy(xpath = "//div[@aria-label='Thu Jul 23 2020']")
	private WebElement SelectDate;
	@FindBy(xpath = "//*[@class='checkmark'][1]")
	private WebElement CheckBox;
	@FindBy(xpath = "//div[text()='DEBIT CARD']")
	private WebElement DebitCardOption;
	@FindBy(xpath = "//*[@class='pay-payment-button']")
	private WebElement PayPaymentButton;
	@FindBy(xpath = "//*[text()='Pay  ₹2200 and block this Bed']")
	private WebElement PayPayment;
	
	public com_NestAway_SelectedHousePage(WebDriver driver) throws InterruptedException
	{
		 PageFactory.initElements(driver, this);
		
	}
	
	public void Book()
	{ 
		waitFor(Book);
		
	}
	public void PayTokenAmount()
	{
		waitFor(PayTokenAmount);
		
	}
	public void SelectthisBed()
	{
		waitFor(SelectthisBed);
		
	}
	public void MoveinDate() throws InterruptedException
	{
		waitInSeconds(1);
		waitFor(MoveinDate);
		
	}
	public void SelectDate()
	{
		waitFor(SelectDate);
	}
	public void CheckBox() throws InterruptedException
	{
		waitFor(CheckBox);
	    waitInSeconds(2);
		
	}
	public void DebitCardOption() throws InterruptedException
	{
		waitFor(DebitCardOption);
		waitInSeconds(2);
		
	}
	public void PayPaymentButton()
	{
		
	    	 waitFor(PayPaymentButton); 
	    	 
	}
	public void ScrollBy()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
	}
	
		
}
