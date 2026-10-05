package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.DataProviders;
import com.orangehrm.utilities.ExtentManager;

public class LoginPageTest extends BaseClass {
	
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setupPages() {
		loginPage = new LoginPage(getDriver());
		homePage = new HomePage(getDriver());
	}
	
	@Test(dataProvider="validLoginData", dataProviderClass = DataProviders.class)
	public void verifyValidLoginTest(String username, String password) {
		
		//ExtentManager.startTest("Valid login Test"); --This has been implemented in TestListener
		System.out.println("Running restMethod1 on thread:"+ Thread.currentThread().getId());
		ExtentManager.logStep("Navigating to Login page entering username and password");
		loginPage.login(username, password);
		ExtentManager.logStep("Verifying admin tab is visible or not");
		Assert.assertTrue(homePage.isAdminTabVisible(), "Admin tab should be visible after successful login");
		ExtentManager.logStep("Validation Successful!");
		homePage.logout();
		ExtentManager.logStep("Logged Out Successfully!");
		staticwait(2);
	}
	
	@Test(dataProvider="inValidLoginData", dataProviderClass = DataProviders.class)
	public void invalidLoginTest(String username, String password) {
		//ExtentManager.startTest("Invalid login Test"); --This has been implemented in TestListener
		System.out.println("Running restMethod2 on thread:"+ Thread.currentThread().getId());
		ExtentManager.logStep("Navigating to Login page entering username and password");
		loginPage.login(username,password);
		String expectedErrorMessage = "Invalid credentials";
		Assert.assertTrue(loginPage.verifyErrorMessage(expectedErrorMessage), "Test failed: Invalid error message");
		ExtentManager.logStep("Validation Successful!");
		ExtentManager.logStep("Logged Out Successfully!");
	
	}

	

}
