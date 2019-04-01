package stepDefinitions;

import org.openqa.selenium.WebDriver;

import actions.HomePageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;

public class HomePageStepDefinitions {
	private WebDriver driver;
	private HomePageObject homePage;
	private AbstractTest abstractTest;

	public HomePageStepDefinitions() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.openHomePage(driver);
		abstractTest=new AbstractTest();
	}

	@Then("^Verify Home page display with message \"([^\"]*)\"$")
	public void verifyHomePageDisplay(String messageName) {
		abstractTest.verifyTrue(homePage.isHomePageDisplayed(messageName));
	}
}
