package testng;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class LabNew {

	@Description("TC#1 -> GET request 1")
	@Test
	public void test1(){

		RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/ping")
				.when().get().then().statusCode(201);
	}

	@Description("TC#2 -> GET request 2")
	@Test
	public void test2(){

		RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/ping")
				.when().get().then().statusCode(201);
	}
}
