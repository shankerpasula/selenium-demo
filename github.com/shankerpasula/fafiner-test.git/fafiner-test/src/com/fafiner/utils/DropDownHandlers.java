package com.fafiner.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG.ExitCodeListener;

public class DropDownHandlers
{
	public static void selectOptionByIndex(
			WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}
	public static void selectOptionByVisibleText(
			WebElement ddl, String text)
	{
		Select sct = new Select(ddl);
		sct.selectByVisibleText(text);
	}
	public static void selectOptionByValue(
			WebElement ddl, String value)
	{
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}
	
	public static void selectAll(WebElement multiDDL) 
	{ 
		Select sct = new Select(multiDDL);
		boolean status = sct.isMultiple();
		
		if (status == true)
		{
			List<WebElement> Options = sct.getOptions();
			for (int i=0; i<Options.size(); i++)
			{
				sct.selectByIndex(i);
			}
		}
	}
	
	public static void deSelectAll(WebElement multiDDL)
	{
		
		Select sct = new Select(multiDDL);
		boolean status = sct.isMultiple();
		
		if (status == true)
		{
			List<WebElement> SelectedOptions = sct.getAllSelectedOptions();
			if (SelectedOptions.size()>=1)
			{
				sct.deselectAll();
			}
			else
			{
				System.err.println("No Options Selected to deselect");
			}
		}
	}
}



