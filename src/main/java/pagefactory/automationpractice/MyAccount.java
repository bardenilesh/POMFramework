package pagefactory.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.SeleniumUtilities;

public class MyAccount extends SeleniumUtilities{
	WebDriver driver;
	@FindBy (linkText="Sign out") WebElement link_Sign_Out;
	@FindBy (id="layered_category_4") WebElement chkBx_Top;
	@FindBy (linkText="Women") WebElement link_Women;
	@FindBy (id="layered_id_attribute_group_1") WebElement chkBx_Size_Small;
	@FindBy (id="selectProductSort") WebElement drp_Product_Sort_By;
	@FindBy (xpath="//a[(@class='product-name') and contains (text(),'Faded Short Sleeve T-shirts')]/ancestor::li") WebElement img_Container_Blouse;
	@FindBy (linkText="Add to cart") WebElement btn_Add_To_Cart;
	@FindBy (xpath="//span[@title='Continue shopping']") WebElement btn_Continue_Shopping;

	public MyAccount(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickOnSignOutButton() throws Exception{
		clickOnElement(link_Sign_Out);
	}
	
	public String verifySignOutButton(){
		return link_Sign_Out.getText();
	}
	
	public void checkTopCheckbox() throws Exception{
		clickOnElement(chkBx_Top);
	}
	
	public void clickOnWomenLink() throws Exception{
		clickOnElement(link_Women);
	}
	
	public void checkSizeSmallCheckbox() throws Exception{
		clickOnElement(chkBx_Size_Small);
	}
	
	public void selectProductSorting(String data) throws Exception{
		selectTextFromDropDown(drp_Product_Sort_By, data);
	}
	
	public void mouseOverOnBlouseImage() throws Exception{
		mouseOverOnElement(img_Container_Blouse);
	}
	
	public void clickOnAddToCartBlouse() throws Exception{
		clickOnElement(img_Container_Blouse.findElement(By.linkText("Add to cart")));
	}
}
