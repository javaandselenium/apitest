package com.skillrary.rmgyantra.sripts;

import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import com.skillrary.rmgyantra.genericlib.BaseClass;
import com.skillrary.rmgyantra.genericlib.IEndPoints;
import com.skillrary.rmgyantra.genericlib.JavaUtility;
import com.skillrary.rmgyantra.pojolib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddingSingleProjectwithcompletedstatus extends BaseClass{
@Test
public void completed() throws SQLException {
	 String projectName = "WWW03"+JavaUtility.getRandomNum();
		Project pobj=new Project("John", projectName,5,"competed");
	
	Response resp = given()
	.contentType(ContentType.JSON)
	.body(pobj)
	.post(IEndPoints.addprojectwithcompletedstatus);
	
	resp.then().log().all()
	.assertThat().statusCode(201);
	
	//capture project name and status
			String apiprojectname = resp.jsonPath().get("projectName");
			System.out.println(apiprojectname);
		String apistatus = resp.jsonPath().get("status");
		System.out.println(apistatus);
		
		System.out.println("Tc-1 is run successfully");
			
			
			
			String projectnameresult = dblib.executequeryandGetData("select * from project",4,apiprojectname);
			String projectstatusresult = dblib.executequeryandGetData("select * from project",4,apistatus);
	
	
}
}
