package qsp;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class demo {
public static void main(String[] args) throws Exception  {
	FileInputStream f=new FileInputStream("./data/book1.xlsx");
     Workbook w = WorkbookFactory.create(f);
	String s = w.getSheet("sheet1").getRow(1).getCell(0).toString();
	System.out.println(s);
}
}
