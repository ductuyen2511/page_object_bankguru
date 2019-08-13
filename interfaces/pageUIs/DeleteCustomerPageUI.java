package pageUIs;

public class DeleteCustomerPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name = 'cusid']";
	public static final String SUBMIT_BUTTON_DELETE_CUSTOMER = "//input[@name = 'AccSubmit']";
	public static final String INPUT_EMPTY_CUSTOMER_ID_MESSAGE = "//tbody//label[@id = 'message14' and text() = 'Customer ID is required']";
	public static final String INPUT_CHAR_CUSTOMER_ID_MESSAGE = "//tbody//label[@id = 'message14' and text() = 'Characters are not allowed']";
	public static final String INPUT_SPECIAL_CHAR_CUSTOMER_ID_MESSAGE = "//tbody//label[@id = 'message14' and text() = 'Special characters are not allowed']";
	public static final String INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_MESSAGE = "//tbody//label[@id = 'message14' and text() = 'First character can not have space']";
}
