package objs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resurces.TestCasesConstants;

public class TestCasesPage {

	public static void clickTestCases(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath(TestCasesConstants.BTN_TEST_CASE)).click();
		wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath(TestCasesConstants.BTN_NEW_TEST_CASE))));
		
	}
// The method creates 5 test cases and enters certain values ​​into the fields
	public static void makeNewTestCases(WebDriver driver) {

		for (int i = 1; i < 6; i++) {
			driver.findElement(By.xpath(TestCasesConstants.BTN_NEW_TEST_CASE)).click();
			driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE))
					.sendKeys(TestCasesConstants.TEST_CASE_TITLE + i);
			driver.findElement(By.xpath(TestCasesConstants.INPUT_DESCRIPTION))
					.sendKeys(TestCasesConstants.TEST_CASE_DESCRIPTION);
			driver.findElement(By.xpath(TestCasesConstants.INPUT_EXPECTED_RESULT))
					.sendKeys(TestCasesConstants.TEST_CASE_EXPECTED_RESULT);
			driver.findElement(By.xpath(TestCasesConstants.INPUT_TEST_STEPS))
					.sendKeys(TestCasesConstants.TEST_CASE_TEST_STEP);
			driver.findElement(By.xpath(TestCasesConstants.BTN_SUBMIT_NEW_TEST_CASE)).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	}
	// The method returns a number of test cases that contain a specific title
	public static int numberOfTestCases(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.partialLinkText(TestCasesConstants.TEST_CASE_TITLE));
		return list.size();

	}
// The method finds test cases and changes their title and description
	public static void editTitlesTestCase(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (int i = 1; i < 6; i++) {
			{
				WebElement cases = driver.findElement(By.partialLinkText(TestCasesConstants.TEST_CASE_TITLE + i));
				wait.until(ExpectedConditions.elementToBeClickable(cases));
				cases.click();
				String url = driver.getCurrentUrl().substring(44);
				int id = Integer.parseInt(url);
				//I have a problem with the internet so this was a winning combination in this situation
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				wait.until(
						ExpectedConditions.visibilityOf(driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE))));
// Checking if the id od test cases is even or odd
				if (id % 2 == 0) {
					driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE)).clear();
					driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE))
							.sendKeys("The id (" + id + ") of this use case is even");
					driver.findElement(By.xpath(TestCasesConstants.INPUT_EDIT_DESCRIPTION)).clear();
					driver.findElement(By.xpath(TestCasesConstants.INPUT_EDIT_DESCRIPTION))
							.sendKeys("This description belongs to id (" + id + ") which is even");
					driver.findElement(By.xpath(TestCasesConstants.BTN_SUBMIT)).click();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				} else {

					driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE)).clear();
					driver.findElement(By.xpath(TestCasesConstants.INPUT_TITLE))
							.sendKeys("The id (" + id + ") of this use case is odd");
					driver.findElement(By.xpath(TestCasesConstants.INPUT_EDIT_DESCRIPTION)).clear();
					driver.findElement(By.xpath(TestCasesConstants.INPUT_EDIT_DESCRIPTION))
							.sendKeys("This description belongs to id (" + id + ") which is odd");
					wait.until(ExpectedConditions
							.visibilityOf(driver.findElement(By.xpath(TestCasesConstants.BTN_SUBMIT))));
					driver.findElement(By.xpath(TestCasesConstants.BTN_SUBMIT)).click();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				}
			}
		}
		List<WebElement> list = driver.findElements(By.partialLinkText("of this use case is"));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
// Returns the number of edited test cases
	public static int numberOfEditedTestCases(WebDriver driver) {
		List<WebElement> list = driver.findElements(By.partialLinkText("of this use case is"));
		return list.size();
	}
	// Deletes all test cases with a specific title
	public static void deleteAllCases(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(TestCasesConstants.BTN_NEW_TEST_CASE))));
		List<WebElement> list = driver.findElements(By.partialLinkText("of this use case is"));
		for(int i = 0; i < list.size(); i++) {
			driver.findElement(By.partialLinkText("of this use case is")).click();
			driver.findElement(By.xpath(TestCasesConstants.DELETE_CASES)).click();
			driver.findElement(By.xpath(TestCasesConstants.DELETE_CASES_CONFIRM)).click();
			wait.until(ExpectedConditions.urlToBe("https://qa-sandbox.ni.htec.rs/testcases"));

		}
	}
	// Checks if there are test cases with a specific title
	public static boolean checkTestCases(WebDriver driver) {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.partialLinkText("of this use case is"));
		return list.isEmpty();
	}
	
}
