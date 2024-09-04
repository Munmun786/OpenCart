package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {

	
	public HomePage hP;
	public LoginPage lP;
	
	@Test(groups = {"Sanity","Master"})
	public void veryfy_Login() {
		
	   logger.info(" *** Starting LoginTest ***");	
	   try {
		 hP = new HomePage(driver);
		
		 hP.clickAccount();
		 logger.info("Click on account ");
		 
		 hP.clickLogin();
		 logger.info("Click on Login Button");
		 lP= new LoginPage(driver);
		 logger.info("fill Up cridentials");
		 lP.enterEmail(pro.getProperty("email"));
		 lP.enterPassword(pro.getProperty("password"));
		 lP.clickButton();
		 
		 
		 MyAccountPage mcp = new MyAccountPage(driver);
		 Assert.assertTrue(mcp.isMyAccountPageExtist());
	   }
	   catch(Throwable e){
		   logger.error("Test faild :" + e.getMessage());
			logger.debug("Debug log",e);
			Assert.fail("Test Fail Due to Exception" + e.getMessage());
	   }
		
		logger.info("finish test");
	}
	

}
