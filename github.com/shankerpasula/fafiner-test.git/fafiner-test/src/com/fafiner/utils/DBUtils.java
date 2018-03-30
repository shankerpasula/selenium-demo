package com.fafiner.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtils {
	static Connection connection;
	static Statement statement;
	static ResultSet rs;
	

	public static void connectToDatabase(String DataBaseUrl, String userName, String password) {
		try {
			connection = DriverManager.getConnection(DataBaseUrl, userName, password);
			System.out.println("Connecting to DatBase....");
			if (connection != null) {
				System.out.println("Connected to DatBase");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<ArrayList<String>> getDataFromDatabase(String query) {
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int colCount = rsmd.getColumnCount();
		    
		    System.out.println(colCount);
		    ArrayList<String> l = new ArrayList<String>();
		    for (int i=1; i<=colCount; i++)
		    {
		    	String colName = rsmd.getColumnName(i);
		    	l.add(colName);
		    }
		    al.add(l);
		    int columnNumber = 0;
	    	while (rs.next()) 
			{
	    		l = new ArrayList<String>();
	    		while(columnNumber != colCount)
	    			l.add(rs.getString(al.get(0).get(columnNumber++)));
	    		al.add(l);
	    		columnNumber = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < al.size(); i++)
			//System.out.println(arr.get(i));
			al.get(i);
		return al;

	}
	
	
	public static void closeDatabase() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
