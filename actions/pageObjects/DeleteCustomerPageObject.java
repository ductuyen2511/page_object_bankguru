package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.DeleteCustomerPageUI;

public class DeleteCustomerPageObject extends abstractPage{
	WebDriver driver;
	
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
		System.out.println("Driver DeleteCutomerPage " + driver.toString());
	}

	public void inputIntoCustomerIdTextbox(String getTextCustomerID) {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, getTextCustomerID);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, DeleteCustomerPageUI.SUBMIT_BUTTON_DELETE_CUSTOMER);
		clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON_DELETE_CUSTOMER);
	}

	public void acceptAlertDeleteCustomerId() {
		acceptAlert(driver);
	}

	public boolean isDeleteCustomerMessageDisplay(String expectedText) {
		String actualText = getTextAlert(driver);
		return actualText.equals(expectedText);
	}

	public HomePageObject acceptAlertDeleteCustomerSuccess() {
		acceptAlert(driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void transferTabkeyCustomerId() {
		waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyTab(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isEmptyCustomerIdMessageDisplay(String expectedText) {
		waitForElementVisible(driver, DeleteCustomerPageUI.INPUT_EMPTY_CUSTOMER_ID_MESSAGE);
		String actualText = getTextElement(driver, DeleteCustomerPageUI.INPUT_EMPTY_CUSTOMER_ID_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isCustomerIdInputCharMessageDisplay(String expectedText) {
		waitForElementVisible(driver, DeleteCustomerPageUI.INPUT_CHAR_CUSTOMER_ID_MESSAGE);
		String actualText = getTextElement(driver, DeleteCustomerPageUI.INPUT_CHAR_CUSTOMER_ID_MESSAGE);
		return actualText.equals(expectedText);	
	}

	public void clearDataCustomerIdTextbox() {
		clearDataInput(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isCustomerIdInputSpecialCharMessageDisplay(String expectedText) {
		waitForElementVisible(driver, DeleteCustomerPageUI.INPUT_SPECIAL_CHAR_CUSTOMER_ID_MESSAGE);
		String actualText = getTextElement(driver, DeleteCustomerPageUI.INPUT_SPECIAL_CHAR_CUSTOMER_ID_MESSAGE);
		return actualText.equals(expectedText);	
	}

	public boolean isCustomerIdInputFirstBlankSpaceMessageDisplay(String expectedText) {
		waitForElementVisible(driver, DeleteCustomerPageUI.INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_MESSAGE);
		String actualText = getTextElement(driver, DeleteCustomerPageUI.INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_MESSAGE);
		return actualText.equals(expectedText);	
	}
}
