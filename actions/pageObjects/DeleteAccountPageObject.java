package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.DeleteAccountPageUI;

public class DeleteAccountPageObject extends abstractPage{
	WebDriver driver;
	
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDeleteAccountMessageDisplay(String expectedText) {
		String actualText = getTextAlert(driver);
		return actualText.equals(expectedText);
	}

	public void acceptDeleteAccount1() {
		acceptAlert(driver);
	}

	public HomePageObject acceptDeleteAccount2() {
		acceptAlert(driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void inputIntoAccountNoTextbox(String value) {
		waitForElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, value);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, DeleteAccountPageUI.SUBMIT_BUTTON_DELETE_ACCOUNT);
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON_DELETE_ACCOUNT);
	}
}
