package com.orangehrm.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtility {
	
	//Method to send the GET Request
	public static Response senGetRequest(String endPoint) {
		return RestAssured.get(endPoint);
	}
	
	//Method to send the POST Request
	public static void sendPostRequest(String endPoint, String payLoad) {
		RestAssured.given().header("Content-Type","application/json")
				.body(payLoad)
				.post();
		
	}
	
	//Method to validate the response status
	public static boolean validateStatusCode(Response response, int statusCode) {
		return response.getStatusCode() == statusCode;
	}
	
	//Method to extract value from Json response
	public static String getJsonValue(Response response, String value) {
		return response.jsonPath().getString(value);
	}
	
	
	
	

}
