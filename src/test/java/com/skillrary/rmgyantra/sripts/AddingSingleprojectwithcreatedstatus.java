package com.skillrary.rmgyantra.sripts;

import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.testng.annotations.Test;

import com.skillrary.rmgyantra.genericlib.BaseClass;
import com.skillrary.rmgyantra.genericlib.IEndPoints;
import com.skillrary.rmgyantra.genericlib.JavaUtility;
import com.skillrary.rmgyantra.pojolib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddingSingleprojectwithcreatedstatus extends BaseClass{
	@Test
	public void createStatus() throws SQLException {
		 String projectName = "WWW03"+JavaUtility.getRandomNum();
		Project pobj=new Project("John", projectName,5,"created");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.post(IEndPoints.addprojectwithcreatedstatus);
		resp.then().log().all()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON);
		
		
		//capture project name and status
		String apiprojectname = resp.jsonPath().get("projectName");
		System.out.println(apiprojectname);
	String apistatus = resp.jsonPath().get("status");
	System.out.println(apistatus);
		
	System.out.println("Tc-2 is run successfully");
		
		String projectnameresult = dblib.executequeryandGetData("select * from project",4,apiprojectname);
		String projectstatusresult = dblib.executequeryandGetData("select * from project",4,apistatus);
	}
	

}
