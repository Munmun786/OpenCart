package testCases;

import java.awt.dnd.peer.DropTargetPeer;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid -login success - test pass - logout
 * Data is valid -- login failded - test fail
 * 
 * Data is invalid -- login success - test fail - logout
 * data is invalid --- login failed -- test pass
 */
public class TCC003_LOGINDDT extends BaseClass{

	public HomePage hP;
	public LoginPage lP;
	
	
	
	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class,groups = "DataDriven")
	public void verify_loginDDT(String email,String pwd, String exp) {
		
		
		logger.info("**** starting TC-003_LogInDDt");
		try {
		//HomePage
		 hP = new HomePage(driver);
		 hP.clickAccount();
		 hP.clickLogin();
		 
		 //Login
		 lP= new LoginPage(driver);
		 lP.enterEmail(email);
		 lP.enterPassword(pwd);
		 lP.clickButton();
		 
		 //MyAccount
		 MyAccountPage mcp = new MyAccountPage(driver);
		 boolean targetPage =mcp.isMyAccountPageExtist();
		 
		 if(exp.equalsIgnoreCase("valid")) {
			 if(targetPage==true) {
				 mcp.clickLogout();
				 Assert.assertTrue(true);
				
			 }
			 else {
				 Assert.assertTrue(false);
			 }
		 }
		 
		 if(exp.equalsIgnoreCase("invalid")) {
			 if(targetPage==true) {
				 mcp.clickLogout();
				 Assert.assertTrue(false);
				 }else {
						Assert.assertTrue(true);
		
	}
	}
		
		}catch (Exception e){
			
			 logger.error("Exception occurred: " + e.getMessage());
			    Assert.fail(e.getMessage());
			
		}
		 
	logger.info("***** Finished TC_003_LogInDDT");
	
	}
	
}
