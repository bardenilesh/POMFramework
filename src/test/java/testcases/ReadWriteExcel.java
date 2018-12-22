package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.automationpractice.HomePage;
import util.SeleniumUtilities;

/**
 * @author Admin
 *
 */
public class ReadWriteExcel extends SeleniumUtilities
{
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	HomePage hp;

 @BeforeTest
 public void TestSetup()
{
	// Set the path of the Firefox driver.
	/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();*/
	driver=getRunningBrowser();
	// Enter url.
	driver.get("http://automationpractice.com");
	driver.manage().window().maximize();
	clickOnElement(hp.link_SignIn);
	/*WebElement link_SignIn= driver.findElement(By.linkText("Sign in"));
	link_SignIn.click()*/;
	
	wait = new WebDriverWait(driver,10);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
 
 @Test
 public void ReadData() throws Exception
 {
	 // Import excel sheet.
	 File src=new File(System.getProperty("user.dir")+"\\testData\\","TestCase.xlsx");
	 
	 // Load the file.
	 FileInputStream finput = new FileInputStream(src);
	 
	 // Load he workbook.
	workbook = new XSSFWorkbook(finput);
	 
     // Load the sheet in which data is stored.
	 sheet= workbook.getSheetAt(0);
//	 sheet= workbook.getSheet("Sheet 1");
	 HomePage hp = new HomePage(driver);
	 for(int i=1; i<=sheet.getLastRowNum(); i++)
	 {
		 wait(2000);
		 // Import data for Email.
		 cell = sheet.getRow(i).getCell(1);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 clearAndEnterText(hp.txtBox_Username, cell.getStringCellValue());
		 /*driver.findElement(By.id("email")).clear();
		 driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());*/
		 
		 // Import data for password.
		 cell = sheet.getRow(i).getCell(2);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 clearAndEnterText(hp.txtBox_Password, cell.getStringCellValue());
		 /*driver.findElement(By.id("passwd")).clear();
		 driver.findElement(By.id("passwd")).sendKeys(cell.getStringCellValue());*/
		   		
		 driver.findElement(By.id("SubmitLogin")).click();
		 
		 Thread.sleep(3000);
		 
		 if(!isElementPresent(By.linkText("Sign out"))){
			 String alert = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).findElement(By.tagName("li")).getText();
			 System.out.println(alert);
		 }else{
			 WebElement post_Login = driver.findElement(By.linkText("Sign out"));
			 post_Login.click();
		 }
		 
		 Thread.sleep(3000);
		 
		 
        }
  } 
 
 public boolean isElementPresent(By by) {
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
 
 @AfterTest
 public void tearDown()
{
	driver.quit();
}

}