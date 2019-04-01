package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class AbstractPageObject extends AbstractPage{
	WebDriver driver;

	public AbstractPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void inputToDynamicTextbox(String textboxID,String value ) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxID);
		sendkyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, textboxID, value);
	}

	public void inputToDynamicArea(String textboxID,String value ) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textboxID);
		sendkyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA, textboxID, value);
	}

	public void selectDynamicDropdownList(String dropdownID,String item) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownID);
		sendkyToElement(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownID, item);
	}

	public void clickDynamicRadioButton(String radioID) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioID);
	}
	public void clickDynamicButton(String buttonID) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonID);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonID);
	}
	public boolean isDynamicMessageDisplayed(String message) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MESSAGE, message);
		 return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MESSAGE, message);
	}
	public boolean isResult(String message) {
		waitForControlVisible(driver, AbstractPageUI.MESSAGE);
		return getTextElement(driver, AbstractPageUI.MESSAGE).equalsIgnoreCase(message);
	}
	public void clickDynamicPageLink (String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
	}
	public void sleepWithDynamicTime(String timeMinute) {
		long time=Long.parseLong(timeMinute);
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}