package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.TestBase;

public class RegistrationPage extends TestBase {
	
	
	
	/*
	 * we have to define object repository (page factory) where we will define all
	 * web elements which we have to test and which are available on this page
	 */

	// We are using @FindBy annotation in the place of driver.findElement
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	static WebElement registerBtn;

	@FindBy(xpath = "//h1[contains(text(),'Sign up as a new user')]")
	static WebElement pageText;
	
	@FindBy(xpath = "//select[@id='user_title']")
	static WebElement title;

	@FindBy(xpath = "//input[@id='user_firstname']")
	static WebElement firstName;

	@FindBy(xpath = "//input[@id='user_surname']")
	static WebElement surName;

	@FindBy(xpath = "//input[@id='user_phone']")
	static WebElement phone;

	@FindBy(xpath = "//select[@name='year']")
	static WebElement year;

	@FindBy(xpath = "//select[@name='month']")
	static WebElement month;

	@FindBy(xpath = "//select[@name='date']")
	static WebElement date;

	@FindBy(xpath = "//select[@id='user_occupation_id']")
	static WebElement occupation;

	@FindBy(xpath = "//input[@name='street']")
	static WebElement street;

	@FindBy(xpath = "//input[@name='city']")
	static WebElement city;

	@FindBy(xpath = "//input[@name='county']")
	static WebElement country;

	@FindBy(xpath = "//input[@name='post_code']")
	static WebElement postcode;

	@FindBy(xpath = "//input[@name='email']")
	static WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	static WebElement password;

	@FindBy(xpath = "//input[@name='c_password']")
	static WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='submit']")
	static WebElement createBtn;

	public RegistrationPage() { // constructor of class
		/*	PageFactory.initElements(driver, page); to initialize page factory with driver and available elements 	*/

		PageFactory.initElements(driver, this);

		/*	this means current class object which we have defined like email, password,firstname, surname etc	*/
	}
	
	//Actions
	
	public String validateRegistrationPage() {
		
		registerBtn.click();
		return pageText.getText();
		
	}
	
	public  String validatePageTitle() {
		
		registerBtn.click();
		return driver.getTitle();
		
	}

	public  LoginPage newRegistration(String userName, String userSurname, String userPhone, String birthYear, 
			String birthmonth, String birthdate, String Useroccupation, String userStreet, String userCity, String userCountry, 
			String userPostcode, String userEmail, String userPassword, String userConfirmPassword) {
		
		registerBtn.click();
		
		Select titleOfUser = new Select(title);
		titleOfUser.selectByIndex(1);
		
		firstName.clear();
		firstName.sendKeys(userName);
		
		surName.clear();
		surName.sendKeys(userSurname);
		
		phone.clear();
		phone.sendKeys(userPhone);
		
		Select yearOfBirth = new Select(year);
		yearOfBirth.selectByValue(birthYear);
		
		Select monthOfBirth = new Select(month);
		monthOfBirth.selectByVisibleText(birthmonth);
		
		Select dateOfBirth = new Select(date);
		dateOfBirth.selectByValue(birthdate);
		
		Select occupationOfUser = new Select(occupation);
		occupationOfUser.selectByVisibleText(Useroccupation);
		
		street.clear();
		street.sendKeys(userStreet);
		
		city.clear();
		city.sendKeys(userCity);
		
		country.clear();
		country.sendKeys(userCountry);
		
		postcode.clear();
		postcode.sendKeys(userPostcode);
		
		email.clear();
		email.sendKeys(userEmail);
		
		password.clear();
		password.sendKeys(userPassword);
		
		confirmPassword.clear();
		confirmPassword.sendKeys(userConfirmPassword);
		
		createBtn.click();
		
	return new LoginPage();
	}
	
}
