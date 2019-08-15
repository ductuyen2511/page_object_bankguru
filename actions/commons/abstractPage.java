package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerObject;
import pageObjects.FundTransferPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawalPageObject;
import pageUIs.AbtractPageUI;

public class abstractPage {
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		System.out.println("driver : " + driver.toString());
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void getTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().getText();
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public void selectItemValue(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByValue(value);
	}

	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void SelectItemDropdown(WebDriver driver, String parentLocator, String allItemsDropdown, String expectedText) throws Exception {
		js = (JavascriptExecutor) driver;

		element = driver.findElement(By.xpath(parentLocator));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, longTime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsDropdown)));

		elements = driver.findElements(By.xpath(allItemsDropdown));
		System.out.println("All item = " + elements.size());

		for (WebElement childrenElement : elements) {
			System.out.println("Text moi lan get =" + childrenElement.getText());

			if (childrenElement.getText().contains(expectedText)) {
				if (childrenElement.isDisplayed()) {
					System.out.println("Click by Selenium =" + childrenElement.getText());
					childrenElement.click();
				} else {
					js.executeScript("arguments[0].scrollIntoView(true);", childrenElement);
					Thread.sleep(1000);
					System.out.println("Click by JS =" + childrenElement.getText());
					js.executeScript("arguments[0].click();", childrenElement);
				}
			}
		}
	}

	public String getAtributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		System.out.println("actual text :" + element.getText());
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchWindowById(WebDriver driver, String parent) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);

			String currentTitle = driver.getTitle();
			if (currentTitle.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowWithoutParent(WebDriver driver, String parent) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
		;
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void senkeyToElement(WebDriver driver, String locator, String key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void dragAndDrop(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.dragAndDrop(element, element).perform();
	}

	public void uploadFileSenkey(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void uploadMultiFileSenkey(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys("' + value + '");
	}

	public void uploadFileByAutoIt(WebDriver driver, String locator, String chromePath, String firefoxPath, String value) throws Exception {
		element = driver.findElement(By.xpath(locator));
		element.click();

		if (driver.toString().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { chromePath, value });
		} else {
			Runtime.getRuntime().exec(new String[] { firefoxPath, value });
		}
	}

	public void uploadFileByRobot(WebDriver driver, String locator, String value) throws Exception {
		element = driver.findElement(By.xpath(locator));
		element.click();

		StringSelection select = new StringSelection(value);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Object executeBrowser(WebDriver driver, String javascript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(javascript);
	}

	public boolean veryTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String textActual = (String) js.executeScript("return document.documentElement.innerText.match('" + textExpected + "')");
		return textActual.equals(textExpected);
	}

	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \\\"undefined\\\" && arguments[0].naturalWidth > 0", element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public Object clicktoElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}

	public Object scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Object senkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].setAttribute('value', '" + value + "');", element);
	}

	public Object scrollToBottomPage(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object removeAttributeInDom(WebDriver driver, WebElement element, String attributeRemove) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public Object highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].style.border='2px groove greeen'", element);
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		Date date = new Date();
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		
		overideTimeOutGlobal(driver, Constants.SHORT_TIME);
		System.out.println("Start time invisible :" + date.toString());
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		System.out.println("End time invisible :" + new Date().toString());
		overideTimeOutGlobal(driver, Constants.LONG_TIME);
	}

	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, longTime);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void senkeyTab(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(Keys.TAB);
	}

	public void clearDataInput(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public RegisterPageObject openNewCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbtractPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.DELETE_CUSTOMER_LINK);
		clickToElement(driver, AbtractPageUI.DELETE_CUSTOMER_LINK);
		return PageGeneratorManager.getDeleteCustomerPage(driver);
	}

	public EditCustomerObject openEditCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, AbtractPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}

	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbtractPageUI.NEW_ACCOUNT_LINK);
		return PageGeneratorManager.getNewAccountPage(driver);
	}

	public EditAccountPageObject openEditAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.EDIT_ACCOUNT_LINK);
		clickToElement(driver, AbtractPageUI.EDIT_ACCOUNT_LINK);
		return PageGeneratorManager.getEditNewAccount(driver);
	}

	public DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.DELETE_ACCOUNT_LINK);
		clickToElement(driver, AbtractPageUI.DELETE_ACCOUNT_LINK);
		return PageGeneratorManager.getDeleteAccountPage(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbtractPageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPageObject(driver);
	}

	public WithdrawalPageObject openWithDrawalPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.WITHDRAWAL_LINK);
		clickToElement(driver, AbtractPageUI.WITHDRAWAL_LINK);
		return PageGeneratorManager.getWithDrawalPage(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbtractPageUI.FUND_TRANSFER_LINK);
		return PageGeneratorManager.getFundTransferPage(driver);
	}

	public BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		waitForElementVisible(driver, AbtractPageUI.BALANCE_ENQUIRY_LINK);
		clickToElement(driver, AbtractPageUI.BALANCE_ENQUIRY_LINK);
		return PageGeneratorManager.getBalanceEnquiryPage(driver);
	}

	public abstractPage openPageLink(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbtractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbtractPageUI.DYNAMIC_LINK, pageName);

		if (pageName.equals("New Customer")) {
			return PageGeneratorManager.getRegisterPageObject(driver);
		} else if (pageName.equals("New Account")) {
			return PageGeneratorManager.getNewAccountPage(driver);
		} else if (pageName.equals("Deposit")) {
			return PageGeneratorManager.getDepositPageObject(driver);
		} else {
			return PageGeneratorManager.getHomePageObject(driver);
		}
	}

	public void openPageLinks(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbtractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbtractPageUI.DYNAMIC_LINK, pageName);
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("click to Locator :" + locator);
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Start Time :" + date.toString());
		overideTimeOutGlobal(driver, Constants.SHORT_TIME);
		elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			System.out.println("No Element not in DOM");
			System.out.println("End Time :" + new Date().toString());
			overideTimeOutGlobal(driver, Constants.LONG_TIME);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM, Not display");
			System.out.println("End Time :" + new Date().toString());
			overideTimeOutGlobal(driver, Constants.LONG_TIME);
			return true;
		} else {
			System.out.println("Element in DOM and display");
			overideTimeOutGlobal(driver, Constants.LONG_TIME);
			return false;
		}
	}
	
	
	public void overideTimeOutGlobal(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	WebDriverWait waitExplicit;
	WebElement element;
	List<WebElement> elements;
	Select select;
	Actions action;
	JavascriptExecutor js;
	By byLocator;
	long shortTime = 5;
	long longTime = 30;

}