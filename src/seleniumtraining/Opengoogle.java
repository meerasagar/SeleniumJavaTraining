package seleniumtraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opengoogle {
	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Humera//Downloads//chromedriver_win32 (3)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		String url = driver.getCurrentUrl();
		System.out.println("URL of the page: " + url);
		String ActualTitle = driver.getTitle();
		System.out.println("Title of the page: "+ ActualTitle);
		String ExpectedTitle = "Google";
		if(ExpectedTitle.equals(ActualTitle))
		{
			System.out.println("Opened google successfully");
		}
		else{
			System.out.println("google not opened");
		}
		
		driver.close();
	}
	
		
		
	}


