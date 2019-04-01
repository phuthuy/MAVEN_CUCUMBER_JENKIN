package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.EditCustomerPageObject;
import actions.HomePageObject;
import actions.NewCustomerPageObject;
import actions.PageFactoryManager;
import actions.WithdrawPageObject;
import interfaces.AbstractPageUI;

public class AbstractPage {

	// Web Browser
	public void openAnyURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// Get Title
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// GetURL
	public String getCurrentPageURL(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// WEB ELEMENT
	public void clickToElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}

	// tinh da hinh
	public void clickToElement(WebDriver driver, String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
//		System.out.println(" ---- Click to dynamic  element : " + xpath+ "------");
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	public void sendkyToElement(WebDriver driver, String xpath, String inputValue) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(inputValue);
	}
	public void sendkyToElement(WebDriver driver, String xpath, String inputValue, String value) {
		xpath = String.format(xpath, inputValue);
		WebElement element = driver.findElement(By.xpath(xpath));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String xpath, String idDropdown, String item) {
		xpath = String.format(xpath,idDropdown);
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(item);
	}

	public void selectItemInDropdown(WebDriver driver, String xpath, String item) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(item);
	}

	public void selectItemInCustomDropdown(WebDriver driver, String dropdown, String listItems, String valueItems) {
		WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
		dropdownElement.click();
		List<WebElement> allItems = driver.findElements(By.xpath(listItems));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(valueItems)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				item.isDisplayed();
				item.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String xpath) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		return select.getFirstSelectedOption().getText();

	}

	public String getAttributeValue(WebDriver driver, String xpath, String attributeName) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getAttribute(attributeName);

	}

	public String getAttributeValue(WebDriver driver, String xpath, String attributeName, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getAttribute(attributeName);

	}

	public String getTextElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String xpath) {
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToCheckbox(WebDriver driver, String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(xpath));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String xpath, String... values) {
		xpath = String.format(xpath, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.isEnabled();
	}
	/* ------------------Windows------------------- */

	public void switchWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(windowID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIFrame(WebDriver driver, String xpath) {
		WebElement iframe = driver.findElement(By.xpath(xpath));
		driver.switchTo().frame(iframe);
	}

	/* ------------------Alert------------------- */
	public void acceptToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	/* ------------------Actions------------------- */
	public void hoverToElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	public void doubleClickToElement(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void pressKeyForElement(WebDriver driver, String xpath, Keys keyname) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.sendKeys(element, keyname);
	}

	/* ------------------UploadFile------------------- */
	public void uploadFile(WebDriver driver, String fileName) {
		String proDir = System.getProperty("user.dir");
		String filePath = proDir + "\\fileUpload\\" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(fileName);
	}

	public void uploadMultipleFileOneTime(WebDriver driver, String[] fileName) {
		String proDir = System.getProperty("user.dir");
		int i = fileName.length;
		String filePath = proDir + "\\fileUpload\\" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(fileName);
	}

	/* ------------------Wait------------------- */
	public void waitForControlVisible(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForControlVisible(WebDriver driver, String xpath, String... values) {
		xpath = String.format(xpath,  (Object[]) values);
		System.out.println(" ---- Wait to dynamic  element : " + xpath+ "------");
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public boolean waitForControlInvisible(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

	}

	public AbstractPage openDynamic(WebDriver driver, String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		switch (pageName) {
		case "New Customer":
			return new PageFactoryManager().openHomePage(driver);
		case "Withdrawal":
			return new PageFactoryManager().openWithdrawPage(driver);
		case "Edit Customer":
			return new PageFactoryManager().openEditPage(driver);
		default:
			return new PageFactoryManager().openHomePage(driver);
		}
	}

	/* BANK GURU PAGEs */
	public HomePageObject openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return new PageFactoryManager().openHomePage(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return new PageFactoryManager().openNewCustomerPage(driver);
	}

	public WithdrawPageObject openWithdrawPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		return new PageFactoryManager().openWithdrawPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return new PageFactoryManager().openEditPage(driver);
	}

	private int timeout = 30;
}
