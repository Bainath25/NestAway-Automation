package com.NestAway.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.NestAway.generic.com_NestAway_BaseClass;

public class com_NestAway_LoginPage extends com_NestAway_BaseClass{
	@FindBy(xpath = "//*[text()='Menu']")
	private WebElement Menubar;
	@FindBy(xpath = "(//div[@class='Button PrimeButton'])[1]")
	private WebElement Menu_Login;
	@FindBy(name = "username")
	private WebElement username_textBox;
	@FindBy (xpath = "(//div[@class='Button PrimeButton'])[1]") 
	private WebElement Continue_button;
	@FindBy (id = "password")
	private WebElement password_textBox;
	@FindBy (xpath = "//div[@class='Button PrimeButton'][1]")
	private WebElement Login_button;
	
	public com_NestAway_LoginPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	public void ClickMenu()
	{
		waitFor(Menubar);
		
	}
	public void ClickMenuLogin() throws InterruptedException
	{
	
		waitFor(Menu_Login);
		
	}
	public void EnterUsername(String enterusername)
	{
		username_textBox.sendKeys(enterusername);
	}
	public void ClickContinue()
	{
		waitFor(Continue_button);
		
		
	}
	public void EnterPassword(String enterpassword)
	{
	
		password_textBox.sendKeys(enterpassword);
	}
	public void ClickLogin() throws InterruptedException
	{
		waitFor(Login_button);
	    waitInSeconds(3);
		
	}

}
