package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.id("login-username");
	By password = By.id("login-password");
	By loginButton = By.id("login-button");
	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
	}


		public WebElement getEmail() {
			return driver.findElement(email);
		}
	
	
		public WebElement getPassword() {
			return driver.findElement(password);
		}
		
		public WebElement getLoginButton() {
			return driver.findElement(loginButton);
		}
}
