package pageUIs;

public class NewAccountPageUI {
	public static final String CUSTOMER_ID_TEXTBOX = "//input[@name = 'cusid']";
	public static final String SELECT_ACCOUNT_TYPE = "//td//select[@name = 'selaccount']";
	public static final String INIT_DEPOSIT_TEXTBOX = "//input[@name='inideposit']";
	public static final String SUBMIT_BUTTION_NEW_ACCOUNT = "//input[@name='button2']";
	public static final String ACCOUNT_GENERATE_SUCCESSFULLY_TEXT = "//tbody//p[@class = 'heading3' and text() = 'Account Generated Successfully!!!']";
	public static final String CURRENT_AMOUNT = "//tbody//td[text() = 'Current Amount']/following-sibling::td";
	public static final String GET_ACCOUNT_NO_ID = "//tbody//td[text() = 'Account ID']/following-sibling::td";
	
	public static final String INPUT_EMPTY_CUSTOMER_ID_TEXTBOX = "//label[@id = 'message14' and text() = 'Customer ID is required']";
	public static final String INPUT_CHARACTER_CUSTOMER_ID_TEXTBOX = "//label[@id = 'message14' and text() = 'Characters are not allowed']";
	public static final String INPUT_SPECIAL_CHARACTER_CUSTOMER_ID_TEXTBOX = "//label[@id = 'message14' and text() = 'Special characters are not allowed']";
	public static final String INPUT_FIRST_BLANK_SPACE_CUSTOMER_ID_TEXTBOX = "//label[@id = 'message14' and text() = 'First character can not have space']";
	
	public static final String INPUT_EMPTY_DEPOSIT_TEXTBOX = "//label[@id = 'message19' and text() = 'Initial Deposit must not be blank']";
	public static final String INPUT_CHARACTER_DEPOSIT_TEXTBOX = "//label[@id = 'message19' and text() = 'Characters are not allowed']";
	public static final String INPUT_SPECIAL_CHARACTER_DEPOSIT_TEXTBOX = "//label[@id = 'message19' and text() = 'Special characters are not allowed']";
	public static final String INPUT_FIRST_BLANK_SPACE_DEPOSIT_TEXTBOX = "//label[@id = 'message19' and text() = 'First character can not have space']";
}
