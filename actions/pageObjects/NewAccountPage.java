package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;

public class NewAccountPage extends abstractPage{
	WebDriver driver;
	
	
	public NewAccountPage(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
}
