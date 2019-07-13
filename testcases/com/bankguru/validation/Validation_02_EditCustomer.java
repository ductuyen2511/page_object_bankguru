package com.bankguru.validation;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EditCustomerObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Validation_02_EditCustomer {
	WebDriver driver;
	String username, password;
	String customerName, gender, birthday, address, city, state, pin, mobileNo;
	String customerID;
	LoginPageObject loginPage;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	EditCustomerObject editCustomer;
	
	String email = "ductuyen" + randomEmail() + "@gmail.com";
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  
	  loginPage = new LoginPageObject(driver);
	  homePage = new HomePageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  editCustomer = new EditCustomerObject(driver);
	  
	  username = "mngr204852";
	  password = "UbUrYbe";
	  
	  customerName = "Tuyen Le";
	  birthday = "25/11/1992";
	  address = "123 Tao Dan";
	  city = "Ho Chi Minh";
	  state = "Sai Gon";
	  pin = "123456";
	  mobileNo = "0989484848";
  }
  
  @Test
  public void TC_01_CustomerCannotEmpty() {
	  driver.get("http://demo.guru99.com/v4/");
	  loginPage.inputToUserIdTextbox(username);
	  loginPage.inputPasswordTextbox(password);
	  loginPage.clickToLoginButton();
	  
	  
	  
	  //create new customer
	  homePage.newCustomerLink();
	  registerPage.inputToUserNameTextbox(customerName);
	  registerPage.inputToGenderTextbox();
	  registerPage.inputToDateOfBirth(birthday);
	  registerPage.inputToAddressTextbox(address);
	  registerPage.inputToCityTextbox(city);
	  registerPage.inputToStateTextbox(state);
	  registerPage.inputToPinTextbox(pin);
	  registerPage.inputToTelephoneTextbox(mobileNo);
	  registerPage.inputToEmailTextbox(email);
	  registerPage.inputToPasswordTextbox("123456789");
	  registerPage.clickToSubmitButtonNewCustomer();
	  
	  customerID = registerPage.getTextCustomerID();
	  
	  
	  homePage.clickToEditCustomer();
	  editCustomer.transferTabKeyEditCustomer();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyMessage("Customer ID is required"));
  }
  
  @Test
  public void TC_02_InputCharCustomerID() {
	  editCustomer.inputToCustomerIDTextbox("123abc");
	  Assert.assertTrue(editCustomer.isEditCustomerInputCharMessage("Characters are not allowed"));
  }
  
  @Test
  public void TC_03_InputSpecialCharCustomerID() {
	  editCustomer.clearDataCustomerID();
	  editCustomer.inputToCustomerIDTextbox("gwr!@#");
	  Assert.assertTrue(editCustomer.isEditCustomerInputSpecialCharMessage("Special characters are not allowed"));
  }
  
  @Test
  public void TC_04_InputValidCustomerID() {
	  editCustomer.clearDataCustomerID();
	  editCustomer.inputToCustomerIDTextbox(customerID);
	  editCustomer.clickToEditCustomerSubmitButton();
	  Assert.assertTrue(editCustomer.isEditCustomerTextDisplay("Edit Customer"));
  }
  
  @Test
  public void TC_08_TransferByTabKeyAddress() {
	  editCustomer.clearDataInputAddressTextBox();
	  editCustomer.transferTabKeyEditAddress();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyAddressDisplay("Address Field must not be blank"));
  }
  
  @Test
  public void TC_09_TransferByTabKeyCity() {
	  editCustomer.clearDataInputCityTextBox();
	  editCustomer.transferTabKeyEditCity();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyCityDisplay("City Field must not be blank"));
  }
  
  @Test
  public void TC_10_InputNumberCity() {
	  editCustomer.clearDataInputCityTextBox();
	  editCustomer.InputToCityTextbox("abc123");
	  Assert.assertTrue(editCustomer.isEditCustomerInputNumberCityDisplay("Numbers are not allowed"));
  }
  
  @Test
  public void TC_11_InputSpecialCharacterCity() {
	  editCustomer.clearDataInputCityTextBox();
	  editCustomer.InputToCityTextbox("abc!@#");
	  Assert.assertTrue(editCustomer.isEditCustomerInputSpecialCharCityDisplay("Special characters are not allowed"));
  }
  
  @Test
  public void TC_12_InputEmptyState() {
	  editCustomer.clearDataInputStateTextBox();
	  editCustomer.transferTabKeyStateTextbox();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyStateDisplay("State must not be blank"));
  }
  
  @Test
  public void TC_13_InputNumberState() {
	  editCustomer.inputToStatetextbox("abc123");
	  Assert.assertTrue(editCustomer.isEditCustomerInputNumberStateDisplay("Numbers are not allowed"));
  }
  
  @Test
  public void TC_14_InputSpecialCharacterState() {
	  editCustomer.clearDataInputStateTextBox();
	  editCustomer.inputToStatetextbox("abc!@#");
	  Assert.assertTrue(editCustomer.isEditCustomerInputSpecialCharStateDisplay("Special characters are not allowed"));
  }
  
  @Test
  public void TC_15_InputCharacterPin() {
	  editCustomer.clearDataInputPinTextBox();
	  editCustomer.inputToPintextbox("PIN123");
	  Assert.assertTrue(editCustomer.isEditCustomerInputCharPinDisplay("Characters are not allowed"));
  }
  
  @Test
  public void TC_16_InputEmptyPin() {
	  editCustomer.clearDataInputPinTextBox();
	  editCustomer.transferTabKeyPinTextbox();
	  Assert.assertTrue(editCustomer.isEditCustomerInputEmptyPinDisplay("PIN Code must not be blank"));
  }
  
  @Test
  public void TC_17_InputLessThen6DigitsPin() {
	  editCustomer.inputToPintextbox("12345");
	  Assert.assertTrue(editCustomer.isEditCustomerLessThan6DigitsPinDisplay("PIN Code must have 6 Digits"));
  }
  
  @Test
  public void TC_18_InputSpecialCharacterPin() {
	  editCustomer.clearDataInputPinTextBox();
	  editCustomer.inputToPintextbox("1234!@");
	  Assert.assertTrue(editCustomer.isEditCustomerSpecialCharPinDisplay("Special characters are not allowed"));
  }
  
  @Test
  public void TC_19_InputEmptyTelephone() {
	  editCustomer.clearDataInputTelephoneTextBox();
	  editCustomer.transferTabKeyTelephoneTextbox();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyTelephoneDisplay("Mobile no must not be blank"));
  }
  
  @Test
  public void TC_20_InputSpecialCharacterTelephone() {
	  editCustomer.inputToTelephoneTextbox("09094848!@");
	  Assert.assertTrue(editCustomer.isEditCustomerSpecialCharTelephoneDisplay("Special characters are not allowed"));
  }
  
  @Test
  public void TC_21_InputEmptyEmail() {
	  editCustomer.clearDataInputEmailTextbox();
	  editCustomer.transferTabKeyEmailTextbox();
	  Assert.assertTrue(editCustomer.isEditCustomerEmptyEmailDisplay("Email-ID must not be blank"));
  }
  
  @Test
  public void TC_22_InputInvalidEmail() {
	  editCustomer.inputToEmailTextbox("ductuyen@gmail");
	  Assert.assertTrue(editCustomer.isEditCustomerInputInvalidEmailDisplay("Email-ID is not valid"));
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
