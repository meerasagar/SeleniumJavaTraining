package testngConepts;

import org.testng.annotations.Test;

public class GroupsInTestNG {
	
	@Test(groups={"sanity"})
	public void test1()
	{
		System.out.println("sanity");
		
	}
	
	@Test(groups={"regression","sanity"})
	public void test2()
	{
		System.out.println("regression,sanity");
	}
	
	@Test(groups={"regression"})
	public void test3()
	{
		
		System.out.println("regression");
	}

}
