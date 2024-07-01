package ex30062024_CRUD_NonBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab005PUT {

	RequestSpecification rs = RestAssured.given();
	Response response;
	ValidatableResponse vr;

	String token = "e9b3bcf7e7a4410";
	String booking_id = "2572";
	String BASE_URL = "https://restful-booker.herokuapp.com";
	String BASE_PATH = "/booking";

	@Test
	public void getRequestNonBDDPUT(){

		String BASE_PATH_UPDATED = BASE_PATH+"/"+booking_id;

		String payload = "{\n" +
				"    \"firstname\" : \"Indiana\",\n" +
				"    \"lastname\" : \"Brown\",\n" +
				"    \"totalprice\" : 11100,\n" +
				"    \"depositpaid\" : true,\n" +
				"    \"bookingdates\" : {\n" +
				"        \"checkin\" : \"2024-06-12\",\n" +
				"        \"checkout\" : \"2024-06-15\"\n" +
				"    },\n" +
				"    \"additionalneeds\" : \"Breakfast, lunch, dinner\"\n" +
				"}";

		rs.baseUri(BASE_URL);
		rs.basePath(BASE_PATH_UPDATED);
		rs.contentType(ContentType.JSON);
		rs.cookie("token",token);
		rs.body(payload).log().all();

		response = rs.when().log().all().put();

		vr = response.then().log().all();
		vr.statusCode(200);

	}
}
