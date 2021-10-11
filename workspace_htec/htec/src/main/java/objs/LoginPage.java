package objs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resurces.TestCasesConstants;
import resurces.LoginPageConstants;
// Takes an email address from an Excel file and enters it in the email field
public class LoginPage {
	public static void inputEmail(WebDriver driver) throws IOException {
		File f = new File("C://Users/MrCajic/workspace_htec/Login_credentials.xlsx");
		InputStream in = new FileInputStream(f);
		XSSFWorkbook wb;
		wb = new XSSFWorkbook(in);
		Sheet sheet = (Sheet) wb.getSheetAt(0);
		XSSFRow row = ((XSSFSheet) sheet).getRow(0);
		Cell c0 = ((XSSFRow) row).getCell(0);
		WebElement email = driver.findElement(By.xpath(LoginPageConstants.INPUT_EMAIL));
		email.clear();
		email.sendKeys(c0.getStringCellValue());
		wb.close();

	}
// The login password is taken from the Excel file and entered in the password field
	public static void inputPassword(WebDriver driver) throws IOException {
		File f = new File("C://Users/MrCajic/workspace_htec/Login_credentials.xlsx");
		InputStream in = new FileInputStream(f);
		XSSFWorkbook wb;
		wb = new XSSFWorkbook(in);
		Sheet sheet = (Sheet) wb.getSheetAt(0);
		XSSFRow row = ((XSSFSheet) sheet).getRow(0);
		Cell c1 = ((XSSFRow) row).getCell(1);
		WebElement pass = driver.findElement(By.xpath(LoginPageConstants.INPUT_PASSWORD));
		pass.clear();
		pass.sendKeys(c1.getStringCellValue());

		wb.close();
	}

	public static void clickSubmit(WebDriver driver) {
		driver.findElement(By.xpath(LoginPageConstants.BTN_LOGIN)).click();

	}
// Method for entering login credentials
	public static void login(WebDriver driver) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		inputEmail(driver);
		inputPassword(driver);
		clickSubmit(driver);
		wait.until(ExpectedConditions.urlToBe(TestCasesConstants.URL_DASHBOARD));
	}
}
