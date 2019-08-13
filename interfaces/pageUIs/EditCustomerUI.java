package pageUIs;

public class EditCustomerUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name = 'cusid']";
	public static final String CUSTOMER_INPUT_EMPTY_MESSAGE = "//input[@name = 'cusid']/following-sibling::label[@id = 'message14' and text() = 'Customer ID is required']";
	public static final String CUSTOMER_INPUT_CHAR_MESSAGE = "//input[@name = 'cusid']/following-sibling::label[@id = 'message14' and text() = 'Characters are not allowed']";
	public static final String CUSTOMER_INPUT_SPECIAL_CHAR_MESSAGE = "//input[@name = 'cusid']/following-sibling::label[@id = 'message14' and text() = 'Special characters are not allowed']";
	public static final String CUSTOMER_INPUT_BLANK_SPACE_MESSAGE = "//input[@name = 'cusid']/following-sibling::label[@id = 'message14' and text() = 'First character can not have space']";
	public static final String EDIT_CUSTOMER_TEXT_DISPLAY = "//p[@class = 'heading3' and text() = 'Edit Customer']";
	public static final String EDIT_CUSTOMER_SUBMIT_BUTTON = "//input[@name = 'AccSubmit']";
	public static final String EDIT_SUBMIT_BUTTON = "//input[@type ='submit']";
	public static final String EDIT_CUSTOMER_ADDRESS_TEXTBOX = "//textarea[@name = 'addr']";
	public static final String EDIT_CUSTOMER_EMPTY_ADDRESS_MESSAGE = "//textarea[@name = 'addr']/following-sibling::label[@id = 'message3' and text() = 'Address Field must not be blank']";
	public static final String EDIT_CUSTOMER_CITY_TEXTBOX = "//input[@name ='city']";
	public static final String EDIT_CUSTOMER_EMPTY_CITY_MESSAGE = "//input[@name = 'city']/following-sibling::label[@id = 'message4' and text() = 'City Field must not be blank']";
	public static final String EDIT_CUSTOMER_INPUT_NUMBER_CITY_MESSAGE = "//input[@name = 'city']/following-sibling::label[@id = 'message4' and text() = 'Numbers are not allowed']";
	public static final String EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_CITY_MESSAGE = "//input[@name = 'city']/following-sibling::label[@id = 'message4' and text() = 'Special characters are not allowed']";
	public static final String EDIT_CUSTOMER_STATE_TEXTBOX = "//input[@name ='state']";
	public static final String EDIT_CUSTOMER_EMPTY_STATE_TEXTBOX = "//input[@name = 'state']/following-sibling::label[@id = 'message5' and text() = 'State must not be blank']";
	public static final String EDIT_CUSTOMER_INPUT_NUMBER_STATE_TEXTBOX = "//input[@name = 'state']/following-sibling::label[@id = 'message5' and text() = 'Numbers are not allowed']";
	public static final String EDIT_CUSTOMER_INPUT_SPEACIAL_CHAR_STATE_TEXTBOX = "//input[@name = 'state']/following-sibling::label[@id = 'message5' and text() = 'Special characters are not allowed']";
	public static final String EDIT_CUSTOMER_PIN_TEXTBOX = "//input[@name ='pinno']";
	public static final String EDIT_CUSTOMER_INPUT_CHAR_PIN_TEXTBOX = "//input[@name = 'pinno']/following-sibling::label[@id = 'message6' and text() = 'Characters are not allowed']";
	public static final String EDIT_CUSTOMER_INPUT_EMPTY_PIN_TEXTBOX = "//input[@name = 'pinno']/following-sibling::label[@id = 'message6' and text() = 'PIN Code must not be blank']";
	public static final String EDIT_CUSTOMER_INPUT_SIX_DIGITS_PIN_TEXTBOX = "//input[@name = 'pinno']/following-sibling::label[@id = 'message6' and text() = 'PIN Code must have 6 Digits']";
	public static final String EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_PIN_TEXTBOX = "//input[@name = 'pinno']/following-sibling::label[@id = 'message6' and text() = 'Special characters are not allowed']";
	public static final String EDIT_CUSTOMER_TELEPHONE_TEXTBOX = "//input[@name = 'telephoneno']";
	public static final String EDIT_CUSTOMER_INPUT_EMPTY_TELEPHONE_TEXTBOX = "//input[@name = 'telephoneno']/following-sibling::label[@id = 'message7' and text() = 'Mobile no must not be blank']";
	public static final String EDIT_CUSTOMER_INPUT_SPECIAL_CHAR_TELEPHONE_TEXTBOX = "//input[@name = 'telephoneno']/following-sibling::label[@id = 'message7' and text() = 'Special characters are not allowed']";
	public static final String EDIT_CUSTOMER_EMAIL_TEXTBOX = "//input[@name ='emailid']";
	public static final String EDIT_CUSTOMER_INPUT_EMPTY_EMAIL_TEXTBOX = "//input[@name = 'emailid']/following-sibling::label[@id = 'message9' and text() = 'Email-ID must not be blank']";
	public static final String EDIT_CUSTOMER_INPUT_INVALID_EMAIL_TEXTBOX = "//input[@name = 'emailid']/following-sibling::label[@id = 'message9' and text() = 'Email-ID is not valid']";
}
