package testCases;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountResistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


		// TODO Auto-generated method stub
 
		@Test(groups = {"Regression","Master"})
		public void verify_account_registration() {
			
			logger.info("***** Starting TC001_AccountRegistrationTest **** ");
			try {
			HomePage hP = new HomePage(driver);
			hP.clickAccount();
			logger.info("ClickOn my Account ");
			hP.clickRegister();
			logger.info("ClickOn My Registration ");
			
			AccountResistrationPage regPage= new AccountResistrationPage(driver);
			
			logger.info("providing customer Details");
			
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString()+"@gmail.com");
			regPage.setPhoneNo(randomNumber());
			String password=randomStringNumber();
			regPage.setPassword(password);
			regPage.cnfrmp(password);
			regPage.ClickSubscribe();
			regPage.clickPolicy();
			regPage.clickButtion();
			
			logger.info("Validating expected Details");
			String cmfrm=regPage.getConfirmationMsg();
			Assert.assertEquals(cmfrm, "Your Account Has Been Created!");
			}
			catch (Throwable e) {
				logger.error("Test faild :" + e.getMessage());
				logger.debug("Debug log",e);
				Assert.fail("Test Fail Due to Exception" + e.getMessage());
			}
			
			logger.info("**** Finish Test *****");
		}

}
