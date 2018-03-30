package com.fafiner.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData
{
	public static String fromExcel(String fileName,
			String sheetName,
			int rowIndex, int cellIndex)
	{
		String data = null;
		try
		{
			File f = new File("./test-data/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			data = c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}	
public static String fromProperties(String fileName, String key) 
	{
		String value = null;
		try
		{
			File f = new File("./test-config/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			// Step 3
			Properties prop = new Properties();
			prop.load(fis);
			value = (String) prop.get(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
}