package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.abstractPage;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

public class Account_04_RegisterAndLogin_PageFactory extends abstractPage {
	WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageFactory loginPage;
	RegisterPageFactory registerPage;
	HomePageFactory homePage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		System.out.println("driver testcase layer : " + driver.toString());
		loginPage = new LoginPageFactory(driver);
		registerPage = new RegisterPageFactory(driver);
		homePage = new HomePageFactory(driver);

		email = "ductuyen" + randomEmail() + "@gmail.com";

		driver.get("http://demo.guru99.com/v4/");
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

	@Test
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomEmail() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
