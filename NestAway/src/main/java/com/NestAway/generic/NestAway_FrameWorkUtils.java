package com.NestAway.generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * This class provides all the utility methods of the automation framework
 * @author  BINATH
 *
 */
public class NestAway_FrameWorkUtils {
//Due to easy of use all the methods will be static
	/**
	 * This method is used to get the Data from Excel Sheet
	 * @param path
	 * @param sheet_name
	 * @param row
	 * @param cell
	 */
	static Workbook wk;
	static FileInputStream fis;
	public static String getXLData(String path,String Sheet_name,int row,int cell)
	{
		String data="";
		try
		{
			fis=new FileInputStream(path);
			wk=WorkbookFactory.create(fis);
			data=wk.getSheet(Sheet_name).getRow(row).getCell(cell).toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
			public void ScreenShot(WebDriver driver,String path)
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(path);
			try
			{
			FileUtils.copyFile(srcFile, destFile);	
			}catch (Exception e) {
				e.printStackTrace();
			}		
	}
}

