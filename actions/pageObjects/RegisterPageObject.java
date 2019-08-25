package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.abstractPage;
import pageUIs.AbtractPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends abstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_EMAIL);
		senkeyToElement(driver, RegisterPageUI.INPUT_EMAIL, email);
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUsernameInformation() {
		waitForElementVisible(driver, RegisterPageUI.GET_USER_ID_INFOR);
		return getTextElement(driver, RegisterPageUI.GET_USER_ID_INFOR);
	}

	public String getPasswordInformation() {
		waitForElementVisible(driver, RegisterPageUI.GET_PASSWORD_INFOR);
		return getTextElement(driver, RegisterPageUI.GET_PASSWORD_INFOR);
	}

	public LoginPageObject openLoginPageUrl(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	public boolean isAddNewCustomerMessage(String expectedTex) {
		waitForElementVisible(driver, RegisterPageUI.ADD_NEW_CUSTOMER_MESSAGE);
		String actualText = getTextElement(driver, RegisterPageUI.ADD_NEW_CUSTOMER_MESSAGE);
		return actualText.equals(expectedTex);
	}

	public void inputToUserNameTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.CUSTOMER_NAME_TEXTBOX, value);
	}

	public void transerTabKey() {
		senkeyTab(driver, RegisterPageUI.CUSTOMER_NAME_TEXTBOX);
	}

	public boolean isCustomerNameMessageDisplay(String exptectedText) {
		waitForElementVisible(driver, RegisterPageUI.CUSTOMER_NAME_MESSAGE_SHOW);
		String actualText = getTextElement(driver, RegisterPageUI.CUSTOMER_NAME_MESSAGE_SHOW);
		return actualText.equals(exptectedText);
	}

	public boolean isCustomerNumericMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CUSTOMER_NAME_NUMERIC_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isCustomerSpecialCharacterMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CUSTOMER_NAME_SPECIAL_CHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataInputCustomerName() {
		clearDataInput(driver, RegisterPageUI.CUSTOMER_NAME_TEXTBOX);
	}

	public boolean isCustomerSpaceCharMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CUSTOMER_NAME_FIRSTCHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void transerTabKeyAddress() {
		senkeyTab(driver, RegisterPageUI.ADDRESS_TEXTBOX);
	}

	public boolean isAddressEmptyMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.ADDRESS_TEXTBOX_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToAddressTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.ADDRESS_TEXTBOX, value);
	}

	public boolean isAddressSpaceCharMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.ADDRESS_TEXTBOX_SPACECHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void refreshRegisterPage() {
		refreshToPage(driver);
	}

	public void transferTabKeyCity() {
		senkeyTab(driver, RegisterPageUI.CITY_TEXTBOX);
	}

	public boolean isCityEmptyMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CITY_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToCityTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.CITY_TEXTBOX, value);
	}

	public boolean isCitySpecialCharMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CITY_SPEACIAL_CHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isCityNumberMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CITY_INPUT_NUMER_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataInputCity() {
		clearDataInput(driver, RegisterPageUI.CITY_TEXTBOX);
	}

	public boolean isCitySpaceMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.CITY_INPUT_SPACE_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void transferTabKeyState() {
		senkeyTab(driver, RegisterPageUI.STATE_TEXTBOX);
	}

	public boolean isStateEmptyMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.STATE_INPUT_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToStateTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.STATE_TEXTBOX, value);
	}

	public boolean isStateNumberMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.STATE_INPUT_NUMBER_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isStateSpacialCharMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.STATE_SPEACIAL_CHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataInputState() {
		clearDataInput(driver, RegisterPageUI.STATE_TEXTBOX);
	}

	public boolean isStateSpaceMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.STATE_INPUT_SPACE_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToPinTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.PIN_TEXTBOX, value);
	}

	public boolean isPinCharacterMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.PIN_INPUT_CHARACTER_PIN);
		return actualText.equals(exptectedText);
	}

	public void transferTabKeyPin() {
		senkeyTab(driver, RegisterPageUI.PIN_TEXTBOX);
	}

	public boolean isPinEmptyMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.PIN_INPUT_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isPinSixDigitsMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.PIN_INPUT_SIXDIGITS_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isPinSpecialCharacterMessageDisplay(String exptectedText) {
		waitForElementVisible(driver, RegisterPageUI.PIN_INPUT_SPECIAL_CHAR_MESSAGE);
		String actualText = getTextElement(driver, RegisterPageUI.PIN_INPUT_SPECIAL_CHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataInputPin() {
		clearDataInput(driver, RegisterPageUI.PIN_TEXTBOX);
	}

	public boolean isPinBlankSpaceMessageDisplay(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.PIN_INPUT_BLANK_SPACE_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void transferTabKeyTelephone() {
		senkeyTab(driver, RegisterPageUI.TELEPHONE_TEXTBOX);
	}

	public boolean isTelephoneEmptyMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.TELEPHONE_TEXTBOX_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToTelephoneTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.TELEPHONE_TEXTBOX, value);
	}

	public boolean isTelephoneBlankSpaceMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.TELEPHONE_INPUT_SPACE_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataInputTelephone() {
		clearDataInput(driver, RegisterPageUI.TELEPHONE_TEXTBOX);
	}

	public boolean isTelephoneSpecialCharacterMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.TELEPHONE_INPUT_SPECIAL_CHAR_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void transferTabKeyEmail() {
		senkeyTab(driver, RegisterPageUI.EMAIL_TEXTBOX);
	}

	public boolean isEmailEmptyMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.EMAIL_INPUT_EMPTY_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public boolean isEmailInvalidMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.EMAIL_INPUT_INVALID_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void clearDataEmail() {
		clearDataInput(driver, RegisterPageUI.INPUT_EMAIL);
	}

	public boolean isEmailBlankSpaceMessage(String exptectedText) {
		String actualText = getTextElement(driver, RegisterPageUI.EMAIL_INPUT_BLANK_SPACE_MESSAGE);
		return actualText.equals(exptectedText);
	}

	public void inputToGenderTextbox() {
		clickToElement(driver, RegisterPageUI.GENDER_TEXTBOX);
	}

	public void inputToDateOfBirth(String value) {
		senkeyToElement(driver, RegisterPageUI.DATEOFBIRTH_TEXTBOX, value);
	}

	public void inputToPasswordTextbox(String value) {
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, value);
	}

	public String getTextCustomerID() {
		return getTextElement(driver, RegisterPageUI.GET_TEXT_CUSTOMER_ID);
	}

	public void clickToSubmitButtonNewCustomer() {
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON_NEW_CUSTOMER);
	}

	public boolean isCustomerRegisterSuccessfullyMessageDisplay(String expectedText) {
		waitForElementVisible(driver, RegisterPageUI.CUSTOMER_MESSAGE_SUCCESSFULLY);
		String actualText = getTextElement(driver, RegisterPageUI.CUSTOMER_MESSAGE_SUCCESSFULLY);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerRegisterSuccessfullyMessageDisplay(String expectedText) {
		waitForElementVisible(driver, RegisterPageUI.EDIT_CUSTOMER_MESSAGE_SUCCESSFULLY);
		String actualText = getTextElement(driver, RegisterPageUI.EDIT_CUSTOMER_MESSAGE_SUCCESSFULLY);
		return actualText.equals(expectedText);
	}

	public void inputToDynamicTextbox(String nameID, String value) {
		waitForElementVisible(driver, AbtractPageUI.DYNAMIC_INPUT_TEXTBOX, nameID);
		senkeyToDynamicElement(driver, AbtractPageUI.DYNAMIC_INPUT_TEXTBOX, value, nameID);
	}

	public void inputTpDynamicTextarea(String textArea, String value) {
		waitForElementVisible(driver, AbtractPageUI.DYNAMIC_INPUT_TEXT_AREA, textArea);
		senkeyToDynamicElement(driver, AbtractPageUI.DYNAMIC_INPUT_TEXT_AREA, textArea, value);
	}

	public void pressTabKeyToDynamicElement(String value) {
		senkeyBoardToDynamicElement(driver, AbtractPageUI.DYNAMIC_INPUT_TEXTBOX, Keys.TAB, value);	
	}

	public boolean getErrorMessage(String value, String expectedText) {
		waitForElementVisible(driver, AbtractPageUI.DYNAMIC_ERROR_MESSAGE, value);
		String actualText = getTextDynamicElement(driver, AbtractPageUI.DYNAMIC_ERROR_MESSAGE, value);
		return actualText.equals(expectedText);
	}

}
