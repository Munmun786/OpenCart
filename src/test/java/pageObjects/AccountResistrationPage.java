package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Video;

public class AccountResistrationPage extends BasePage {
	
	public AccountResistrationPage(WebDriver driver) {
		
		super(driver);
	}
@FindBy(id="input-firstname")	
WebElement txtFirstNam;
	
@FindBy(id="input-lastname")
WebElement txtLastNam;

@FindBy(id = "input-email")
WebElement txtEmail;

@FindBy(id="input-telephone")
WebElement textPhone;


@FindBy(id = "input-password")
WebElement txtPassword;

@FindBy(xpath = "//input[@placeholder='Password Confirm']")
WebElement confmPassword;

@FindBy(xpath = "//label[normalize-space()='Yes']")
WebElement subScrib;

@FindBy(xpath = "//input[@name='agree']")
WebElement ckdPolicy;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement cnfrmMsg;

@FindBy(xpath = "//input[@value='Continue']")
WebElement confrmButton;

public void setFirstName(String fname) {
	txtFirstNam.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastNam.sendKeys(lname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setPhoneNo(String phone) {
	textPhone.sendKeys(phone);
}

public void setPassword(String password) {
	txtPassword.sendKeys(password);
}

public void cnfrmp(String Cpass) {
	confmPassword.sendKeys(Cpass);
}

public void ClickSubscribe() {
subScrib.click();	
}

public void clickPolicy() {
	ckdPolicy.click();
}

public void clickButtion() {
	confrmButton.click();
//sol2
//	confrmButton.submit();

	//sol3
//Actions act=new Actions(driver);
//act.moveToElement(confrmButton).click();
	//sol4;
//JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("argument[0].click()", confrmButton);

//sol5
//	confrmButton.sendKeys(Keys.RETURN);
	
	//sol6
//	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	myWait.until(ExpectedConditions.elementToBeClickable(confrmButton)).click();


}

public String getConfirmationMsg() {
	
	try {
		return	(cnfrmMsg.getText());
	} catch (Exception e) {
	
		return (e.getMessage());
		// TODO: handle exception
	}

	
}








}
