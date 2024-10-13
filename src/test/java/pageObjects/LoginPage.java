package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath ="//input[@id='input-email']")
	WebElement userEmail;
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement userpwd;
	@FindBy(xpath ="//input[@value='Login']")
	WebElement btnLogin;
	
	public void enterUserName(String user) {
		userEmail.sendKeys(user);
	}
	
	public void enterPassword(String pwd) {
		userpwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}


