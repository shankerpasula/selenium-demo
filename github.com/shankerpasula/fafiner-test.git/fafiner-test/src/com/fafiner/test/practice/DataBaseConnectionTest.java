package com.fafiner.test.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.List;

public class DataBaseConnectionTest {

   private Connection connection;
   private static Statement statement;
   private static ResultSet rs;

    @BeforeClass
    public void setUp() {
            String databaseURL = "jdbc:oracle:thin:@localhost:1525:XE";
            String user = "v450";
            String password = "v450";
            connection = null;
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                System.out.println("Connecting to Database...");
                connection = DriverManager.getConnection(databaseURL, user, password);
                if (connection != null) {
                    System.out.println("Connected to the Database...");
                }
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
         
    }

    @Test
    public void getEmployeesFromDataBase() {
        try {
            String query = "select * from configurationuser";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
            	String CONFIGUSERID= rs.getString("CONFIGUSERID");
            	System.out.println(CONFIGUSERID);
                String NAME= rs.getString("NAME");
                String VALUE= rs.getString("NAME");
                System.out.println(CONFIGUSERID+"\t"+NAME+"\t"+VALUE);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
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