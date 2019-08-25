package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends abstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public boolean isDisplayWelcomeMessage(String expectedText) {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE);
		String actualText = getTextElement(driver, HomePageUI.WELCOME_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isUserIdDisplay(String username) {
		waitForElementVisible(driver, HomePageUI.USER_ID_TEXT);
		String actualText = getTextElement(driver, HomePageUI.USER_ID_TEXT);
		return actualText.contains(username);
	}

	public RegisterPageObject newCustomerLink() {
		waitForElementVisible(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public EditCustomerObject clickToEditCustomer() {
		waitForElementVisible(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public NewAccountPageObject clickToNewAccountLink() {
		waitForElementVisible(driver, HomePageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.NEW_ACCOUNT_LINK);
		return PageGeneratorManager.getNewAccountPage(driver);
	}

	public EditAccountPageObject clickToEditAccount() {
		waitForElementVisible(driver, HomePageUI.EDIT_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.EDIT_ACCOUNT_LINK);
		return PageGeneratorManager.getEditNewAccount(driver);
	}

	public DepositPageObject clickToDepositPage() {
		waitForElementVisible(driver, HomePageUI.DEPOSIT_LINK);
		clickToElement(driver, HomePageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPageObject(driver);
	}

	public WithdrawalPageObject clickToWithdrawalLink() {
		waitForElementVisible(driver, HomePageUI.WITHDRAWAL_LINK);
		clickToElement(driver, HomePageUI.WITHDRAWAL_LINK);
		return PageGeneratorManager.getWithDrawalPage(driver);
	}

	public FundTransferPageObject clickToFundTransferPage() {
		waitForElementVisible(driver, HomePageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, HomePageUI.FUND_TRANSFER_LINK);
		return PageGeneratorManager.getFundTransferPage(driver);
	}

	public BalanceEnquiryPageObject clickToBalanceEnquiryPage() {
		waitForElementVisible(driver, HomePageUI.BALANCE_ENQUIRY_LINK);
		clickToElement(driver, HomePageUI.BALANCE_ENQUIRY_LINK);
		return PageGeneratorManager.getBalanceEnquiryPage(driver);
	}

	public DeleteAccountPageObject clickToDeleteAccountPage() {
		waitForElementVisible(driver, HomePageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.DELETE_ACCOUNT_LINK);
		return PageGeneratorManager.getDeleteAccountPage(driver);
	}

	public DeleteCustomerPageObject clickToDeleteCustomerPage() {
		waitForElementVisible(driver, HomePageUI.DELETE_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.DELETE_CUSTOMER_LINK);
		return PageGeneratorManager.getDeleteCustomerPage(driver);
	}

}
