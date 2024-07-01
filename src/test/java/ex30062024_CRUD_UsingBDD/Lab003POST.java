package ex30062024_CRUD_UsingBDD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab003POST {

	@Test
	public void POSTReq(){

		String BASE_URI = "https://restful-booker.herokuapp.com";
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

		RestAssured.given().baseUri(BASE_URI).basePath(BASE_PATH)
				.contentType(ContentType.JSON).body(payload).log().all()
				.when().post().then().log().all().statusCode(200);
	}
}
