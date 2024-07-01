package ex30062024_CRUD_UsingBDD;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab001GET {

	//Given()
	//BaseUri -> https://api.zippopotam.us/
	//BasePath -> in/700060

	//When()
	//I make a GET request

	//Then()
	//I will be getting -> response, status code, header, cookies

	@Test
	public void getRequest(){

		RestAssured.given()
				.baseUri("https://api.zippopotam.us/")
				.basePath("in/700060")
				.when().log().all().get()
				.then().log().all().statusCode(200);


	}
}
