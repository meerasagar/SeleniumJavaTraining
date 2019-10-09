package testngConepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityTest {
	

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
	
	@Test(priority=1,groups="link")
	public void checkLinkTest()
	{
		boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println(b);
	}
	@Test(priority=3,groups="logo")
	public void checkLogoTest()
	{
		boolean bimg = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(bimg);
	}
	@Test(priority=2,groups="search")
	public void seachDataTest()
	{
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("btnK")).click();
	}
	
	@Test(priority=4,groups="test")
	public void test1()
	{
		System.out.println("test1()");
	}
	
	@Test(priority=5,groups="test")
	public void test2()
	{
		System.out.println("test2()");
	}
	
	@Test(priority=6,groups="test")
	public void test3()
	{
		System.out.println("test3()");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
