package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.orangehrm.utilities.RetryAnalyzer;
import com.orangehrm.utilities.ApiUtility;
import com.orangehrm.utilities.ExtentManager;

import io.restassured.response.Response;

public class ApiTest {
	
	@Test
	public void verifyGetUserAPI() {
		
		SoftAssert softAssert = new SoftAssert();
		
		//Step1: Define API Endpoint
			String endPoint = "https://jsonplaceholder.typicode.com/users/1";
			ExtentManager.logStep("API Endpoint: "+ endPoint);
			
		//Step2 : Send GET Request
			ExtentManager.logStep("Sending GET Request to the API");
			Response response = ApiUtility.senGetRequest(endPoint);
			
		//Step 3: Validate status code
			ExtentManager.logStep("Validating API Response status code");
			boolean isStatusCodeValid = ApiUtility.validateStatusCode(response, 200);
			
			softAssert.assertTrue(isStatusCodeValid,"Status code is not as Expected");
			
			if(isStatusCodeValid) {
				ExtentManager.logStepValidationForAPI("Status Code Validation Passed!");
				
			}
			else {
				ExtentManager.logFailureAPI("Status Code Validation Failed!");
			}
			
			//Step 4 : Validate username
			ExtentManager.logStep("Validating response body for username");
			String username = ApiUtility.getJsonValue(response, "username");
			boolean isUserNameValid = "Bret".equals(username);
			softAssert.assertTrue(isUserNameValid,"Username is not valid");
			if(isUserNameValid) {
				ExtentManager.logStepValidationForAPI("Username validation passed!");
			}
			else {
				ExtentManager.logFailureAPI("Username Validation Failed!");
			}
			
			//Step 5 : Validate email
			ExtentManager.logStep("Validating response body for username");
			String userEmail = ApiUtility.getJsonValue(response, "username");
			boolean isEmailValid = "Bret".equals(userEmail);
			softAssert.assertTrue(isEmailValid,"Username is not valid");
			if(isEmailValid) {
				ExtentManager.logStepValidationForAPI("Email validation passed!");
			}
			else {
				ExtentManager.logFailureAPI("Email Validation Failed!");
			}
			softAssert.assertAll();
			}
	}
	
	


