package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.DepositPageUI;

public class DepositPageObject extends abstractPage{
	WebDriver driver;
	
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputIntoAccountNoTextbox(String getAccountNo) {
		waitForElementVisible(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX, getAccountNo);
	}

	public void inputIntAmountTextbox(String value) {
		waitForElementVisible(driver, DepositPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.AMOUNT_TEXTBOX, value);
	}

	public void inputIntoDescriptionTextbox(String value) {
		waitForElementVisible(driver, DepositPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.DESCRIPTION_TEXTBOX, value);
	}

	public void clickToSubmitButtonDeposit() {
		waitForElementVisible(driver, DepositPageUI.SUBMIT_BUTTON_DEPOSIT);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON_DEPOSIT);
	}

	public boolean isCurrentBalanceDisplay(String expectedText) {
		waitForElementVisible(driver, DepositPageUI.CURRENT_BALANCE_TEXT);
		String actualText = getTextElement(driver, DepositPageUI.CURRENT_BALANCE_TEXT);
		return actualText.equals(expectedText);
	}

	public String isTransactionOfDepositMessageDisplay() {
		waitForElementVisible(driver, DepositPageUI.TRANSACTION_OF_ACCOUNT_TEXT);
		return getTextElement(driver, DepositPageUI.TRANSACTION_OF_ACCOUNT_TEXT);
	}
}
