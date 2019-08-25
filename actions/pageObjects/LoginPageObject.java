package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends abstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		//return new RegisterPageObject(driver);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public void inputToUserIdTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	public boolean IsLoginFormDisplay() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return isControlDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}
		
	public boolean isRegisterPageDisplay() {
		waitForElementVisible(driver, LoginPageUI.REGISTER_PAGE_PRESENT);
		return isControlDisplayed(driver, LoginPageUI.REGISTER_PAGE_PRESENT);
	}
	
	public boolean isRegisterPageUnDisplay() {
		waitForElementInvisible(driver, LoginPageUI.REGISTER_PAGE_PRESENT);
		return isControlUndisplayed(driver, LoginPageUI.REGISTER_PAGE_PRESENT);
	}
	
	public boolean isHomePageDisplay() {
		waitForElementVisible(driver, LoginPageUI.HOME_PAGE_PRESENT);
		return isControlDisplayed(driver, LoginPageUI.HOME_PAGE_PRESENT);
	}
	
	public boolean isHomePageUnDisplay() {
		waitForElementInvisible(driver, LoginPageUI.HOME_PAGE_PRESENT);
		return isControlUndisplayed(driver, LoginPageUI.HOME_PAGE_PRESENT);
	}
	
	public void clickToSeleniumDropdown() {
		waitForElementVisible(driver, LoginPageUI.SELENIUM_DROPDOWN);
		clickToElement(driver, LoginPageUI.SELENIUM_DROPDOWN);
	}
	public boolean IsAjaxDemoLinkDisplay() {
		waitForElementVisible(driver, LoginPageUI.AJAX_DEMO_LINK);
		return isControlDisplayed(driver, LoginPageUI.AJAX_DEMO_LINK);
	}
	
	public boolean IsAjaxDemoLinkUnDisplay() {
		waitForElementInvisible(driver, LoginPageUI.AJAX_DEMO_LINK);
		return isControlUndisplayed(driver, LoginPageUI.AJAX_DEMO_LINK);
	}

}
