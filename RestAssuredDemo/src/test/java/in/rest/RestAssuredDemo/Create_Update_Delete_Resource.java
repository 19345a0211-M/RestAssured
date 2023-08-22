package in.rest.RestAssuredDemo;

import java.util.HashMap;
import java.util.UUID;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;
public class Create_Update_Delete_Resource extends TestBase{
	HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	int id;
	Response response;
	JsonPath jsonPath;
	
	@Test(priority=0)
	public void createPayload() {
		map.put("name", "Ben Tennison");
		map.put("email", uuid + "@example");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
		logger.info("Payload created");
	}
	
	@Test(priority=1)
	public void createResource() {
		response = RestAssured
		.given()
	      .contentType("application/json")
	      .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
	      .body(map)
	 .when()
	      .post()
	 .then()
	      .extract().response();
		
		logger.info("Resource Created Successfully");
		jsonPath = response.jsonPath();
		id = jsonPath.get("id");
		System.out.println(id);
	}
	
	@Test(priority=2)
	public void updateResource() {
		map.put("name", "Ben Tenison");
		map.put("email", uuid + "@example");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users/"+id;
		
		RestAssured
		.given()
	      .contentType("application/json")
	      .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
	      .body(map)
	    .when()
          .put()
	    .then()
	      .statusCode(200)
	      .log().all()
		  .assertThat()
		  .body("name", is("Ben Tenison"));
		
	}
	
	@Test(priority=3)
	public void deleteResource() {
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users/"+id;
		
		RestAssured
		.given()
	       .contentType("application/json")
	       .body(map)
	       .header("Authorization", "Bearer c41af9ca4c93399837273cc580e7f1280478ef79f2298f4efc5a539739a0f311")
	    .when()
           .delete()
	    .then()
	       .statusCode(204);
		
	}

}
