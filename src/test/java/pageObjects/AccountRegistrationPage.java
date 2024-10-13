package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	

@FindBy(xpath = "//input[@id='input-firstname']")	
WebElement textFirstname;
@FindBy(xpath = "//input[@id='input-lastname']")	
WebElement textLastName;
@FindBy(xpath = "//input[@id='input-email']")	
WebElement textEmail;
@FindBy(xpath = "//input[@id='input-telephone']")	
WebElement textTelephone;
@FindBy(xpath = "//input[@id='input-password']")	
WebElement textPassword;	
@FindBy(xpath = "//input[@id='input-confirm']")	
WebElement confirmPassword;	
@FindBy(xpath = "//input[@name='agree']")	
WebElement btnAgree;	
@FindBy(xpath = "//input[@value='Continue']")	
WebElement btnContinue;	

@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confirmMsg;

public void setFirstname(String fname) {
	textFirstname.sendKeys(fname);
}

public void setLastname(String lname) {
	textLastName.sendKeys(lname);
}

public void setEmail(String email) {
	textEmail.sendKeys(email);
}

public void setTelephone(String phone) {
	textTelephone.sendKeys(phone);
}

public void setPassword(String pwd) {
textPassword.sendKeys(pwd);	
}

public void setConfirmPassword(String pwd) {
confirmPassword.sendKeys(pwd);	
}

public void clickBtnAgree() {
	btnAgree.click();
}

public void clickBtnContinue(WebDriver driver) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", btnContinue);
}
	
public String getConfirmMsg() {
	try {
	return confirmMsg.getText();
	}
	catch(Exception e) {
		return e.getMessage();
	}
}
}
