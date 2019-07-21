package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.abstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_01_RegisterAndLogin_PageObjectPattern extends abstractPage{
	WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		System.out.println("driver testcase layer : " + driver.toString());
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);

		email = "ductuyen" + randomEmail() + "@gmail.com";

		System.out.println("STEP 01 : Open Bankguru application");
		driver.get("http://demo.guru99.com/v4/");

		System.out.println("STEP 02 : Get login page url");
		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void TC_01_RegisterToSystem() {
		System.out.println("STEP 01 : Click to here link");
		loginPage.clickToHereLink();

		System.out.println("STEP 02 : Input to email textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("STEP 03 : Click to submit button");
		registerPage.clickToSubmitButton();

		System.out.println("STEP 04 : Get username/password");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}


	public void TC_LoginToSystem() {
		System.out.println("STEP 01 : Open login page url");
		registerPage.openLoginPageUrl(loginPageUrl);

		System.out.println("STEP 02 : Input username & password");
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);

		System.out.println("STEP 03 : Click to login button");
		loginPage.clickToLoginButton();

		System.out.println("STEP 04 : Welcom to homepage, verify welcome message");
		Assert.assertTrue(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Guru99 Bank"));

		System.out.println("STEP 05 : Welcom to homepage, verify user ID");
		Assert.assertTrue(homePage.isUserIdDisplay(username));

	}

	@Test
	public void TC_Dropdiwnlist() throws Exception {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		selectItemValue(driver, "//select[@id = 'job1']", "Mobile Tester");
		Thread.sleep(2000);
		selectItemValue(driver, "//select[@id = 'job1']", "Manual Tester");
		Thread.sleep(2000);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public int randomEmail() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
