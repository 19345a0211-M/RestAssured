package in.rest.RestAssuredDemo;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUTDemoBarerToken {
HashMap<String, String> map = new HashMap<>();
	
	@BeforeMethod
	public void createPayLoad() {
		map.put("name", "Allu Arjun");
		map.put("email", "alluarjun@example");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/4495049";
	}
	
	@Test
	public void updateResource() {
		Response  response = RestAssured
		 .given()
		      .contentType("application/json")
		      .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
		      .body(map)
		 .when()
		      .put()
		 .then()
		      .extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		Assert.assertTrue(jsonPath.get("name").toString().equals("Allu Arjun"));
	}

}
