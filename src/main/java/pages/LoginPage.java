package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBase;

public class LoginPage extends TestBase {

	// Page Factory

	@FindBy(xpath = "//h3[contains(text(),'Login')]")
	static WebElement loginText;

	@FindBy(xpath = "//input[@id='email']")
	static WebElement loginemail;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement loginpassword;

	@FindBy(xpath = "//input[@name='submit']")
	static WebElement submitBtn;

	public LoginPage() { // constructor of LoginPage
		PageFactory.initElements(driver, this);
	}

	//Actions	
	public String validateTitle() {
		return driver.getTitle();
		
	}

	public String validateText() {
		return loginText.getText();
		
	}

	public HomePage loginApplication(String useremailid, String userpassword) {
		
		loginemail.clear();
		loginemail.sendKeys(useremailid);
		
		loginpassword.clear();
		loginpassword.sendKeys(userpassword);

		
		submitBtn.click();
		
		return new HomePage();
	}

}
