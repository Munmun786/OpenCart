package pageObjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver){
		
		super(driver);
		
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lynkRegister;
	
	@FindBy(linkText = "Login")
	WebElement lynkLogin;
	
	
	public void clickAccount() {
		
		lnkAccount.click();
	}
	
	public void clickRegister() {
		lynkRegister.click();
	}
	
	public void clickLogin() {
		
		lynkLogin.click();
	}
	
	
}
