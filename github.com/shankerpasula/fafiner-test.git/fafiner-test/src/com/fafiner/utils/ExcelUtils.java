package com.fafiner.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public static void CreateNewFile(String fileName) {
        //get current project path
        String filePath = "./test-data";
        //create a new file
        File file = new File(filePath+"/"+fileName);

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File is created");
            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writDBdataToExcel (String fileName,String sheetName,ArrayList<ArrayList<String>> data) throws InvalidFormatException, IOException 
	{
		File f = new File("./test-data/"+fileName+".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet(sheetName);
		for(int i = 0; i < data.size();i++)
		{
			Row r = st.createRow(i);
			for(int j = 0; j < data.get(i).size();j++)
			{
				Cell c = r.createCell(j);
				c.setCellValue(data.get(i).get(j));
			}
		}
        try 
        {
        	FileOutputStream fos = new FileOutputStream("./test-data/"+fileName+".xlsx");
            wb.write(fos);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
	}
	
}
