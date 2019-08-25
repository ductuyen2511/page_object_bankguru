package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import commons.abstractTest;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;

public class Account_09_Assert_Verify_Log_ReportHTML extends abstractTest {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);

		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		email = "ductuyen" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_ElementDisplay() {
		log.info("Resgiter - STEP 01 : Verify login Page is Displayed");
		verifyTrue(loginPage.IsLoginFormDisplay());

		log.info("Resgiter - STEP 02 : Verify Ajax Demo Link is Displayed");
		verifyTrue(loginPage.IsAjaxDemoLinkUnDisplay());
		
		log.info("Resgiter - STEP 03 : Click to selenium dropdown");
		loginPage.clickToSeleniumDropdown();

		log.info("Resgiter - STEP 04 : Ajax Demo Link Display");
		//expected failed
		verifyFalse(loginPage.IsAjaxDemoLinkDisplay());

		log.info("Resgiter - STEP 05 : Register Page Not Display");
		verifyTrue(loginPage.isRegisterPageUnDisplay());

		log.info("Resgiter - STEP 06 : Home Page Not Display");
		verifyTrue(loginPage.isHomePageUnDisplay());

	}

	@Test
	public void TC_02_RegisterToSystem() {
		loginPageUrl = loginPage.getLoginPageUrl();
		
		log.info("STEP 01 : Click to here link");
		registerPage = loginPage.clickToHereLink();

		log.info("STEP 02 : Input to email textbox");
		registerPage.inputToEmailTextbox(email);

		log.info("STEP 03 : Click to submit button");
		registerPage.clickToSubmitButton();

		log.info("STEP 04 : Get username/password");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_03_LoginToSystem() {
		log.info("Login - STEP 01 : Open login page url");
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);

		log.info("Login - STEP 02 : Input username & password");
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);

		log.info("Login - STEP 03 : Click to login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - STEP 04 : Welcom to homepage, verify welcome message");
		verifyFalse(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Gurus99 Bank"));

		log.info("Login - STEP 05 : Welcom to homepage, verify user ID");
		verifyTrue(homePage.isUserIdDisplay(username));
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
