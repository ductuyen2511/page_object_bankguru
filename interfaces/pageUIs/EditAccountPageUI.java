package pageUIs;

public class EditAccountPageUI {
	public static final String EDIT_ACCOUNT_LINK = "//a[text() = 'Edit Account']";
	public static final String ACCOUNT_NO_TEXTBOX = "//input [@name = 'accountno']";
	public static final String SUBMIT_BUTTON_EDIT_ACCOUNT = "//input [@name = 'AccSubmit']";
	public static final String SELECT_TYPE_ACCOUNT = "//tbody//select[@name = 'a_type']";
	public static final String ACCOUNT_TYPE_TEXT = "//table[@id ='account']//td[text() = 'Account Type']/following-sibling::td";
	public static final String EDIT_ACCOUNT_MESSAGE = "//table[@id ='account']//p[@class = 'heading3' and text() = 'Account details updated Successfully!!!']";
}
