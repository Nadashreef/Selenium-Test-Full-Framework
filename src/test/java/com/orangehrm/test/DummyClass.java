package com.orangehrm.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.utilities.ExtentManager;

@Test
public class DummyClass extends BaseClass {
	public void dummyTest(){
		//ExtentManager.startTest("Dummy1 Test"); --This has been implemented in TestListener
		String title = getDriver().getTitle();
		ExtentManager.logStep("Verifying the title");
		assert title.equals("OrangeHRM") : "Test Failed - Title is Not Matching";
		
		System.out.println("Test Passed - Title is Matching");
		//ExtentManager.logSkip("This case is skipped");
		//throw new SkipException("Skipping the test as part of Testing");
	}

}
