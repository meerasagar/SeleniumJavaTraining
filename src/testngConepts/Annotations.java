package testngConepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	//Preconditions
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("beforeTest()");
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuite()");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("beforeClass()");
	}
	
	
	//Testcase
	@Test
	public void test1()
	{
		System.out.println("test1()");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test2()");
	}
	
	@Test
	public void test3()
	{
		System.out.println("test3()");
	}
	//Post Condition
	@AfterMethod()
	public void afterMethod()
	{
		System.out.println("afterMethod()");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("afterClass()");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("afterTest()");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite()");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("beforeMethod()");
	}
	/*beforeSuite()
	beforeTest()
	beforeClass()
	beforeMethod()
	test1()
	afterMethod()
	beforeMethod()
	test2()
	afterMethod()
	beforeMethod()
	test3()
	afterMethod()
	afterClass()
	afterTest()*/
}
