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
		senkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, value);
	}

	public void inputToInitialDepostTextbox(String value) {
		senkeyToElement(driver, NewAccountPageUI.INIT_DEPOSIT_TEXTBOX, value);
	}

	public void clicktoSubmisButton() {
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
}
