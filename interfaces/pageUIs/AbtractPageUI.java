package pageUIs;

public class AbtractPageUI {
	public static final String WELCOME_MESSAGE = "//marquee[@class = 'heading3']";
	public static final String USER_ID_TEXT = "//tr[@class = 'heading3']/child::td";
	public static final String NEW_CUSTOMER_LINK = "//a[text() = 'New Customer']";
	public static final String EDIT_CUSTOMER_LINK = "//a[text() ='Edit Customer']";
	public static final String NEW_ACCOUNT_LINK = "//a[text() = 'New Account']";
	public static final String EDIT_ACCOUNT_LINK = "//a[text() = 'Edit Account']";
	public static final String DEPOSIT_LINK = "//a[text() = 'Deposit']";
	public static final String WITHDRAWAL_LINK = "//a[text() = 'Withdrawal']";
	public static final String FUND_TRANSFER_LINK = "//a[text() = 'Fund Transfer']";
	public static final String BALANCE_ENQUIRY_LINK = "//a[text() = 'Balance Enquiry']";
	public static final String DELETE_ACCOUNT_LINK = "//a[text() = 'Delete Account']";
	public static final String DELETE_CUSTOMER_LINK = "//a[text() = 'Delete Customer']";
	
	public static final String DYNAMIC_LINK = "//a[text() = '%s']";
	
	public static final String DYNAMIC_INPUT_TEXTBOX = "//input[@name = '%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value = '%s']";
	public static final String DYNAMIC_INPUT_TEXT_AREA = "//textarea[@name = '%s']";
	public static final String DYNAMIC_SUBMIT_BUTTON = "//input[@value = '%s']";
	
	
	public static final String DYNAMIC_ERROR_MESSAGE = "//td[text() = '%s']/following-sibling::td//label";
	public static final String DYNAMIC_PAGE_LIVEGURU = "//ul[@id = 'nav']//span[text() = '%s']";
	
}
