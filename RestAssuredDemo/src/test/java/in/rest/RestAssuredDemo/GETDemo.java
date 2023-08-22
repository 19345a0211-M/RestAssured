package in.rest.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemo {
	@Test
	public void getServerResponce() {
		RestAssured
		 .when()
		      .get("https://gorest.co.in/public/v2/users")
		 .then()
		      .assertThat()
		      .statusCode(200)
		      .log().all();
		}
}
