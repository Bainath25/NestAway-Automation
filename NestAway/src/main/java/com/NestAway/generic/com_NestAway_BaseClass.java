package com.NestAway.generic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class com_NestAway_BaseClass implements IAutoConstant {
 
	public static WebDriver driver;
	@BeforeSuite
	public void ProductInfo()
	{
		Reporter.log("This is a NestAway project",true);
	}
	@BeforeTest
	public void setproperty()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter in which browser to open ? GC/FF");
		String browser=scn.next();
		if(browser.equalsIgnoreCase("GC"))
		{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF"))
		{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new FirefoxDriver();	
		}
		else {
			System.out.println("Please Enter GC or FF");
			setproperty();
			
		}
		scn.close();
	}

	@BeforeMethod
	public void OpenApp() throws InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.get(NESTAWAY_URL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(ETO, TimeUnit.SECONDS);
			
	}
	
	public void waitInSeconds(int i) throws InterruptedException {
		Thread.sleep(i * 1000);
	}
	
	public void waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	@AfterMethod
	public void CloseApp() throws InterruptedException
	{
		waitInSeconds(2);
		driver.quit();
	}
	@AfterSuite
	public void ExcelReport()
	{
		Reporter.log("Excel Report is generated ",true);
	}
}
