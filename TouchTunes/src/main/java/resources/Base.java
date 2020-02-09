package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {

		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/jasanihardik/TouchTunes/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		
		if(browserName.equals("Chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "/Users/jasanihardik/Desktop/⁩new/chromedriver");
			//System.setProperty("Webdriver.chrome.driver", "/Users/jasanihardik/TouchTunes/chromedriver");
			//driver = new ChromeDriver();
			
			System.setProperty("webdriver.chrome.driver", "/Users/jasanihardik/eclipse-workspace-selenium/SeleniumProject/chromedriver");
			driver = new ChromeDriver();
			
		}
		else if (browserName.equals("fireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/jasanihardik/eclipse-workspace-selenium/SeleniumProject/geckodriver");
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equals("safari")) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	/*
	public void getScreenshot(String result) throws IOException
	
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}
	*/
}
