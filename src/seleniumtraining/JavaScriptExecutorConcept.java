package seleniumtraining;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JavaScriptExecutorConcept {
	@Test
	public void javaScriptExecutorExamples() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("meerasagar0812@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sagar@123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//div[text()='Login']")); //login button
		
		
		flash(loginBtn, driver); //highlight the element
		
		drawBorder(loginBtn, driver); //draw a border
		//take screenshot:
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("E:/Capturescreenshot/CRM.png"));
		
		//generate Alert
		//generateAlert(driver, "There is an issue with Login button on Login Page");
		Thread.sleep(5000);
		
		clickOn(driver,driver.findElement(By.xpath("//div[text()='Login']")), 30);
		
		//click on any element by using JS executor-+
		clickElementByJS(loginBtn, driver);
		
		//refresh the page:
		//by using selenium:
		//driver.navigate().refresh(); 
		
		//by using JS executor:
		//refreshBrowserByJS(driver);
		
		//get the tile of the page by JS:
		System.out.println("Finding title of the page using JS: " + getTitleByJS(driver));
		
		//get the page text:
		System.out.println("Finding inner text of the page using JS: " + getPageInnerText(driver));
		
		//scroll page down:
		//scrollPageDown(driver);
		
		//WebElement forgotPwdLink = driver.findElement(By.xpath("//a[text()='Forgot your password?']"));
		//scrollIntoView(forgotPwdLink, driver);
		
		WebElement twitter = driver.findElement(By.xpath("//div[text()='Twitter']"));
		scrollIntoView(twitter, driver);
		
	}
	
	
	public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
	
	
    public static void drawBorder(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    public static void generateAlert(WebDriver driver, String message){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("alert('"+message+"')");

    }
    
    public static void clickElementByJS(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].click();", element);
    	
    }
	
    public static void refreshBrowserByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
    
    public static String getTitleByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
    
    public static String getPageInnerText(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    }
    
    public static void scrollPageDown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
    
	}
	


