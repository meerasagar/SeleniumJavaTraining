package seleniumtraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsInSelenium {

	@Test
	public void workWithLocators()
	{
		//System.out.println("My user directory: "+System.getProperty("user.dir"));
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Humera/workspace/SeleniumJavaTraining/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// Enter username
		js.executeScript("document.getElementById('email').value='meerasagar0812@gmail.com';");
		// Enter password
		js.executeScript("document.getElementById('pass').value='Sagar@123';");
		
		
		
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("meerasagar0812@gmail.com");
		//driver.findElement(By.name("email")).sendKeys("meerasagar0812@gmail.com");
		
		//driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("xyz");
		//driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("abc");
		//driver.findElement(By.id("pass")).sendKeys("xyz");
		
		//driver.findElement(By.linkText("Forgotten account?")).click();
		
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		/*driver.findElement(By.partialLinkText("Forgotten")).click();
		
		*/
		//driver.findElement(By.xpath("//input[@value='Log In']")).click();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		
		//int linkscount = links.size();
		System.out.println("Total number of links on facebook page: "+links.size());
		for(int i=0; i<links.size(); i++)
		{
			String linkstext = links.get(i).getText();
			System.out.println(linkstext);
		}
		
	}
}
