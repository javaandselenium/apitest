package com.skillrary.rmgyantra.sripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;

import com.skillrary.rmgyantra.genericlib.BaseClass;
import com.skillrary.rmgyantra.genericlib.IEndPoints;
import com.skillrary.rmgyantra.genericlib.JavaUtility;
import com.skillrary.rmgyantra.pojolib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddingSingleProjectwithOngoingstatus extends BaseClass{
	@Test
	public void onGoing() throws SQLException {
		 String projectName = "WWW03Api"+JavaUtility.getRandomNum();
			Project pobj=new Project("Johnny", projectName,5,"Ongoing");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.post(IEndPoints.addprojectwithongoingstatus);
		
		resp.then().log().all()
		.assertThat().statusCode(201);
		
		//capture project name and status
		String apiprojectname = resp.jsonPath().get("projectName");
		System.out.println(apiprojectname);
	String apistatus = resp.jsonPath().get("status");
	System.out.println(apistatus);
		
	System.out.println("Tc-3 is run successfully");	
		
		String projectnameresult = dblib.executequeryandGetData("select * from project",4,apiprojectname);
		String projectstatusresult = dblib.executequeryandGetData("select * from project",4,apistatus);
	
	
		
		
		
		
	}
	

}
