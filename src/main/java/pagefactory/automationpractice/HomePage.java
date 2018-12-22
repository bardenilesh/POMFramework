package pagefactory.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.SeleniumUtilities;

public class HomePage extends SeleniumUtilities{
	WebDriver driver;
	@FindBy (linkText="Sign in") WebElement link_SignIn;
	@FindBy (id="email") WebElement txtBox_Username;
	@FindBy (id="passwd") WebElement txtBox_Password;
	@FindBy (id="SubmitLogin") WebElement btn_Submit;
	
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
