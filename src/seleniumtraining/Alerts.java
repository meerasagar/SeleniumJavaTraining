package seleniumtraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {

	WebDriver driver;
@Test
public void alertPopupHandle()
{

	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	//driver.findElement(By.id("login1")).sendKeys("meerasagar0812");
	//driver.findElement(By.name("passwd")).sendKeys("test");
	driver.findElement(By.xpath("//input[@name='proceed' and @type='submit']")).click();
	
	String Expectedtext="Please enter a valid user name";
	
	String Actualtext = driver.switchTo().alert().getText();
	
	System.out.println("Alert Text:" + Actualtext);
	
	if(Actualtext.equals(Expectedtext))
	{
		System.out.println("Correct alert message displayed");
	}
	else
	{
		System.out.println("Invalid alert message");
	}
	
	driver.switchTo().alert().accept();
	
	
	//driver.close();
	
}



}
