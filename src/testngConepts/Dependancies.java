package testngConepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependancies {
	@Test
	public void LoginTest()
	{
		System.out.println("Login successful");
		Assert.assertTrue(false);
		
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void HomepageTest()
	{
		System.out.println("Home displayed");
	}

}
