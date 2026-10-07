package com.orangehrm.test;

import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.utilities.ExtentManager;

@Test
public class DummyClass2 extends BaseClass {
	public void dummyTest2(){
		//ExtentManager.startTest("Dummy1 Test"); --This has been implemented in TestListener.
		String title = getDriver().getTitle();
		ExtentManager.logStep("Verifying the title");
		assert title.equals("OrangeHRM") : "Test Failed - Title is Not Matching";
		
		System.out.println("Test Passed - Title is Matching");
		ExtentManager.logStep("Validation Successful!");
	}

}
