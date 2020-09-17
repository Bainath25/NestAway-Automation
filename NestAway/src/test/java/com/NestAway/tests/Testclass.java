package com.NestAway.tests;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.NestAway.generic.NestAway_FrameWorkUtils;
import com.NestAway.generic.PaymentPage;
import com.NestAway.generic.com_NestAway_BaseClass;
import com.NestAway.page.com_NestAway_HomePage;
import com.NestAway.page.com_NestAway_LoginPage;
import com.NestAway.page.com_NestAway_SelectedHousePage;
public class Testclass extends com_NestAway_BaseClass {
	@Test
	public void login() throws InterruptedException
	{
		com_NestAway_LoginPage lp=new com_NestAway_LoginPage(driver);
		lp.ClickMenu();
		lp.ClickMenuLogin();
		String username=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Login", 1, 0);
		lp.EnterUsername(username);
		lp.ClickContinue();
		String password=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Login", 1, 1);
		lp.EnterPassword(password);
		lp.ClickLogin();
		
		
		/*
		 * 
		 * This is Home page related content
		 * 
		 */
		com_NestAway_HomePage hp= new com_NestAway_HomePage(driver);
		hp.ClickMainSearchBox();
		hp.ClickHsr_Layout();
		hp.ScrollBy();
		hp.Housepicker();
		
		
		/**
		 * 
		 * This is Selected House related content
		 * 
		 */
		com_NestAway_SelectedHousePage shp=new com_NestAway_SelectedHousePage(driver);
		Set<String> whs = driver.getWindowHandles();
		Iterator<String> it = whs.iterator();
		String homeBrowser = it.next();
		String childbrowser = it.next();
		driver.switchTo().window(childbrowser);	
		shp.Book();
		shp.PayTokenAmount();
		shp.ScrollBy();
		shp.SelectthisBed();
		shp.MoveinDate();
		shp.SelectDate();
		shp.CheckBox();
		shp.DebitCardOption();
		shp.PayPaymentButton();
		
		
		/**
		 *
		 * This is payment page related content
		 * 
		 */
		PaymentPage pp=new PaymentPage(driver);
		String cardnumber=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Payment", 1, 0);
		pp.EnterCardNumber(cardnumber);
		String cardexpiry=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Payment", 1, 1);
		pp.EnterExpiry(cardexpiry);
		String cardcvv=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Payment", 1, 2);
		pp.EnterCVV(cardcvv);
		String cardname=NestAway_FrameWorkUtils.getXLData(TEST_INPUT_DATA, "Payment", 1, 3);
		pp.Entername(cardname);
		pp.Proceed();
		driver.close();
		//driver.switchTo().window(childbrowser).close();
		waitInSeconds(2);
		driver.switchTo().window(homeBrowser);
		//driver.findElement(By.xpath("//div[@class='close']")).click();
		lp.ClickMenu();
		waitInSeconds(2);
		hp.Logout();
		
		
		
		
	}

}
