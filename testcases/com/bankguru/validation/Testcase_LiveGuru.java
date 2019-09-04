package com.bankguru.validation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.Account_LiveGuru;

import commons.PageGeneratorManager;
import commons.abstractTest;
import pageObjects.CustomerPageLiveGuruObject;
import pageObjects.LoginPageLiveGuruObject;
import pageObjects.OrderPageLiveGuruObject;

public class Testcase_LiveGuru extends abstractTest {
	WebDriver driver;
	LoginPageLiveGuruObject loginPage;
	CustomerPageLiveGuruObject customerPage;
	OrderPageLiveGuruObject orderPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = runMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPageLiveGuru(driver);
	}

	@Test
	public void TC_01_VerifyInvoiceCanBePrinted() {
		loginPage.inputIntoDynamicTextbox("login[username]", Account_LiveGuru.USERNAME);
		loginPage.inputIntoDynamicTextbox("login[password]", Account_LiveGuru.PASSWORD);
		customerPage = loginPage.clickToLoginButton();
		
		customerPage.clickToClosePopupButton();
		customerPage.hoverToDynamicPageLiveGuru("Sales");
		customerPage.openPageLinkLiveGuru(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPageLiveGuru(driver);
		orderPage.SelectDropdownAction("cancel_order");
		orderPage.clickToButtonOrderPage("Search");
		orderPage.clickToDynamicCheckbox("100010243");
		orderPage.SelectDropdownAction("pdfinvoices_order");
		orderPage.clickToButtonOrderPage("Submit");
		verifyTrue(orderPage.isMessagePrintableDocumentDisplayed("There are no printable documents related to selected orders."));
		
		orderPage.clickToDropdownStatus("complete");
		orderPage.clickToButtonOrderPage("Search");
		orderPage.clickToDynamicCheckbox("100000005");
		orderPage.SelectDropdownAction("pdfinvoices_order");
		orderPage.clickToButtonOrderPage("Submit");
		//orderPage.isFileDownloaded("C:\\Users\\Leon\\Downloads", fileName)
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
