package com.fafiner.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency1 {
	
	@Test 
	public void createUser()
	{
		System.out.println("User is Created");
		Assert.assertEquals(true, false);
	}
	
	@Test(dependsOnMethods="createUser")
	public void deleteUser()
	{
		System.out.println("User is deleted");
	}

}
