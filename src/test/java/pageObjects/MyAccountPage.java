package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//h2[normalize-space()='My Account']")
	WebElement verifyAccount;
	
	@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout() {
		lnkLogout.click();
	}

	public boolean verifyMyAccount() {
		if(verifyAccount.isDisplayed()) {
			return verifyAccount.isDisplayed();
		}
		else {
			return false;
		}
	}
}
