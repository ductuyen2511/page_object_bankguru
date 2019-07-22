package com.bankguru.validation;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;

public class Validation_03_Payment {
	WebDriver driver;
	String username, password, LoginPageUrl;
	String customerName, gender, birthday, address, city, state, pin, mobileNo, email, passwordRegister;
	String addressEdit, cityEdit, stateEdit, pinEdit, mobileNoEdit, emailEdit;
	String getTextCustomerID, getAccountNo;

	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	EditCustomerObject editCustomer;
	NewAccountPageObject newAccount;
	EditAccountPageObject editAccount;
	DepositPageObject depositPage;
	WithdrawalPageObject withdrawalPage;
	FundTransferPageObject fundTransferPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	DeleteAccountPageObject deleteAccountPage;
	DeleteCustomerPageObject deleteCustomerPage;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();

		username = "mngr204852";
		password = "UbUrYbe";

		customerName = "AUTOMATION TESTING";
		birthday = "01/01/1989";
		address = "PO Box 911 8331 Duis Avenue";
		city = "Tampa";
		state = "FL";
		pin = "466250";
		mobileNo = "0989484848";
		email = "automation" + randomEmail() + "@gmail.com";
		passwordRegister = "123456789";
		

		addressEdit = "1883 Cursus Avenue";
		cityEdit = "Houston";
		stateEdit = "Texas";
		pinEdit = "166455";
		mobileNoEdit = "4779728081";
		emailEdit = "testing@gmail.com";
	}

	@Test
	public void TC_01_RegisterNewCustomer() {
		driver.get("http://demo.guru99.com/V4/");
		
		
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		LoginPageUrl = loginPage.getLoginPageUrl();

		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isDisplayWelcomeMessage("Welcome To Manager's Page of Guru99 Bank"));
		Assert.assertTrue(homePage.isUserIdDisplay(username));

		registerPage = homePage.newCustomerLink();
		Assert.assertTrue(registerPage.isAddNewCustomerMessage("Add New Customer"));

		registerPage.inputToUserNameTextbox(customerName);
		registerPage.inputToGenderTextbox();
		registerPage.inputToDateOfBirth(birthday);
		registerPage.inputToAddressTextbox(address);
		registerPage.inputToCityTextbox(city);
		registerPage.inputToStateTextbox(state);
		registerPage.inputToPinTextbox(pin);
		registerPage.inputToTelephoneTextbox(mobileNo);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(passwordRegister);
		registerPage.clickToSubmitButtonNewCustomer();
		Assert.assertTrue(registerPage.isCustomerRegisterSuccessfullyMessageDisplay("Customer Registered Successfully!!!"));
		
		getTextCustomerID = registerPage.getTextCustomerID();
	}
	
	@Test
	public void TC_02_EditCustomerAccount() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		editCustomer = homePage.clickToEditCustomer();
		
		editCustomer.inputToCustomerIDTextbox(getTextCustomerID);
		editCustomer.clickToEditCustomerSubmitButton();
		
		editCustomer.clearDataInputAddressTextBox();
		editCustomer.clearDataInputCityTextBox();
		editCustomer.clearDataInputStateTextBox();
		editCustomer.clearDataInputPinTextBox();
		editCustomer.clearDataInputTelephoneTextBox();
		editCustomer.clearDataInputEmailTextbox();
		
		editCustomer.inputToAddressTextbox(addressEdit);
		editCustomer.InputToCityTextbox(cityEdit);
		editCustomer.inputToStatetextbox(stateEdit);
		editCustomer.inputToPintextbox(pinEdit);
		editCustomer.inputToTelephoneTextbox(mobileNoEdit);
		editCustomer.inputToEmailTextbox(emailEdit);
		editCustomer.clickToEditSubmitButton();
		
		Assert.assertTrue(registerPage.isEditCustomerRegisterSuccessfullyMessageDisplay("Customer details updated Successfully!!!"));
	}
	
	@Test
	public void TC_03_AddNewAccountPage() {
		//driver.get("http://demo.guru99.com/V4/");
		//loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		newAccount = homePage.clickToNewAccountLink();
		
		newAccount.inputToCustomerIDTextbox(getTextCustomerID);
		System.out.println("customer ID :" + getTextCustomerID);
		newAccount.inputToInitialDepostTextbox("50000");
		newAccount.clicktoSubmisButton();
		
		getAccountNo = newAccount.getTextAccountNo();
		
		Assert.assertTrue(newAccount.isAccountGenerateMessageDisplay("Account Generated Successfully!!!"));
		Assert.assertTrue(newAccount.isCurrentAmountDisplay("50000"));
	}
	
	@Test
	public void TC_04_EditNewAccountPage() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		editAccount = homePage.clickToEditAccount();
		editAccount.inputToAccountNo(getAccountNo);
		System.out.println("Account No :" + getAccountNo);
		editAccount.clickToSubmitButton();
		editAccount.selectItemTypeAccount("Current");
		editAccount.clickToSubmitButton();

		Assert.assertTrue(editAccount.isEditAccountGenerateMessageDisplay("Account details updated Successfully!!!"));
		Assert.assertTrue(editAccount.isTypeAccountDisplay("Current"));
	}
	
	@Test
	public void TC_05_TransferMoneyDeposit() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		depositPage = homePage.clickToDepositPage();
		depositPage.inputIntoAccountNoTextbox(getAccountNo);
		depositPage.inputIntAmountTextbox("5000");
		depositPage.inputIntoDescriptionTextbox("Deposit");
		depositPage.clickToSubmitButtonDeposit();
		
		Assert.assertEquals(depositPage.isTransactionOfDepositMessageDisplay(),"Transaction details of Deposit for Account" + " " + getAccountNo);
		Assert.assertTrue(depositPage.isCurrentBalanceDisplay("55000"));
	}
	
	@Test
	public void TC_06_AmountWithdrawal() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		withdrawalPage = homePage.clickToWithdrawalLink();
		withdrawalPage.inputToAccountNoTextbox(getAccountNo);
		withdrawalPage.inputIntoAmountTextbox("15000");
		withdrawalPage.inputIntoDescriptionTextbox("Withdraw");
		withdrawalPage.clickToSubmitButton();
		
		Assert.assertEquals(withdrawalPage.isTransactionOfWithdrawMessageDisplay(),"Transaction details of Withdrawal for Account" + " " + getAccountNo);
		Assert.assertTrue(withdrawalPage.isCurrentBalanceWithdrawDisplay("40000"));
	}
	
	@Test
	public void TC_07_FundTransfer() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		fundTransferPage = homePage.clickToFundTransferPage();
		fundTransferPage.inputIntoPayersTextbox(getAccountNo);
		fundTransferPage.inputIntoPayeesTextbox("65848");
		fundTransferPage.inputIntoAmountTextbox("10000");
		fundTransferPage.inputIntpDesciptionTectbox("Transfer");
		fundTransferPage.clickToSubmitButton();
		
		Assert.assertTrue(fundTransferPage.isAmountDisplay("10000"));
	}
	
	@Test
	public void TC_08_BalanceEnquiry() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		balanceEnquiryPage = homePage.clickToBalanceEnquiryPage();
		balanceEnquiryPage.inputIntoAccountNoTextbox(getAccountNo);
		balanceEnquiryPage.clickToSubmitButton();
		
		Assert.assertEquals(balanceEnquiryPage.isBalanceDetailTextDisplay(),"Balance Details for Account" + " " + getAccountNo);
		Assert.assertTrue(balanceEnquiryPage.isBalanceNumberShow("30000"));
	}
	
	@Test
	public void TC_09_DeletePageAccount() {
		loginPage = registerPage.openLoginPageUrl(LoginPageUrl);
		loginPage.inputToUserIdTextbox(username);
		loginPage.inputPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		deleteAccountPage = homePage.clickToDeleteAccountPage();
		deleteAccountPage.inputIntoAccountNoTextbox(getAccountNo);
		deleteAccountPage.clickToSubmitButton();
		deleteAccountPage.acceptDeleteAccount1();
		Assert.assertTrue(deleteAccountPage.isDeleteAccountMessageDisplay("Account Deleted Sucessfully"));
		homePage = deleteAccountPage.acceptDeleteAccount2();
		
		editAccount = homePage.clickToEditAccount();
		editAccount.inputToAccountNo(getAccountNo);
		editAccount.clickToSubmitButton();
		Assert.assertTrue(editAccount.isDeleteAccountNotExistMessageDisplay("Account does not exist"));
		homePage = editAccount.acceptDeleteAccount3();
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
