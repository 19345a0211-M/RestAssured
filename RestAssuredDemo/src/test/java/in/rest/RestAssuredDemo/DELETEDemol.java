package in.rest.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DELETEDemol {
	@Test
	public void deleteResource() {
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users/687";
		
		RestAssured
		.when()
		    .delete()
		.then()
		    .statusCode(204);
	}

}
