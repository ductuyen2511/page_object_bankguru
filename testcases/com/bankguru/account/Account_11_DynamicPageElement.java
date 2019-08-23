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

public class Account_11_DynamicPageElement extends abstractTest {
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
		username = "mngr212610";
		password = "tyhadyd";
		email = "ductuyen" + randomEmail() + "@gmail.com";
		
		System.out.println("STEP 01 : Open login page url");
		//loginPage = registerPage.openLoginPageUrl(loginPageUrl);

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
	void TC_01_CreateNewCustomer() {
		homePage.openPageLinks(driver, "New Customer");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
//		registerPage.inputToDynamicTextbox("name", "Le Duc Tuyen");
//		registerPage.inputTpDynamicTextarea("addr", "123 Tao dan");
//		registerPage.inputToDynamicTextbox("city", "Ho Chi Minh");
//		registerPage.inputToDynamicTextbox("state", "Sai Gon");
//		registerPage.inputToDynamicTextbox("pinno", "123456");
//		registerPage.inputToDynamicTextbox("telephoneno", "0909123456");
//		registerPage.inputToDynamicTextbox("emailid", email);
//		registerPage.inputToDynamicTextbox("password", "123456789");
		
		registerPage.pressTabKeyToDynamicElement("name");
		registerPage.pressTabKeyToDynamicElement("city");
		registerPage.pressTabKeyToDynamicElement("state");
		registerPage.pressTabKeyToDynamicElement("pinno");
		registerPage.pressTabKeyToDynamicElement("telephoneno");
		registerPage.pressTabKeyToDynamicElement("emailid");
		registerPage.pressTabKeyToDynamicElement("password");	
		
		Assert.assertTrue(registerPage.getErrorMessage("Customer Name", "Customer name must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("City", "City Field must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("State", "State must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("PIN", "PIN Code must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("Mobile Number", "Mobile no must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("E-mail", "Email-ID must not be blank"));
		Assert.assertTrue(registerPage.getErrorMessage("Password", "Password must not be blank"));
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}