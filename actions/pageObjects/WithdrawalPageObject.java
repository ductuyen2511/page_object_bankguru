package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.WithdrawalPageUI;

public class WithdrawalPageObject extends abstractPage{
	WebDriver driver;
	
	public WithdrawalPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAccountNoTextbox(String getAccountNo) {
		waitForElementVisible(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX, getAccountNo);
	}

	public void inputIntoAmountTextbox(String value) {
		waitForElementVisible(driver, WithdrawalPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, WithdrawalPageUI.AMOUNT_TEXTBOX, value);
	}

	public void inputIntoDescriptionTextbox(String value) {
		waitForElementVisible(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX, value);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, WithdrawalPageUI.BUTTON_SUBMIT);
		clickToElement(driver, WithdrawalPageUI.BUTTON_SUBMIT);
	}

	public String isTransactionOfWithdrawMessageDisplay() {
		waitForElementVisible(driver, WithdrawalPageUI.TRANSACTION_OF_WITHDRAW_MESSAGE);
		return getTextElement(driver, WithdrawalPageUI.TRANSACTION_OF_WITHDRAW_MESSAGE);
	}

	public boolean isCurrentBalanceWithdrawDisplay(String expectedText) {
		waitForElementVisible(driver, WithdrawalPageUI.CURRENT_BALANCE_TEXT_WITHDRAW);
		String actualText = getTextElement(driver, WithdrawalPageUI.CURRENT_BALANCE_TEXT_WITHDRAW);
		return actualText.equals(expectedText);
	}
}
