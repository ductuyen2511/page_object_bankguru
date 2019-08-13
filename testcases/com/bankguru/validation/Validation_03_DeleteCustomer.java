package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import commons.abstractTest;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class Validation_03_DeleteCustomer extends abstractTest {
	WebDriver driver;
	String username, password, LoginPageUrl;
	LoginPageObject loginPage;
	HomePageObject homePage;
	DeleteCustomerPageObject deleteCustomerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);
		
		username = "mngr212610";
		password = "tyhadyd";
	}

	@Test
	public void TC_01_CustomerIdCannotBeEmpty() {
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		deleteCustomerPage = homePage.openDeleteCustomerPage(driver);
		System.out.println("Driver testcase layer" + driver.toString());
		deleteCustomerPage.transferTabkeyCustomerId();
		Assert.assertTrue(deleteCustomerPage.isEmptyCustomerIdMessageDisplay("Customer ID is required"));
	}
	
	public void TC_02_CustomerIdInputCharacter() {
		deleteCustomerPage.inputIntoCustomerIdTextbox("abc123");
		Assert.assertTrue(deleteCustomerPage.isCustomerIdInputCharMessageDisplay("Characters are not allowed"));
	}
	
	public void TC_03_CustomerIdInputSpecialCharacter() {
		deleteCustomerPage.clearDataCustomerIdTextbox();
		deleteCustomerPage.inputIntoCustomerIdTextbox("123!@#");
		Assert.assertTrue(deleteCustomerPage.isCustomerIdInputSpecialCharMessageDisplay("Special characters are not allowed"));
	}
	
	public void TC_05_CustomerIdInputFirstBlankSpace() {
		deleteCustomerPage.clearDataCustomerIdTextbox();
		deleteCustomerPage.inputIntoCustomerIdTextbox(" 123");
		Assert.assertTrue(deleteCustomerPage.isCustomerIdInputFirstBlankSpaceMessageDisplay("First character can not have space"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
