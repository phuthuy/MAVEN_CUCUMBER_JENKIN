package actions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
