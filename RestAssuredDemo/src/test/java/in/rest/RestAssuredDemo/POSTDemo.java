package in.rest.RestAssuredDemo;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class POSTDemo {
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPayLoad() {
		map.put("name","YS Jagan");
		map.put("job","chief minister of AP");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void createResource() {
		RestAssured
		 .given()
		      .contentType("application/json")
		      .body(map)
		 .when()
		      .post()
		 .then()
		      .statusCode(201)
		      .log().all();
	}

}
