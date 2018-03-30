package com.fafiner.test.smoke;

import org.testng.annotations.Test;

public class Dependency {
	
	@Test 
	public void createUser()
	{
		System.out.println("User is Created");
	}
	
	@Test(dependsOnMethods="createUser")
	public void deleteUser()
	{
		System.out.println("User is deleted");
	}

}
