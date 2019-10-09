package testngConepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGoogle {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void checkLinkTest()
	{
		boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println(b);
	}
	@Test
	public void checkLogoTest()
	{
		boolean bimg = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(bimg);
	}
	@Test
	public void seachDataTest()
	{
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
	}
	
	@Test
	public void getTitleTest()
	{
	String title = driver.getTitle();
	System.out.println("Title is: " + title);
	Assert.assertEquals(title, "Google");
	//Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
