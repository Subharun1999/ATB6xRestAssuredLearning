package ex30062024_CRUD_NonBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab004POST {

	RequestSpecification rs = RestAssured.given();
	Response response;
	ValidatableResponse vr;
	String BASE_URL = "https://restful-booker.herokuapp.com";
	String BASE_PATH = "/booking";
	String payload = "{\n" +
			"    \"firstname\" : \"Hitman\",\n" +
			"    \"lastname\" : \"Jones\",\n" +
			"    \"totalprice\" : 111,\n" +
			"    \"depositpaid\" : true,\n" +
			"    \"bookingdates\" : {\n" +
			"        \"checkin\" : \"2024-06-10\",\n" +
			"        \"checkout\" : \"2024-06-12\"\n" +
			"    },\n" +
			"    \"additionalneeds\" : \"Breakfast\"\n" +
			"}";

	@Test
	public void getRequestNonBDDPOST(){

		//Request Specification
		rs.baseUri(BASE_URL);
		rs.basePath(BASE_PATH);
		rs.contentType(ContentType.JSON).log().all();
		rs.body(payload);

		//Response
		response = rs.when().log().all().post();
		String responseString = response.asString();
		System.out.println(responseString);

		//Validatable Response
		vr = response.then();
		vr.statusCode(200);

	}
}
