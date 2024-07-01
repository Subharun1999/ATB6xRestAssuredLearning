package ex30062024_CRUD_NonBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab006PATCH {

	RequestSpecification rs = RestAssured.given();
	Response response;
	ValidatableResponse vr;

	String token = "26340c6c641728d";
	String booking_id = "4473";
	String BASE_URL = "https://restful-booker.herokuapp.com";
	String BASE_PATH = "/booking";

	@Test
	public void patchRequestNonBDDPATCH(){

		String BASE_PATH_UPDATED = BASE_PATH+"/"+booking_id;

		String payload = "{\n" +
				"    \"firstname\" : \"James\",\n" +
				"    \"lastname\" : \"Brown\"\n" +
				"}";

		rs.baseUri(BASE_URL);
		rs.basePath(BASE_PATH_UPDATED);
		rs.contentType(ContentType.JSON);
		rs.cookie("token", token);
		rs.body(payload).log().all();

		response = rs.when().log().all().patch();

		vr = response.then().log().all();
		vr.statusCode(200);

	}
}
