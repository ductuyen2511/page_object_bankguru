package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends abstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("driver RegisterPageObject: " + driver.toString());
	}
	
	public void inputToEmailTextbox(String email) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.INPUT_EMAIL);
		senkeyToElement(driver, RegisterPageUI.INPUT_EMAIL, email);
	}

	public void clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUsernameInformation() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.GET_USER_ID_INFOR);
		return getTextElement(driver, RegisterPageUI.GET_USER_ID_INFOR);
	}

	public String getPasswordInformation() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, RegisterPageUI.GET_PASSWORD_INFOR);
		return getTextElement(driver, RegisterPageUI.GET_PASSWORD_INFOR);
	}

	public void openLoginPageUrl(String loginPageUrl) {
		// TODO Auto-generated method stub
		openUrl(driver, loginPageUrl);
	}

}
