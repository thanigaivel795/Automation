package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String getProperty(String path,String key) {
		Properties p=new Properties();
		String v="";
		try {
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		} 
	
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
		
	}
	public static void writeToExcel(String path,String sheet,int pass,int fail ) throws Exception, Exception, Exception {
		try {
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		w.getSheet(sheet).getRow(0).getCell(0).setCellValue(pass);
		w.getSheet(sheet).getRow(0).getCell(0).setCellValue(fail);
		w.write(new FileOutputStream(path));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static String getXLData(String path,String sheet,int r,int c ) {
		String v="";
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(sheet).getRow(r).getCell(c).toString();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	public static int getXLRowCount(String path,String sheet) {
		int count =0;
		try {
			Workbook w = WorkbookFactory.create(new FileInputStream(path));
			count =w.getSheet(sheet).getLastRowNum();
           }
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public static String getPhoto(WebDriver driver,String folder) {
		Date d=new Date();
		String dateTime=d.toString().replaceAll(":", "_");
		String path=folder+"/"+dateTime+".png";
		try {
			TakesScreenshot t=(TakesScreenshot) driver;
			File srcFile=t.getScreenshotAs(OutputType.FILE);
			File destFile=new File(path);
			FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
