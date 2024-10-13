package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
public class TC002_LoginTest extends BaseClass{
	@Test(groups={"sanity","master"})
	public synchronized void verifyLoginFunctionality() {
		logger.info("***** starting TC002_LoginTest ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(p.getProperty("userMail"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage ma = new MyAccountPage(driver);
		boolean verifiedAccount =ma.verifyMyAccount();
		Assert.assertEquals(verifiedAccount, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
