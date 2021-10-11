package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objs.DashboardPage;
import objs.LoginPage;
import resurces.DashboardConstants;
import resurces.DriverConstants;
import resurces.LoginPageConstants;

public class TestDashboardPage {
	private static WebDriver driver;


	@BeforeClass // Driver loading and logging
	static	public void createDriverAndLogin() throws IOException {
		System.setProperty(DriverConstants.DRIVER_TILE,DriverConstants.DRIVER_LOCATION );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(LoginPageConstants.URL_LOGIN_PAGE);
		LoginPage.login(driver);
		}
	@Test // Here I test the buttons from the menu
	public void successfulMenuItems() {
		SoftAssert sa = new SoftAssert();
		
		DashboardPage.clickProfile(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_PROFILE);
		DashboardPage.clickTestCases(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_TEST_CASES);
		DashboardPage.clickPlayground(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_PLAYGROUND);
		DashboardPage.clickReports(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_REPORTS);
		DashboardPage.clickExam(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_EXAM);
		DashboardPage.clickIntroduction(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_INTRODUCTION);
		DashboardPage.clickDashboard(driver);
		sa.assertEquals(driver.getCurrentUrl(), DashboardConstants.URL_DASHBOARD);
		sa.assertAll();
	}
	
	@Test // Here I test the button located in the footer
	public void successfulTestingFooter() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		DashboardPage.clickFooterButton(driver);
		Set<String> winHandles = driver.getWindowHandles();
		Iterator<String> it = winHandles.iterator();
		
		String parentWindowId = it.next();
		
		String newWindowID = it.next(); //Here I will get windows id of newly opened tab
		driver.switchTo().window(newWindowID); //driver is switching to new tab
		wait.until(ExpectedConditions.urlToBe(DashboardConstants.URL_HTEC));
		String newUrl = driver.getCurrentUrl();
	
		Assert.assertEquals(newUrl, DashboardConstants.URL_HTEC);
	}

}
