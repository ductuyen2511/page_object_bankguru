package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.EditAccountPageUI;

public class EditAccountPageObject extends abstractPage{
	WebDriver driver;
	
	public EditAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAccountNo(String value) {
		senkeyToElement(driver, EditAccountPageUI.ACCOUNT_NO_TEXTBOX, value);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, EditAccountPageUI.SUBMIT_BUTTON_EDIT_ACCOUNT);
		clickToElement(driver, EditAccountPageUI.SUBMIT_BUTTON_EDIT_ACCOUNT);
	}

	public void selectItemTypeAccount(String value) {
		waitForElementVisible(driver, EditAccountPageUI.SELECT_TYPE_ACCOUNT);
		selectItemValue(driver, EditAccountPageUI.SELECT_TYPE_ACCOUNT, value);
	}

	public boolean isEditAccountGenerateMessageDisplay(String expectedText) {
		waitForElementVisible(driver, EditAccountPageUI.EDIT_ACCOUNT_MESSAGE);
		String actualText = getTextElement(driver, EditAccountPageUI.EDIT_ACCOUNT_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isTypeAccountDisplay(String expectedText) {
		waitForElementVisible(driver, EditAccountPageUI.ACCOUNT_TYPE_TEXT);
		String actualText = getTextElement(driver, EditAccountPageUI.ACCOUNT_TYPE_TEXT);
		return actualText.equals(expectedText);
	}

	public boolean isDeleteAccountNotExistMessageDisplay(String expectedText) {
		String actualText = getTextAlert(driver);
		return actualText.equals(expectedText);
	}

	public HomePageObject acceptDeleteAccount3() {
		acceptAlert(driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
