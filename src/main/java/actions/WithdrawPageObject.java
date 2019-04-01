package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.HomePageUI;
import interfaces.WithdrawPageUI;

public class WithdrawPageObject extends AbstractPage {

	WebDriver driver;
	public WithdrawPageObject(WebDriver mappingDriver) {
		driver=mappingDriver;
	}
}
