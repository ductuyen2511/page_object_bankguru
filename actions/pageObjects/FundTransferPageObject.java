package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.FundTransferPageUI;

public class FundTransferPageObject extends abstractPage{
	WebDriver driver;
	
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputIntoPayersTextbox(String getAccountNo) {
		waitForElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_TEXTBOX);
		senkeyToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_TEXTBOX, getAccountNo);
	}

	public void inputIntoPayeesTextbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_TEXTBOX);
		senkeyToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_TEXTBOX, value);
	}

	public void inputIntoAmountTextbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, value);
	}

	public void inputIntpDesciptionTectbox(String value) {
		waitForElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
		senkeyToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, value);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, FundTransferPageUI.SUBMIT_BUTTON_FUND_TRANSFER);
		clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON_FUND_TRANSFER);
	}

	public boolean isAmountDisplay(String expectedText) {
		waitForElementVisible(driver, FundTransferPageUI.NUMBER_AMMOUNT_TEXT);
		String actualText = getTextElement(driver, FundTransferPageUI.NUMBER_AMMOUNT_TEXT);
		return actualText.equals(expectedText);
	}
}
