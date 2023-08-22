package in.rest.RestAssuredDemo;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BarerTokenDemo {
	HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	
	@BeforeMethod
	public void createPayLoad() {
		map.put("name", "Allu Arjun");
		map.put("email", "uuid@example");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
	}
	
	@Test
	public void createResource() {
		RestAssured
		 .given()
		      .contentType("application/json")
		      .body(map)
		      .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
		 .when()
		      .post()
		 .then()
		      .statusCode(201)
		      .log().all();
	}

}
