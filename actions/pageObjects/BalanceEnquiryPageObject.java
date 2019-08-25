package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.BalanceEnquiryPageUI;

public class BalanceEnquiryPageObject extends abstractPage{
	WebDriver driver;
	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputIntoAccountNoTextbox(String getAccountNo) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX, getAccountNo);
	}
	public void clickToSubmitButton() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON_BALANCE_ENQUIRY);
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON_BALANCE_ENQUIRY);
	}
	public String isBalanceDetailTextDisplay() {
		waitForElementVisible(driver, BalanceEnquiryPageUI.BALANCE_DETAIL_TEXT);
		return getTextElement(driver, BalanceEnquiryPageUI.BALANCE_DETAIL_TEXT);
	}
			
	public boolean isBalanceNumberShow(String expectedText) {
		waitForElementVisible(driver, BalanceEnquiryPageUI.BALANCE_NUMBER);
		String actualText = getTextElement(driver, BalanceEnquiryPageUI.BALANCE_NUMBER);
		return actualText.equals(expectedText);
	}
}
