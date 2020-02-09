package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By login = By.xpath("//button[contains(text(),'Log in')]");	

	
		public LandingPage(WebDriver driver) {
		//Constructor
			this.driver = driver;
		}


		public WebElement getLogin() {
			return driver.findElement(login);
		}
	
		
}
