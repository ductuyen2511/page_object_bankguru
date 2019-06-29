package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractPage {
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
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
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}
	
	
	public String getSelectItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void SelectItemDropdown(WebDriver driver, String parentLocator, String allItemsDropdown, String expectedText) throws Exception {
		js = (JavascriptExecutor) driver;
		
		WebElement parentElement = driver.findElement(By.xpath(parentLocator));
		js.executeScript("arguments[0].click();", parentElement);
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, longTime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsDropdown)));
		
		List<WebElement> allElement = driver.findElements(By.xpath(allItemsDropdown));
		System.out.println("All item = " + allElement.size());

		for(WebElement childrenElement : allElement) {
			System.out.println("Text moi lan get =" + childrenElement.getText());
			
			if(childrenElement.getText().contains(expectedText)) {
				if(childrenElement.isDisplayed()) {
					System.out.println("Click by Selenium =" + childrenElement.getText());
					childrenElement.click();
				}else {
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
		return element.getText();
	}
	
	public int countElementNumber(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return elements.size();
	}
	
	public void checkTheCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
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
			if(currentTitle.equals(title)) {
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
		action.doubleClick(element).perform();;
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
	
	public void uploadFileByAutoIt(WebDriver driver, String locator,String chromePath, String firefoxPath, String value) throws Exception {
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
		String textActual = (String)js.executeScript("return document.documentElement.innerText.match('" + textExpected + "')");
		 return textActual.equals(textExpected);
	}
	
	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean status = (boolean)js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \\\"undefined\\\" && arguments[0].naturalWidth > 0", element);
		if(status) {
			return true;
		}else {
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
		waitExplicit = new WebDriverWait(driver, longTime);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, longTime);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
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