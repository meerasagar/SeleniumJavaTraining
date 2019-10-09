package testngConepts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderInTestNG {
	
	@DataProvider
	public Object[][] testData()
	{
		Object[][] data = new Object[3][2];
		
		// 1st row
		data[0][0] ="User1";
		data[0][1] = "Password1";

		// 2nd row
		data[1][0] ="User2";
		data[1][1] = "Password2";
		
		// 3rd row
		data[2][0] ="User3";
		data[2][1] = "Password3";
		
		return data;
		
	}
	
	@Test(dataProvider="testData")
	public void test(String UserName, String Password)
	{
		System.out.println("UserName: "+" "+UserName +" "+"Password: "+" "+ Password);
	}

}
