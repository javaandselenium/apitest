package com.skillrary.rmgyantra.genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtilities {
	public static Driver driverrref;
	public static Connection con;
	public ResultSet result;
	
	
	public void connectToDB() throws SQLException {
		driverrref=new Driver();
		DriverManager.registerDriver(driverrref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		
	}
	public ResultSet executeQuery(String query) throws SQLException {
		return result=con.createStatement().executeQuery(query);
	}
	
	public String executequeryandGetData(String query,int colname,String expdata) throws SQLException {
		result=con.createStatement().executeQuery(query);
		
		while(result.next()) {
			if(result.getString(colname).equals(expdata)) {
				break;
			}
			else
			{
				System.out.println("Data not found");
			}
		}
		return expdata;
	}
	
	public void closeDb() throws SQLException {
		con.close();
	}

}
