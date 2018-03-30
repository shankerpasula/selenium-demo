package com.fafiner.test.smoke;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.log4testng.Logger;

import com.fafiner.utils.DBUtils;
import com.fafiner.utils.ExcelUtils;

public class DBCall {
	final static Logger logger = Logger.getLogger(DBCall.class);
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		logger.info("Enter Logger for DBCall Class");
		DBUtils.connectToDatabase("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=grc-scan-bd0150.int.thomsonreuters.com)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=ohstd23a.int.thomsonreuters.com)))", "blrnavqaent17", "blrnavqaent17");
		ArrayList<ArrayList<String>> data = DBUtils.getDataFromDatabase("select * from configurationuser");
		ExcelUtils.writDBdataToExcel("testdata", "Sheet1", data);
		DBUtils.closeDatabase();

	}

}
