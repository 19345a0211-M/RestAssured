package in.rest.RestAssuredDemo;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POST_Request {
	HashMap <String, String> country = new HashMap <String, String>();
	
	@BeforeMethod
	public void createPayLoad() {
	country .put("name","India");
	country .put("capital","New Delhi");
	RestAssured.baseURI = "https://reqres.in/";
	RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void createResource() {
		RestAssured
		 .given()
		      .contentType("application/json")
		      .body(country)
		 .when()
		      .post()
		 .then()
		      .statusCode(201)
		      .log().all();
	}

}
