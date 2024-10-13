package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
public class TC003_LoginDD_Test extends BaseClass {
	@Test(groups={"datadriven","master"},dataProvider = "Login", dataProviderClass = DataProviders.class)
	public synchronized void verifyDataDrivenTest(String username, String pwd, String res) {
		logger.info("******* starting TC003_LoginDD_Test..");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterUserName(username);
			lp.enterPassword(pwd);
			lp.clickLogin();

			MyAccountPage ma = new MyAccountPage(driver);
			boolean verifiedAccount = ma.verifyMyAccount();
			if (res.equalsIgnoreCase("Valid")) {
				if (verifiedAccount == true) {
					ma.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}
			if (res.equalsIgnoreCase("Invalid")) {
				if (verifiedAccount == true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
