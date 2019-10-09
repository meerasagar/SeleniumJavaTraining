package testngConepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderinTestNG1 {
	
	@Test(dataProvider="testDataProvider")
	public void dataProviderexample(String username, String password)
	{
		System.out.println(username);
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		
	}

	@DataProvider
	public Object[][] testDataProvider() throws IOException
	{
		
		Object[][] data = new Object[3][2];
		
		data[0][0] ="test1@gmail.com";
		data[0][1] = "Password1";

		data[1][0] ="test2@gmail.com";
		data[1][1] = "Password2";
	
		data[2][0] ="test3@gmail.com";
		data[2][1] = "Password3";
		
		
		
		return data;
		}
	
}
