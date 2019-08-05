package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import commons.abstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;

public class Validation_05_NewAccount extends abstractTest{
	WebDriver driver;
	String username, password;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewAccountPageObject newAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);
		username = "mngr212610";
		password = "tyhadyd";
	}

	@Test
	public void TC_01_CustomerIdCanNotBeEmpty() {
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		loginPage.openPageLinks(driver, "New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPage(driver);
		
		newAccountPage.transferTabKeyCustomerIdTextbox();
		Assert.assertTrue(newAccountPage.isInputEmptyCustomerIdMessageDisplay("Customer ID is required"));
	}
	
	@Test
	public void TC_02_InputCharacterCustomerId() {
		newAccountPage.inputToCustomerIDTextbox("Abc123");
		Assert.assertTrue(newAccountPage.isInputCharCustomerIdMessageDisplay("Characters are not allowed"));
	}
	
	@Test
	public void TC_03_InputSpecialCharacterCustomerId() {
		newAccountPage.clearDataInputCustomerIdTextbox();
		newAccountPage.inputToCustomerIDTextbox("!@#123");
		Assert.assertTrue(newAccountPage.isInputSpecialCharCustomerIdMessageDisplay("Special characters are not allowed"));
	}
	
	@Test
	public void TC_05_InputFirstBlankSpaceCustomerId() {
		newAccountPage.clearDataInputCustomerIdTextbox();
		newAccountPage.inputToCustomerIDTextbox(" 123456");
		Assert.assertTrue(newAccountPage.isInputFirstBlankSpaceCustomerIdMessageDisplay("First character can not have space"));
	}
	
	@Test
	public void TC_06_DepositCanNotBeEmpty() {
		newAccountPage.transferTabKeyDepositTextbox();
		Assert.assertTrue(newAccountPage.isInputEmptyDepositMessageDisplay("Initial Deposit must not be blank"));
	}
	
	@Test
	public void TC_07_InputCharacterDeposit() {
		newAccountPage.inputToInitialDepostTextbox("Abc123");
		Assert.assertTrue(newAccountPage.isInputCharacterDepositMessageDisplay("Characters are not allowed"));
	}
	
	@Test
	public void TC_08_InputSpecialCharacterDeposit() {
		newAccountPage.clearDataInputDepositTextbox();
		newAccountPage.inputToInitialDepostTextbox("!@#123");
		Assert.assertTrue(newAccountPage.isInputSpecialCharacterDepositMessageDisplay("Special characters are not allowed"));
	}
	
	@Test
	public void TC_10_InputFirstBlankSpaceDeposit() {
		newAccountPage.clearDataInputDepositTextbox();
		newAccountPage.inputToInitialDepostTextbox(" 12345");
		Assert.assertTrue(newAccountPage.isInputFirstBlankSpaceDepositMessageDisplay("First character can not have space"));
	}
	
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
