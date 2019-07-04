package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends abstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("driver loginPageObject: " + driver.toString());
	}
	public String getLoginPageUrl() {
		// TODO Auto-generated method stub
		
		return getCurrentUrl(driver);
	}

	public void clickToHereLink() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputToUserIdTextbox(String username) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		clickToElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}

	public void inputPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		clickToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
