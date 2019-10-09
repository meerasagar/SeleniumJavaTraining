package seleniumtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CRM {

	@Test
	public void dynamicXpath() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("meerasagar0812@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sagar@123");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		boolean contactname = driver.findElement(By.xpath("//td[text()='test1 test1']//parent::td//preceding-sibling::td/div")).isDisplayed();
		if(contactname=true)
		{
			System.out.println("Contact name displayed");
		}
		else
		{
			System.out.println("Contact name is not displayed");
			//driver.navigate().refresh();
		}
		
		driver.findElement(By.xpath("//td[text()='test1 test1']//parent::td//preceding-sibling::td/div")).click();
		//driver.findElement(By.xpath("//td[text()='test2 test2']//parent::td//preceding-sibling::td/div")).click();
		driver.findElement(By.xpath("//div[@class='ui basic button floating item dropdown']/i")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@role='listbox']/div/a[4]/i")).click();
		driver.findElement(By.cssSelector("div[role='listbox']>div:nth-of-type(1)+i+div>a:nth-child(4)")).click();
		
	}
}
