package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
 WebDriver driver;

public RegisterPageObject(WebDriver mapingDriver) {
	driver = mapingDriver;
}

public void inputEmailAdress(String email) {
	waitForControlVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
	sendkyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	
}

public void clickSubmitButton() {
	waitForControlVisible(driver, RegisterPageUI.LOGIN_BUTTON);
	clickToElement(driver, RegisterPageUI.LOGIN_BUTTON);
}

public String getUserIDText() {
	waitForControlVisible(driver, RegisterPageUI.USER_ID);
	return getTextElement(driver, RegisterPageUI.USER_ID);
}

public String getPasswordText() {
	waitForControlVisible(driver, RegisterPageUI.PASSWORD);
	return getTextElement(driver, RegisterPageUI.PASSWORD);
}

public void OpenLoginPageUrl(String url) {
	driver.get(url);
}

 
}
