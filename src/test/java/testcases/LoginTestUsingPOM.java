package testcases;

import org.testng.annotations.Test;
import org.testng.internal.PropertiesFile;

import pages.automationpractice.HomePage;
import pages.automationpractice.MyAccount;
import util.ExcelUtility;
import util.Global;
import util.SeleniumUtilities;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTestUsingPOM {
	static Logger log = Logger.getLogger(LoginTestUsingPOM.class.getName());
	ExcelUtility oExcel = new ExcelUtility();
	WebDriver driver;
	HomePage hp;
	MyAccount ma;

	@Test(priority = 0)
	public void login() throws Exception {
		Global.dataFile = Global.workDir + "\\testData\\Data.xls";
//		driver=Global.drv;
		hp = new HomePage(driver);
		ma = new MyAccount(driver);
		Properties prop = new Properties();
		prop.load(new FileInputStream(Global.workDir + "\\src\\test\\resources\\test.properties"));
		hp.performSignIn(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
//		hp.clickOnSignIn();
//		hp.enterUsername(prop.getProperty("USERNAME"));
//		hp.enterPassword(prop.getProperty("PASSWORD"));
//		hp.clickOnSubmit();
		wait(4000);
		System.out.println("Successfully Logged In");
		log.info("Successfully Logged In");
		//Assert.assertEquals(ma.verifySignOutButton(), "Sign out");
	}

	@Test(priority = 1, dependsOnMethods = "login")
	public void addToCart() throws Exception {
		ma.addToCart();
	}

	@BeforeClass
	public void beforeClass() {
		driver = SeleniumUtilities.getRunningBrowser();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
