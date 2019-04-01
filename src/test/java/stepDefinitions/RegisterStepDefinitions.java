package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.PageFactoryManager;
import actions.RegisterPageObject;
import commons.AbstractTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class RegisterStepDefinitions {
	WebDriver driver;
	static String userID, password, url;
	private RegisterPageObject registerPage;
	private AbstractTest abstractTest;

	public RegisterStepDefinitions() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManager.openRegisterPage(driver);
		abstractTest=new AbstractTest();
	}
	@When("^i input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email) {
		registerPage.inputEmailAdress(email + abstractTest.randomEmail());
		
	}
	@And("^I click to Submit button at Register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		registerPage.clickSubmitButton();
	}

	@Then("^I get UserID infor$")
	public void iGetUserIDInfor() {
		userID = registerPage.getUserIDText();
		password =registerPage.getPasswordText();
	}
	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
		registerPage.OpenLoginPageUrl(LoginStepDefinitions.url);
	}
}
