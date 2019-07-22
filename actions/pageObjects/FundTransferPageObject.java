package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.abstractPage;

public class FundTransferPageObject extends abstractPage{
	WebDriver driver;
	
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
