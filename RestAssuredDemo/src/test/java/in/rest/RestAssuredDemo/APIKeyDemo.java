package in.rest.RestAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIKeyDemo {
	@Test
	public void getWeatherInfo() {
	RestAssured

	  .given()
	     .param("q", "visakhapatnam") 
	     .param("appid", "b44327eb4988899be29e23a026b4b3e0")

	  .when()
	     .get("https://api.openweathermap.org/data/2.5/weather")

	  .then()   
	     .statusCode (200)
	     .log().all();
	}

}
