package in.rest.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemoBarerToken {
	@Test
	public void createResource() {
		RestAssured
		 .given()
		      .contentType("application/json")
		      .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
		 .when()
		      .get("https://gorest.co.in/public/v2/users/4495049")
		 .then()
		      .statusCode(200)
		      .log().all();
	}

}
