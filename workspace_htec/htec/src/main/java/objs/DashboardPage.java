package objs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resurces.DashboardConstants;
import resurces.TestCasesConstants;

public class DashboardPage {
	
	public static void clickProfile(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(DashboardConstants.BTN_PROFILE))));
		driver.findElement(By.xpath(DashboardConstants.BTN_PROFILE)).click();
	}
	public static void clickTestCases(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_TEST_CASES)).click();
	}
	public static void clickPlayground(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_PLAYGRAUND)).click();
	}
	public static void clickReports(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_REPORTS)).click();
	}
	public static void clickExam(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_EXAM)).click();
	}
	public static void clickIntroduction(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_INTRODUCTION)).click();
	}
	public static void clickDashboard(WebDriver driver) {
		driver.findElement(By.xpath(DashboardConstants.BTN_DASHBOARD)).click();
	}

	public static void clickFooterButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(DashboardConstants.BTN_FOOTER))));
		driver.findElement(By.xpath(DashboardConstants.BTN_FOOTER)).click();
		
	}
}
