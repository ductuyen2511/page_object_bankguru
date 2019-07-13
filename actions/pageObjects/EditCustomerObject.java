package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.EditCustomerUI;

public class EditCustomerObject extends abstractPage{
	WebDriver driver;
	
	public EditCustomerObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("driver HomePageObject: " + driver.toString());
	}

	public void transferTabKeyEditCustomer() {
		senkeyTab(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isEditCustomerEmptyMessage(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.CUSTOMER_INPUT_EMPTY_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void inputToCustomerIDTextbox(String value) {
		senkeyToElement(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX, value);
	}

	public boolean isEditCustomerInputCharMessage(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.CUSTOMER_INPUT_CHAR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void clearDataCustomerID() {
		clearDataInput(driver, EditCustomerUI.CUSTOMER_ID_TEXTBOX);
	}

	public boolean isEditCustomerInputSpecialCharMessage(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.CUSTOMER_INPUT_SPECIAL_CHAR_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerInputBlankSpaceMessage(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.CUSTOMER_INPUT_BLANK_SPACE_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerTextDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_TEXT_DISPLAY);
		return actualText.equals(expectedText);
	}

	public void clickToEditCustomerSubmitButton() {
		clickToElement(driver, EditCustomerUI.EDIT_CUSTOMER_SUBMIT_BUTTON);
	}

	public void clearDataInputAddressTextBox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_ADDRESS_TEXTBOX);
		
	}

	public void transferTabKeyEditAddress() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_ADDRESS_TEXTBOX);
		
	}

	public boolean isEditCustomerEmptyAddressDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_EMPTY_ADDRESS_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void clearDataInputCityTextBox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_CITY_TEXTBOX);
	}

	public void transferTabKeyEditCity() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_CITY_TEXTBOX);
	}

	public boolean isEditCustomerEmptyCityDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_EMPTY_CITY_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void InputToCityTextbox(String value) {
		senkeyToElement(driver, EditCustomerUI.EDIT_CUSTOMER_CITY_TEXTBOX, value);
	}

	public boolean isEditCustomerInputNumberCityDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_NUMBER_CITY_MESSAGE);
		return actualText.equals(expectedText);
	}
	public boolean isEditCustomerInputSpecialCharCityDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_CITY_MESSAGE);
		return actualText.equals(expectedText);
	}

	public void clearDataInputStateTextBox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_STATE_TEXTBOX);
	}

	public void transferTabKeyStateTextbox() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_STATE_TEXTBOX);
	}

	public boolean isEditCustomerEmptyStateDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_EMPTY_STATE_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void inputToStatetextbox(String value) {
		senkeyToElement(driver, EditCustomerUI.EDIT_CUSTOMER_STATE_TEXTBOX, value);
	}

	public boolean isEditCustomerInputNumberStateDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_NUMBER_STATE_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerInputSpecialCharStateDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_SPEACIAL_CHAR_STATE_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void clearDataInputPinTextBox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_PIN_TEXTBOX);
	}

	public void inputToPintextbox(String value) {
		senkeyToElement(driver,  EditCustomerUI.EDIT_CUSTOMER_PIN_TEXTBOX, value);
	}

	public boolean isEditCustomerInputCharPinDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_CHAR_PIN_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void transferTabKeyPinTextbox() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_PIN_TEXTBOX);
	}

	public boolean isEditCustomerInputEmptyPinDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_EMPTY_PIN_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerLessThan6DigitsPinDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_SIX_DIGITS_PIN_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public boolean isEditCustomerSpecialCharPinDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_PIN_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void clearDataInputTelephoneTextBox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_TELEPHONE_TEXTBOX);
	}

	public void transferTabKeyTelephoneTextbox() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_TELEPHONE_TEXTBOX);
	}

	public boolean isEditCustomerEmptyTelephoneDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_EMPTY_TELEPHONE_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void inputToTelephoneTextbox(String value) {
		senkeyToElement(driver, EditCustomerUI.EDIT_CUSTOMER_TELEPHONE_TEXTBOX, value);
	}

	public boolean isEditCustomerSpecialCharTelephoneDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_TELEPHONE_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void clearDataInputEmailTextbox() {
		clearDataInput(driver, EditCustomerUI.EDIT_CUSTOMER_EMAIL_TEXTBOX);
	}

	public void transferTabKeyEmailTextbox() {
		senkeyTab(driver, EditCustomerUI.EDIT_CUSTOMER_EMAIL_TEXTBOX);
	}

	public boolean isEditCustomerEmptyEmailDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_EMPTY_EMAIL_TEXTBOX);
		return actualText.equals(expectedText);
	}

	public void inputToEmailTextbox(String value) {
		senkeyToElement(driver, EditCustomerUI.EDIT_CUSTOMER_EMAIL_TEXTBOX, value);
		
	}

	public boolean isEditCustomerInputInvalidEmailDisplay(String expectedText) {
		String actualText = getTextElement(driver, EditCustomerUI.EDIT_CUSTOMER_INPUT_INVALID_EMAIL_TEXTBOX);
		return actualText.equals(expectedText);
	}
}
