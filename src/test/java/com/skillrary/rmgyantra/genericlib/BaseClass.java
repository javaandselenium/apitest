package com.skillrary.rmgyantra.genericlib;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {
	public DataBaseUtilities dblib=new DataBaseUtilities();
	
	@BeforeSuite
	public void ConfigBS() throws SQLException {
		RestAssured.baseURI="http://localhost:8084";
		dblib.connectToDB();
		
	}
	
	@AfterSuite
	public void ConfigAS() throws SQLException {
		dblib.closeDb();
	}

}
