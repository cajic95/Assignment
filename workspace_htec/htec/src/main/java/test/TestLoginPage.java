package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objs.LoginPage;
import resurces.TestCasesConstants;
import resurces.DriverConstants;
import resurces.LoginPageConstants;

public class TestLoginPage {
	private static WebDriver driver;

	@BeforeClass
	static public void createDriver() {
		System.setProperty(DriverConstants.DRIVER_TILE, DriverConstants.DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 1)// Checks if we are on the login page
	public void successfulGoToLoginPage() {
		driver.get(LoginPageConstants.URL_LOGIN_PAGE);
		Assert.assertEquals(driver.getCurrentUrl(), LoginPageConstants.URL_LOGIN_PAGE);
	}

	@Test(priority = 2)// Checks if the login was successful
	public void successfulLogin() throws IOException {
		LoginPage.login(driver);
		Assert.assertEquals(driver.getCurrentUrl(), TestCasesConstants.URL_DASHBOARD);
	}

}
