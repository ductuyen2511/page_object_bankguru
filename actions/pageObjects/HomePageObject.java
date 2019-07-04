package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends abstractPage {
	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("driver HomePageObject: " + driver.toString());
	}
	
	public boolean isDisplayWelcomeMessage(String expectedText) {
		// TODO Auto-generated method stub
		String actualText = getTextElement(driver, HomePageUI.WELCOME_MESSAGE);
		return actualText.equals(expectedText);
	}

	public boolean isUserIdDisplay(String username) {
		// TODO Auto-generated method stub
		String actualText = getTextElement(driver, HomePageUI.USER_ID_TEXT);
		return actualText.contains(username);
	}

}
