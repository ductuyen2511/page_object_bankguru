package pageUIs;

public class RegisterPageUI {

	public static final String INPUT_EMAIL = "//input[@name = 'emailid']";
	public static final String SUBMIT_BUTTON = "//input[@name = 'btnLogin']";
	public static final String SUBMIT_BUTTON_NEW_CUSTOMER = "//input[@type = 'submit']";
	public static final String GET_USER_ID_INFOR = "//td[text() = 'User ID :']/following-sibling::td";
	public static final String GET_PASSWORD_INFOR = "//td[text() = 'Password :']/following-sibling::td";
	public static final String ADD_NEW_CUSTOMER_MESSAGE = "//p[@class = 'heading3' and text() = 'Add New Customer']";
	public static final String GENDER_TEXTBOX = "//input[@value = 'm']";
	public static final String DATEOFBIRTH_TEXTBOX = "//input[@name = 'dob']";
	public static final String CUSTOMER_MESSAGE_SUCCESSFULLY = "//tbody//p[@class = 'heading3' and text() = 'Customer Registered Successfully!!!']";
	public static final String EDIT_CUSTOMER_MESSAGE_SUCCESSFULLY = "//tbody//p[@class = 'heading3' and text() = 'Customer details updated Successfully!!!']";
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name = 'name']";
	public static final String CUSTOMER_NAME_MESSAGE_SHOW = "//tbody//label[@id = 'message' and text() = 'Customer name must not be blank']";
	public static final String CUSTOMER_NAME_NUMERIC_MESSAGE = "//tbody//label[@id = 'message' and text() = 'Numbers are not allowed']";
	public static final String CUSTOMER_NAME_SPECIAL_CHAR_MESSAGE = "//tbody//label[@id = 'message' and text() = 'Special characters are not allowed']";
	public static final String CUSTOMER_NAME_FIRSTCHAR_MESSAGE = "//tbody//label[@id = 'message' and text() = 'First character can not have space']";
	public static final String ADDRESS_TEXTBOX = "//textarea[@name ='addr']";
	public static final String ADDRESS_TEXTBOX_EMPTY_MESSAGE = "//textarea[@name ='addr']/following-sibling::label[@id = 'message3' and text() = 'Address Field must not be blank']";
	public static final String ADDRESS_TEXTBOX_SPACECHAR_MESSAGE = "//textarea[@name ='addr']/following-sibling::label[@id = 'message3' and text() = 'First character can not have space']";
	public static final String CITY_TEXTBOX = "//input[@name ='city']";
	public static final String CITY_EMPTY_MESSAGE = "//input[@name ='city']/following-sibling::label[@id = 'message4' and text() = 'City Field must not be blank']";
	public static final String CITY_INPUT_NUMER_MESSAGE = "//input[@name ='city']/following-sibling::label[@id = 'message4' and text() = 'Numbers are not allowed']";
	public static final String CITY_SPEACIAL_CHAR_MESSAGE = "//input[@name ='city']/following-sibling::label[@id = 'message4' and text() = 'Special characters are not allowed']";
	public static final String CITY_INPUT_SPACE_MESSAGE = "//input[@name ='city']/following-sibling::label[@id = 'message4' and text() = 'First character can not have space']";
	public static final String STATE_TEXTBOX = "//input[@name ='state']";
	public static final String STATE_INPUT_EMPTY_MESSAGE = "//input[@name ='state']/following-sibling::label[@id = 'message5' and text() = 'State must not be blank']";
	public static final String STATE_INPUT_NUMBER_MESSAGE = "//input[@name ='state']/following-sibling::label[@id = 'message5' and text() = 'Numbers are not allowed']";
	public static final String STATE_SPEACIAL_CHAR_MESSAGE = "//input[@name ='state']/following-sibling::label[@id = 'message5' and text() = 'Special characters are not allowed']";
	public static final String STATE_INPUT_SPACE_MESSAGE = "//input[@name ='state']/following-sibling::label[@id = 'message5' and text() = 'First character can not have space']";
	public static final String PIN_TEXTBOX = "//input[@name ='pinno']";
	public static final String PIN_INPUT_CHARACTER_PIN = "//input[@name ='pinno']/following-sibling::label[@id = 'message6' and text() = 'Characters are not allowed']";
	public static final String PIN_INPUT_EMPTY_MESSAGE = "//input[@name ='pinno']/following-sibling::label[@id = 'message6' and text() = 'PIN Code must not be blank']";
	public static final String PIN_INPUT_SIXDIGITS_MESSAGE = "//input[@name ='pinno']/following-sibling::label[@id = 'message6' and text() = 'PIN Code must have 6 Digits']";
	public static final String PIN_INPUT_SPECIAL_CHAR_MESSAGE = "//input[@name ='pinno']/following-sibling::label[@id = 'message6' and text() = 'Special characters are not allowed']";
	public static final String PIN_INPUT_BLANK_SPACE_MESSAGE = "//input[@name ='pinno']/following-sibling::label[@id = 'message6' and text() = 'First character can not have space']";
	public static final String TELEPHONE_TEXTBOX = "//input[@name = 'telephoneno']";
	public static final String TELEPHONE_TEXTBOX_EMPTY_MESSAGE = "//input[@name ='telephoneno']/following-sibling::label[@id = 'message7' and text() = 'Mobile no must not be blank']";
	public static final String TELEPHONE_INPUT_SPACE_MESSAGE = "//input[@name ='telephoneno']/following-sibling::label[@id = 'message7' and text() = 'First character can not have space']";
	public static final String TELEPHONE_INPUT_SPECIAL_CHAR_MESSAGE = "//input[@name ='telephoneno']/following-sibling::label[@id = 'message7' and text() = 'Special characters are not allowed']";
	public static final String EMAIL_TEXTBOX = "//input[@name ='emailid']";
	public static final String EMAIL_INPUT_EMPTY_MESSAGE = "//input[@name ='emailid']/following-sibling::label[@id = 'message9' and text() = 'Email-ID must not be blank']";
	public static final String EMAIL_INPUT_INVALID_MESSAGE = "//input[@name ='emailid']/following-sibling::label[@id = 'message9' and text() = 'Email-ID is not valid']";
	public static final String EMAIL_INPUT_BLANK_SPACE_MESSAGE = "//input[@name ='emailid']/following-sibling::label[@id = 'message9' and text() = 'First character can not have space']";
	public static final String PASSWORD_TEXTBOX = "//input[@name = 'password']";
	public static final String GET_TEXT_CUSTOMER_ID = "//table[@id = 'customer']//td[text() = 'Customer ID']/following-sibling::td";
	public static final String NEW_ACCOUNT_LINK = "//a[text() = 'New Account']";
	
}
