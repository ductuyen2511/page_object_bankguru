package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends abstractPage{
	WebDriver driver;
	
	public NewAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("New account page onject" + driver.toString());
	}
	

	public void inputToCustomerIDTextbox(String value) {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, value);
	}

	public void inputToInitialDepostTextbox(String value) {
		waitForElementVisible(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX);
		senkeyToElement(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX, value);
	}

	public void clicktoSubmisButton() {
		waitForElementVisible(driver, NewAccountPageUI.SUBMIT_BUTTION_NEW_ACCOUNT);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTION_NEW_ACCOUNT);
	}

	public boolean isAccountGenerateMessageDisplay(String exptectedText) {
		waitForElementVisible(driver, NewAccountPageUI.ACCOUNT_GENERATE_SUCCESSFULLY_TEXT);
		String actualText = getTextElement(driver, NewAccountPageUI.ACCOUNT_GENERATE_SUCCESSFULLY_TEXT);
		return actualText.equals(exptectedText);
	}

	public boolean isCurrentAmountDisplay(String exptectedText) {
		waitForElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT);
		String actualText = getTextElement(driver, NewAccountPageUI.CURRENT_AMOUNT);
		return actualText.equals(exptectedText);
	}

	public String getTextAccountNo() {
		return getTextElement(driver, NewAccountPageUI.GET_ACCOUNT_NO_ID);
	}

	public void transferTabKeyCustomerIdTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyTab(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isInputEmptyCustomerIdMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_EMPTY_CUSTOMER_ID_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_EMPTY_CUSTOMER_ID_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isInputCharCustomerIdMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_CHARACTER_CUSTOMER_ID_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_CHARACTER_CUSTOMER_ID_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void clearDataInputCustomerIdTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		clearDataInput(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isInputSpecialCharCustomerIdMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_SPECIAL_CHARACTER_CUSTOMER_ID_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_SPECIAL_CHARACTER_CUSTOMER_ID_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isInputFirstBlankSpaceCustomerIdMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void transferTabKeyDepositTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX);
		senkeyTab(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX);
	}

	public boolean isInputEmptyDepositMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_EMPTY_DEPOSIT_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_EMPTY_DEPOSIT_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isInputCharacterDepositMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_CHARACTER_DEPOSIT_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_CHARACTER_DEPOSIT_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void clearDataInputDepositTextbox() {
		waitForElementVisible(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX);
		clearDataInput(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX);
	}

	public boolean isInputSpecialCharacterDepositMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_SPECIAL_CHARACTER_DEPOSIT_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_SPECIAL_CHARACTER_DEPOSIT_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isInputFirstBlankSpaceDepositMessageDisplay(String expectedText) {
		waitForElementVisible(driver, NewAccountPageUI.INPUT_FIRST_BLANK_SPACE_DEPOSIT_TEXTBOX);
		String actualText = getTextElement(driver, NewAccountPageUI.INPUT_FIRST_BLANK_SPACE_DEPOSIT_TEXTBOX);
		return actualText.equals(expectedText);
	}

}
