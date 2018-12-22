package pages.automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.SeleniumUtilities;

public class MyAccount extends SeleniumUtilities{
	WebDriver driver;
	public By link_Sign_Out = By.linkText("Sign out");
	public By link_Women = By.linkText("Women");
	public By chkBx_Top = By.id("layered_category_4");
	public By chkBx_Size_Small = By.id("layered_id_attribute_group_1");
	public By drp_Product_Sort_By = By.id("selectProductSort");
	public By img_Container_Blouse = By
			.xpath("//a[(@class='product-name') and contains (text(),'Faded Short Sleeve T-shirts')]/ancestor::li");
	public By btn_Add_To_Cart = By.linkText("Add to cart");
	public By btn_Continue_Shopping = By.xpath("//span[@title='Continue shopping']");

	public MyAccount(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickOnSignOutButton() throws Exception{
		clickOnElement(link_Sign_Out);
	}
	
	public String verifySignOutButton() throws Exception{
		return getTextFromWebElement(link_Sign_Out);
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
		clickOnElement(findElement(img_Container_Blouse).findElement(By.linkText("Add to cart")));
	}
	
	public void addToCart() throws Exception{
		clickOnWomenLink();
		checkTopCheckbox();
		checkSizeSmallCheckbox();
//		selectProductSorting(oExcel.get("productsorting"));
		mouseOverOnBlouseImage();
		clickOnAddToCartBlouse();
	}
}
