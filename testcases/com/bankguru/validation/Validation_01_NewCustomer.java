package com.bankguru.validation;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Validation_01_NewCustomer {
	WebDriver driver;
	String username, password;

	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/");

		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

		username = "mngr204852";
		password = "UbUrYbe";
	}

	@Test
	public void TC_01_InputEmptyCustomerName() {
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		loginPage.clickToLoginButton();

		// Verify home page
		Assert.assertTrue(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Guru99 Bank"));
		Assert.assertTrue(homePage.isUserIdDisplay(username));

		// click to New customer link
		homePage.newCustomerLink();

		// Verify message new customer page
		Assert.assertTrue(registerPage.isAddNewCustomerMessage("Add New Customer"));

		// Input empty user name by pressing Tab Key
		registerPage.transerTabKey();

		// verify message
		Assert.assertTrue(registerPage.isCustomerNameMessageDisplay("Customer name must not be blank"));
	}

	@Test
	public void TC_02_InputNumberCustomerName() {
		registerPage.inputToUserNameTextbox("1234");
		Assert.assertTrue(registerPage.isCustomerNumericMessage("Numbers are not allowed"));
	}

	@Test
	public void TC_03_InputSpecialCharCustomerName() {
		registerPage.clearDataInputCustomerName();
		registerPage.inputToUserNameTextbox("name!@#");
		Assert.assertTrue(registerPage.isCustomerSpecialCharacterMessage("Special characters are not allowed"));
	}

	@Test
	public void TC_04_InputBlankSpaceCustomerName() {
		registerPage.clearDataInputCustomerName();
		registerPage.inputToUserNameTextbox(" ");
		Assert.assertTrue(registerPage.isCustomerSpaceCharMessage("First character can not have space"));
	}

	@Test
	public void TC_05_InputEmptyAddress() {
		registerPage.clearDataInputCustomerName();
		registerPage.transerTabKeyAddress();
		Assert.assertTrue(registerPage.isAddressEmptyMessageDisplay("Address Field must not be blank"));
	}

	@Test
	public void TC_06_InputFirstCharAddress() {
		registerPage.inputToAddressTextbox(" ");
		Assert.assertTrue(registerPage.isAddressSpaceCharMessageDisplay("First character can not have space"));
	}

	@Test
	public void TC_07_InputEmptyCity() {
		registerPage.refreshRegisterPage();
		registerPage.transferTabKeyCity();
		Assert.assertTrue(registerPage.isCityEmptyMessageDisplay("City Field must not be blank"));
	}

	@Test
	public void TC_08_InputNumberCity() {
		registerPage.inputToCityTextbox("1234");
		Assert.assertTrue(registerPage.isCityNumberMessageDisplay("Numbers are not allowed"));
	}

	@Test
	public void TC_09_InputSpecialCharCity() {
		registerPage.clearDataInputCity();
		registerPage.inputToCityTextbox("City!@#");
		Assert.assertTrue(registerPage.isCitySpecialCharMessageDisplay("Special characters are not allowed"));
	}

	@Test
	public void TC_10_InputBlankSpaceCity() {
		registerPage.clearDataInputCity();
		registerPage.inputToCityTextbox(" ");
		Assert.assertTrue(registerPage.isCitySpaceMessageDisplay("First character can not have space"));
	}

	@Test
	public void TC_11_InputEmptyState() {
		registerPage.refreshRegisterPage();
		registerPage.transferTabKeyState();
		Assert.assertTrue(registerPage.isStateEmptyMessageDisplay("State must not be blank"));
	}

	@Test
	public void TC_12_InputNumberState() {
		registerPage.inputToStateTextbox("1234");
		Assert.assertTrue(registerPage.isStateNumberMessageDisplay("Numbers are not allowed"));
	}

	@Test
	public void TC_13_InputSpecialCharState() {
		registerPage.inputToStateTextbox("State!@#");
		Assert.assertTrue(registerPage.isStateSpacialCharMessageDisplay("Special characters are not allowed"));
	}

	@Test
	public void TC_14_InputBlankSpaceState() {
		registerPage.clearDataInputState();
		registerPage.inputToStateTextbox(" ");
		Assert.assertTrue(registerPage.isStateSpaceMessageDisplay("First character can not have space"));
	}

	@Test
	public void TC_15_InputCharPin() {
		registerPage.clearDataInputState();
		registerPage.inputToPinTextbox("PIN1234");
		Assert.assertTrue(registerPage.isPinCharacterMessageDisplay("Characters are not allowed"));
	}

	@Test
	public void TC_16_InputEmptyPin() {
		registerPage.refreshRegisterPage();
		registerPage.transferTabKeyPin();
		Assert.assertTrue(registerPage.isPinEmptyMessageDisplay("PIN Code must not be blank"));
	}

	@Test
	public void TC_17_InputLessThanSixDigitsPin() {
		registerPage.inputToPinTextbox("123");
		Assert.assertTrue(registerPage.isPinSixDigitsMessageDisplay("PIN Code must have 6 Digits"));
	}

	@Test
	public void TC_18_InputSpecialCharPin() {
		registerPage.clearDataInputPin();
		registerPage.inputToPinTextbox("Pin!@#");
		Assert.assertTrue(registerPage.isPinSpecialCharacterMessageDisplay("Special characters are not allowed"));
	}

	@Test
	public void TC_19_InputBlankPagePin() {
		registerPage.clearDataInputPin();
		registerPage.inputToPinTextbox(" ");
		Assert.assertTrue(registerPage.isPinBlankSpaceMessageDisplay("First character can not have space"));
	}

	public void TC_20_InputBlankPagePin() {

	}

	@Test
	public void TC_21_InputEmptyTelephone() {
		registerPage.clearDataInputPin();
		registerPage.transferTabKeyTelephone();
		Assert.assertTrue(registerPage.isTelephoneEmptyMessage("Mobile no must not be blank"));
	}
	
	@Test
	public void TC_22_InputBlankSpaceTelephone() {
		registerPage.inputToTelephoneTextbox(" ");
		Assert.assertTrue(registerPage.isTelephoneBlankSpaceMessage("First character can not have space"));
	}

	public void TC_23_InputBlankPageTelephone() {

	}
	
	@Test
	public void TC_24_InputSpecialCharTelephone() {
		registerPage.clearDataInputTelephone();
		registerPage.inputToTelephoneTextbox("456456!@#");
		Assert.assertTrue(registerPage.isTelephoneSpecialCharacterMessage("Special characters are not allowed"));
	}
	
	@Test
	public void TC_25_InputEmptyEmail() {
		registerPage.transferTabKeyEmail();
		Assert.assertTrue(registerPage.isEmailEmptyMessage("Email-ID must not be blank"));
	}
	
	@Test
	public void TC_26_InputInvalidEmail() {
		registerPage.inputToEmailTextbox("guru99@gmail");
		Assert.assertTrue(registerPage.isEmailInvalidMessage("Email-ID is not valid"));
	}
	
	@Test
	public void TC_27_InputBlankSpaceEmail() {
		registerPage.clearDataEmail();
		registerPage.inputToEmailTextbox(" ");
		Assert.assertTrue(registerPage.isEmailBlankSpaceMessage("First character can not have space"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomEmail() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
