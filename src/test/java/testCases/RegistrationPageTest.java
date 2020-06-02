package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import testBase.TestBase;
import util.TestUtil;

public class RegistrationPageTest extends TestBase {

	RegistrationPage registrationPage = new RegistrationPage();
	String sheetName = "Registration";

	Logger log = Logger.getLogger(RegistrationPageTest.class);

	public RegistrationPageTest() { // constructor of RegistrationPageTest class

		super();
		/*
		 * it will call super class constructor i.e. TestBase by using super keyword so
		 * it will initialize properties i.e it will link with .properties
		 */

	}

	@BeforeMethod
	public void setUP() {
		log.info("WebDriver initialization process starts");
		initialization(); // it will call initialization() method from TestBase class to launch browser

		registrationPage = new RegistrationPage();
		// created object reference of class to access all objects from class

		log.info("WebDriver successfully launched.");
	}

	@Test(priority = 1)
	public void validateRegistrationPageTest() {
		log.info("First test case execution is in process.");
		String textOnPage = registrationPage.validateRegistrationPage();
		System.out.println("Validation of Ragistration Page is text appear and it is==>" + textOnPage);
		Assert.assertEquals(textOnPage, "Sign up as a new user");
		log.info("Test Case 1 successfully executed");
	}

	@Test(priority = 2)
	public void validatePageTitleTest() {
		log.info("Test Case 2 execution is in process");
		String registrationPageTitle = registrationPage.validatePageTitle();
		System.out.println("Title of Registration Page is ==>" + registrationPageTitle);
		Assert.assertEquals(registrationPageTitle, "Insurance Broker System - Register");
		log.info("Test Case 2 successfully executed");
	}

	@DataProvider
	public Object[][] createRegistration() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "createRegistration", priority = 3)
	public void createRegistrationWithExcelData(String userName, String userSurname, String userPhone, String birthYear,
			String birthmonth, String birthdate, String Useroccupation, String userStreet, String userCity,
			String userCountry, String userPostcode, String userEmail, String userPassword,
			String userConfirmPassword) {

		log.info("Create Customer Registration test execution is in process.");
		
		registrationPage.newRegistration(userName, userSurname, userPhone, birthYear, birthmonth, birthdate,
				Useroccupation, userStreet, userCity, userCountry, userPostcode, userEmail, userPassword,
				userConfirmPassword);

		log.info("Create Customer Registration test execution is successfully completed.");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
