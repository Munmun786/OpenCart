package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOut;
	
public boolean isMyAccountPageExtist() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement myAccountHeading= wait.until(ExpectedConditions.visibilityOf(msgHeading));
          	return myAccountHeading.isDisplayed();

		}
		catch(Exception e) {
			return false;
		}
		}
	

public void clickLogout() {
	
	logOut.click();
}
	
	
	
}
