package octaveGroup;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.*;

public class HomePage extends Base{
	
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		Log.info("Driver is Initialize");
		driver.get(prop.getProperty("url"));
		Log.info("navigated to Homepage");
		// log info
		// log error
		// log warning
		// log debug
	}
	
	@Test(dataProvider = "getData")
	public void landingPage(String username, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		//one is inheritence method exteds keyword
		//second is creating a obj to that class(landinig page class) & invoke method of it
		
		LandingPage lapage = new LandingPage(driver);
		lapage.getLogin().click();
		Log.info("login button clicked from HomePage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getEmail().sendKeys(username);
		Log.info("entered username");
		loginpage.getPassword().sendKeys(password);
		Log.info("entered password");
		System.out.println(text);
		
		loginpage.getLoginButton().click();
		Log.info("click on LOGIN");
	}

	@DataProvider
	public Object[][] getData() {
		
		//ROW: how many diff data types test should run
		//COLUMN: how many values per each test
		Object[][] data = new Object[2][3];
		
		// 0th row--> that is 1st conceptually
		data[0][0] = "testdata12@gmail.com";
		data[0][1] = "Testdata@9090";
		data[0][2] = "login Succesfully";
		
		//1st row -->that is 2nd
		data[1][0] = "imNotRegisteredUser@gmail.com";
		data[1][1] = "677899";
		data[1][2] = "login failed";
		
		return data;
		
		
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
		driver = null;
		
	}
	
	
}
