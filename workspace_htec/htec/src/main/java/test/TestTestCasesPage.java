package test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import objs.LoginPage;
import objs.TestCasesPage;
import resurces.TestCasesConstants;
import resurces.DriverConstants;
import resurces.LoginPageConstants;

public class TestTestCasesPage {
	private static WebDriver driver;


	@BeforeClass//It connects the driver and logs on to the site
	static	public void createDriverAndLogin() throws IOException {
		System.setProperty(DriverConstants.DRIVER_TILE,DriverConstants.DRIVER_LOCATION );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(LoginPageConstants.URL_LOGIN_PAGE);
		LoginPage.login(driver);
		}
	
	
	//@Test(priority = 1)// Checks if 5 test cases have been successfully added
	public void successfulAddTestCases() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		TestCasesPage.clickTestCases(driver);
		Assert.assertEquals(driver.getCurrentUrl(), TestCasesConstants.URL_TEST_CASES);
		TestCasesPage.makeNewTestCases(driver);
		wait.until(ExpectedConditions.elementToBeClickable((By.partialLinkText(TestCasesConstants.TEST_CASE_TITLE))));
		int number = TestCasesPage.numberOfTestCases(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(number, 5);
	}
	
	//@Test (priority = 2)// Checks whether test cases have been successfully edited
	public void successfulEditTitles() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		//DashboardPage.clickTestCases(driver);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(TestCasesConstants.BTN_NEW_TEST_CASE))));
		TestCasesPage.editTitlesTestCase(driver);
		Assert.assertEquals(TestCasesPage.numberOfEditedTestCases(driver), 5);	
	}
	
	@Test (priority = 3)// Checks whether test cases have been successfully deleted with a specific title
	public void successfulDeleteAllCases() {
		//DashboardPage.clickTestCases(driver);
		TestCasesPage.deleteAllCases(driver);
		Assert.assertTrue(TestCasesPage.checkTestCases(driver));
	}
}
