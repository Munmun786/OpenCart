package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	@FindBy(id = "input-email")
	WebElement textEmailInput;
	
	@FindBy(id="input-password")
	WebElement textPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement button;
	
	
	public void enterEmail(String email) {
		
		textEmailInput.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		textPassword.sendKeys(password);
	}
	
	public void clickButton() {
		button.click();
	}
	
	
	
	
}
