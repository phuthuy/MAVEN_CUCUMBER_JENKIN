package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	public HomePageObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}

	public boolean isHomePageDisplayed(String message) {
		// TODO Auto-generated method stub
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE,message);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE,message);
		
	}
}
