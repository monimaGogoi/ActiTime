package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	
	//to get the data
	public static String getData(String pathname,String sheetname,int rn,int cn)
	{
		try {
		File file=new File(pathname);
		FileInputStream fis=new FileInputStream(file);
		
		Cell c = WorkbookFactory.create(fis).getSheet(sheetname).getRow(rn).getCell(cn);
		String d=c.toString();
		return d;
		} catch (Exception e) {
			return " ";
		}
	}
	
	//to get the data
		public static int getRowCount(String pathname,String sheetname)
		{
			try {
				File file=new File(pathname);
				FileInputStream fis=new FileInputStream(file);
				
				int rc = WorkbookFactory.create(fis).getSheet(sheetname).getLastRowNum();
				return rc;
				} catch (Exception e) {
					return 0;
				}
		}

		
		//to get the data
		public static int getCellCount(String pathname,String sheetname,int rn)
		{
			try {
				File file=new File(pathname);
				FileInputStream fis=new FileInputStream(file);
				
				int cc = WorkbookFactory.create(fis).getSheet(sheetname).getRow(rn).getLastCellNum();
				return cc;
				} catch (Exception e) {
					return 0;
				}
		}


}
