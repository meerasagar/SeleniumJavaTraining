package seleniumtraining;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handlepopup1 {

	
	@Test
	public void handleWindowPopup1()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[text()='Good PopUp #3']")).click();
		driver.findElement(By.xpath("//a[text()='Good PopUp #4']")).click();
		
		String parentwindow = driver.getWindowHandle();
		
		
		Set<String> handler =driver.getWindowHandles();
		Iterator<String> itr = handler.iterator();
		
		while(itr.hasNext())
		{
			String childwindow = itr.next();
			//System.out.println("childwindowid: " + childwindow);
			if(!childwindow.equals(parentwindow))
			{
			driver.switchTo().window(childwindow);
			//String childwindowtitle = driver.switchTo().window(childwindow).getTitle();
			//System.out.println("childwindowtitle:" + childwindowtitle);
			String childwindowURL = driver.switchTo().window(childwindow).getCurrentUrl();
			System.out.println("childwindowURL:" + childwindowURL);
			//driver.close();
			}
		}
		System.out.println(itr.next());
		driver.switchTo().window(parentwindow);
		String parentwindowtitle = driver.switchTo().window(parentwindow).getTitle();
		System.out.println("parentwindowtitle:" + parentwindowtitle);
		//driver.close();
	
		
		
		
		
		
		
	}
}
