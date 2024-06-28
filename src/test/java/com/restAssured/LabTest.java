package com.restAssured;

import io.restassured.RestAssured;

public class LabTest {

	public static void main(String[] args) {

		RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("/ping")
				.when().get().then().statusCode(201);
	}
}
