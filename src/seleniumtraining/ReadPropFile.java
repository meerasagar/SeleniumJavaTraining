package seleniumtraining;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadPropFile {

	
	public static WebDriver driver;
	
	@Test
	public static void readPropertiesFileExample() throws IOException {

		Properties prop = new Properties();

		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/seleniumtraining/config.properties");
		//System.out.println(System.getProperty("user.dir"));
		prop.load(ip);

		System.out.println(prop.getProperty("name"));

		System.out.println(prop.getProperty("age"));

		String url = prop.getProperty("URL");

		System.out.println(url);

		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if(browserName.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));
		
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastName"));

		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city"));
		

	}

}
