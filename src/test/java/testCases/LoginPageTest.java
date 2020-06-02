package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.LoginPage;
import testBase.TestBase;
import util.TestUtil;

public class LoginPageTest extends TestBase {

	// LoginPageTest loginPageTest;
	LoginPage loginPage = new LoginPage();
	String sheetName = "Credentials";
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		log.info(
				"**********************Initialization method will launch WebDriver**************************************");
		initialization();
		log.info("**********************Application launched successfully**************************************");
	}

	@Test(priority = 1)

	public void validateTitleTest() {
		log.info("**********************Test 1*****************************");
		log.info("***************************Validation of Page Title****************************");
		String loginPageTitle = loginPage.validateTitle();
		System.out.println("Login Page titile is ==> " + loginPageTitle);
		Assert.assertEquals("Insurance Broker System - Login", loginPageTitle);
		log.info("**********************Page Title validation is successful*****************************");
	}

	@Test(priority = 2)
	public void validatePageTextTest() {
		loginPage = new LoginPage();
		log.info("**********************Test 2*****************************");
		log.info("***************************Validation of Page Text****************************");
		String loginPageText = loginPage.validateText();
		System.out.println("Validation Text is==>" + loginPageText);
		Assert.assertEquals(loginPageText, "Login");
		log.info("**********************Page Text validation is successful*****************************");
	}

	@DataProvider
	public Object[][] loginPageApplication() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(dataProvider = "loginPageApplication", priority = 3)
	public void validateLoginPageTest(String useremailid, String userpassword) {
		loginPage = new LoginPage();
		log.info("**********************Test 3*****************************");
		log.info("***************************Validation of Page Login functionality****************************");
		loginPage.loginApplication(useremailid, userpassword);
		log.info(
				"**********************Page Login functionality validation is successful*****************************");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("***********************Chrome browser closed************************************");
	}
}
