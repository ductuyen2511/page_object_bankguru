package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Account_08_RegisterAndLogin_ElementUndisplayed extends abstractTest {
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

		System.out.println("driver testcase layer : " + driver.toString());

		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		email = "ductuyen" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {
		loginPageUrl = loginPage.getLoginPageUrl();
		System.out.println("STEP 01 : Click to here link");
		registerPage = loginPage.clickToHereLink();
		//registerPage = (RegisterPageObject) loginPage.openPageLink(driver, "New Customer");

		System.out.println("STEP 02 : Input to email textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("STEP 03 : Click to submit button");
		registerPage.clickToSubmitButton();


		System.out.println("STEP 04 : Get username/password");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("STEP 01 : Open login page url");
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);

		System.out.println("STEP 02 : Input username & password");
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);

		System.out.println("STEP 03 : Click to login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("STEP 04 : Welcom to homepage, verify welcome message");
		Assert.assertFalse(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Gurus99 Bank"));

		System.out.println("STEP 05 : Welcom to homepage, verify user ID");
		Assert.assertTrue(homePage.isUserIdDisplay(username));
	}
	
	@Test
	public void TC_03_ClickToPage() {
		newAccountPage = (NewAccountPageObject) homePage.openPageLink(driver, "New Account");
		depositPage = (DepositPageObject) newAccountPage.openPageLink(driver, "Deposit");
		depositPage.openPageLink2(driver, "Edit Account");
		editAccountPage = PageGeneratorManager.getEditNewAccount(driver);
		editAccountPage.openPageLink2(driver, "Withdrawal");
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
