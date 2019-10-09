package seleniumtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseConcept {
	@Test
	public void mouseExample() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//div[@id='smoothmenu1']/ul/li[6]/a"));
		
		action.moveToElement(element).build().perform();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Hot Meals ']")).click();
		
		
		
	}

}
