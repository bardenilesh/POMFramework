package pages.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.SeleniumUtilities;

public class HomePage extends SeleniumUtilities{
	WebDriver driver;
	public By link_SignIn = By.linkText("Sign in");
	public By txtBox_Username = By.id("email");
	public By txtBox_Password = By.id("passwd");
	public By btn_Submit = By.id("SubmitLogin");
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickOnSignIn() throws Exception{
		clickOnElement(link_SignIn);
	}
	
	public void enterUsername(String data){
		enterText(txtBox_Username, data);
	}
	
	public void enterPassword(String data){
		enterText(txtBox_Password, data);
	}
	
	public void clickOnSubmit() throws Exception{
		clickOnElement(btn_Submit);
	}
	
	public void performSignIn(String username, String password) throws Exception{
		clickOnSignIn();
		enterUsername(username);
		enterPassword(password);
		clickOnSubmit();		
	}
	
	
	
}
