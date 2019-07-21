package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;

public class DepositPageObject extends abstractPage{
	WebDriver driver;
	
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
