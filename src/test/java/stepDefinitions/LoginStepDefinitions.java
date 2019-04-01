package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.LoginPageObject;
import actions.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class LoginStepDefinitions  {
	WebDriver driver;
	static String userID, password, url;
	private LoginPageObject loginPage;

	public LoginStepDefinitions() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.openLoginPage(driver);
	}
	@Given("^I get Login Url$")
	public void iGetLoginUrl() {
		url = loginPage.getLoginPageURL();
	}
	@When("^i click to here link$")
	public void iClickToHereLink() {
		loginPage.clickHereLinkToOpenRegisterPage();
	}
	@When("^I input to Username textbox$")
	public void iInputToUsername() {
		loginPage.inputUsernameTextbox(RegisterStepDefinitions.userID);

	}

	@When("^I input to Password textbox$")
	public void iInputToPassword() {
		loginPage.inputPasswordTextbox(RegisterStepDefinitions.password);

	}

	@When("^I click to Login button at Login Page$")
	public void iClickToLoginButton() {
		loginPage.clickToLogingButton();

	}

}
