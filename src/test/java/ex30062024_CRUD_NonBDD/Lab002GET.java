package ex30062024_CRUD_NonBDD;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab002GET {

	@Test
	public void getReqNonBDDCase1(){

		RequestSpecification rs = RestAssured.given();
		rs.baseUri("https://restful-booker.herokuapp.com");
		rs.basePath("/booking/2747");
		rs.when().log().all().get();
		rs.then().log().all().statusCode(200);
	}

	@Test
	public void getReqNonBDDNegativeTC() {

		RequestSpecification rs = RestAssured.given();
		rs.baseUri("https://restful-booker.herokuapp.com");
		rs.basePath("/booking/-1");
		rs.when().log().all().get();
		rs.then().log().all().statusCode(404);
	}
}
