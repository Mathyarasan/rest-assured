package rest_assured.concepts;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Basic_Meth_Prac {

	//@Test
	private void getMethod() {
		
		RestAssured.baseURI = "https://api.github.com";

		String bearerToken = "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";

		Response response = RestAssured.given()
				.headers("Authorization", "Bearer " + bearerToken)
				.when().get("/user/repos")
				.then().log().all().extract()
				.response();

		System.out.println(response.asString());

		System.out.println(response.getStatusCode());
	}
	
	
	
	
	//@Test
	private void postMethod() {
		RestAssured.baseURI = "https://api.github.com";

		String bearerToken = "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";

		Response response = RestAssured.given()
				.headers("Authorization", "Bearer " + bearerToken)
				.body("{\r\n" + "  \"name\": \"NEWREPO2\"\r\n" + "}")
				
				.when().post("/user/repos")
				
				.then().log().all().extract().response();

		System.out.println(response.asString());

		System.out.println(response.getStatusCode());
	
	
	}
	
	//@Test
		public static void putMethod() {

			RestAssured.baseURI = "https://api.github.com";

			String bearerToken = "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";

			Response response = RestAssured.given()
					.headers("Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept",
							ContentType.JSON)
					.body("{\r\n" + 
							"    \"names\": [\r\n" + 
							"        \"java\",\r\n" + 
							"        \"selenium\"\r\n" + 
							"    ]\r\n" + 
							"}").when().put("/repos/Mathyarasan/NEWREPO2").then().log().all()
					.extract().response();

			System.out.println(response.asString());

			System.out.println(response.getStatusCode());

		}

		@Test
		public static void deleteMethod() {

			RestAssured.baseURI = "https://api.github.com";

			String bearerToken = "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";

			Response response = RestAssured.given()
					.headers("Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept",
							ContentType.JSON)
					.when().delete("/repos/Mathyarasan/NEWREPO2").then().log().all()
					.extract().response();

			System.out.println(response.asString());

			System.out.println(response.getStatusCode());

		}
}
