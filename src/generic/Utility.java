package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	public static void writeToExcel(String path,int pass,int fail ) throws Exception, Exception, Exception {
		Workbook w = WorkbookFactory.create(new FileInputStream(path));
		w.getSheet("sheet1").getRow(0).getCell(0).setCellValue(pass);
		w.getSheet("sheet1").getRow(0).getCell(0).setCellValue(fail);
		w.write(new FileOutputStream(path));

	}

}
