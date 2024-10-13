package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
public class TC001_AccountRegistration_test extends BaseClass {

	@Test(groups={"regression","master"})
	public synchronized void verify_account_registration() {
		
		logger.info("**** starting TC001 AccountRegistration *****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account..");
		hp.clickRegister();
		logger.info("Clicked on Registration link..");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		logger.info("Providing customer details....");
		regPage.setFirstname(generateRandomAlphabetic(5));
		regPage.setLastname(generateRandomAlphabetic(5));
		regPage.setEmail(generateRandomAlphabetic(5)+"@gmail.com");
		regPage.setTelephone(generateRandomNumber(6));
		//
		String pwd = generateRandomAlphabetic(6);
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);

		regPage.clickBtnAgree();
		regPage.clickBtnContinue(driver);
		logger.info("Validating expected message..");
		String confirmMsg = regPage.getConfirmMsg();
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** TC001 AccountRegistration Completed *****");
}
}
