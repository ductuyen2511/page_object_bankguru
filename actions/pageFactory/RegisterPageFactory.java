package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory {
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "emailid")
	private WebElement emailTextbox;
	
	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//td[text() = 'User ID :']/following-sibling::td")
	private WebElement userIDInfo;
	
	@FindBy(how = How.XPATH, using = "//td[text() = 'Password :']/following-sibling::td")
	private WebElement passwordInfo;
	
	public RegisterPageFactory(WebDriver localDriver){
		driver = localDriver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToEmailTextbox(String email) {
		emailTextbox.sendKeys(email);
	}

	public void clickToSubmitButton() {
		submitButton.click();
	}

	public String getUsernameInformation() {
		return userIDInfo.getText();
	}

	public String getPasswordInformation() {
		return passwordInfo.getText();
	}
	
	public void openLoginPageUrl(String loginPageUrl) {
		driver.get(loginPageUrl);
	}
}
