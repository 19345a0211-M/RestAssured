package in.rest.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GET_Request {
	@Test
	public void getServerResponce() {
		RestAssured
		 .when()
		      .get("https://restcountries.com/v3.1/all")
		 .then()
		      .assertThat()
		      .statusCode(200)
		      .log().all();
		}

}
