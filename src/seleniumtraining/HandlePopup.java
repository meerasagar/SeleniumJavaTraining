package seleniumtraining;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlePopup {
	
	@Test
	public void handleWindowPopup()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://popuptest.com/goodpopups.html");
	    driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();
		
		Set<String> handler =driver.getWindowHandles();
		Iterator<String> itr = handler.iterator();
		String parentwindow = itr.next();
		System.out.println("parentwindow ID: "+parentwindow);
		
		driver.switchTo().window(parentwindow);
		//String parentwindowtitle = driver.switchTo().window(parentwindow).getTitle();
		String parentwindowtitle = driver.switchTo().window(parentwindow).getCurrentUrl();
		System.out.println("Title of parent window: "+parentwindowtitle);
		
		String childwindow = itr.next();
		System.out.println("childwindow ID: "+childwindow);
		driver.switchTo().window(childwindow);
		//String childwindowtitle = driver.switchTo().window(childwindow).getTitle();
		String childwindowtitle = driver.switchTo().window(childwindow).getCurrentUrl();
		System.out.println("Title of child window: "+childwindowtitle);
		
		
		
		
		
	}

}
