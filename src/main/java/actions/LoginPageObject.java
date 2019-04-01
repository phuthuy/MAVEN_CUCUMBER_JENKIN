package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
/* ACTION : 
 * - Get login page url
 * - Input username 
 * - Input pasword 
 * - Click SUBMIT 
 * - Click Here link . */

	public LoginPageObject(WebDriver mapingDriver) {
		driver = mapingDriver;
	}
	public String getLoginPageURL() {
		// TODO Auto-generated method stub
		return getCurrentPageURL(driver);
	}
	public void inputUsernameTextbox(String userName) {
		waitForControlVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendkyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userName);
	}
	public void inputPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public HomePageObject clickToLogingButton() {
		waitForControlVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.openHomePage(driver);
		
	}
public RegisterPageObject clickHereLinkToOpenRegisterPage() {
	waitForControlVisible(driver, LoginPageUI.HERE_LINK);
	clickToElement(driver, LoginPageUI.HERE_LINK);
	return PageFactoryManager.openRegisterPage(driver);
	
}
}
