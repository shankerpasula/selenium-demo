package com.fafiner.test.smoke;

import org.testng.annotations.Test;


public class TestGroup {
	
	@Test(groups= {"web","ios"})
	public void test1()
	{
		System.out.println("Running Test 1");
	}
	
	@Test(groups= {"web","aos","ios"})
	public void test2()
	{
		System.out.println("Running Test 2");
	}
	
	@Test(groups= {"web","aos"})
	public void test3()
	{
		System.out.println("Running Test 3");
	}

}
