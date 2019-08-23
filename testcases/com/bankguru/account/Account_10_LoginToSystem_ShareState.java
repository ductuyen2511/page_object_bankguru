package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.common.Common_01_RegisterToSystem;

import commons.PageGeneratorManager;
import commons.abstractTest;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;

public class Account_10_LoginToSystem_ShareState extends abstractTest {
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
		
		System.out.println("STEP 01 : Open login page url");
		//loginPage = registerPage.openLoginPageUrl(loginPageUrl);

		System.out.println("STEP 02 : Input username & password");
		loginPage.inputToUserIdTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		System.out.println("STEP 03 : Click to login button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("STEP 04 : Welcom to homepage, verify welcome message");
		Assert.assertFalse(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Gurus99 Bank"));

		System.out.println("STEP 05 : Welcom to homepage, verify user ID");
		Assert.assertTrue(homePage.isUserIdDisplay(Common_01_RegisterToSystem.USERNAME));

	}

	@Test
	void TC_01_CreateNewCustomer() {	
	}

	@Test
	void TC_02_EditCustomer() {	
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
