package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//marquee[@class = 'heading3']")
	private WebElement welcomeMessage;
	
	@FindBy(how = How.XPATH, using = "//tr[@class = 'heading3']/child::td")
	private WebElement userIDText;
	
	public HomePageFactory(WebDriver localDriver) {
		driver = localDriver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayWelcomeMessage(String expectedText) {
		String actualText = welcomeMessage.getText().trim();
		return actualText.equals(expectedText);
	}

	public boolean isUserIdDisplay(String userID) {
		String actualText = userIDText.getText().trim();
		return actualText.contains(userID);
	}

}
