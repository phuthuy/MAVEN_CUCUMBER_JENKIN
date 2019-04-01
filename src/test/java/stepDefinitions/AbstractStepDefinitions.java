package stepDefinitions;

import org.openqa.selenium.WebDriver;

import actions.AbstractPageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class AbstractStepDefinitions {
	private WebDriver driver;
	private AbstractPageObject abstractPage;
	private AbstractTest abstractTest;

	public AbstractStepDefinitions() {
		driver = Hooks.openBrowser();
		abstractPage = PageFactoryManager.openAbstractPage(driver);
		abstractTest = new AbstractTest();
	}

	@When("^I input to \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
	public void iInputToDynamicTextboxWithDynamicData(String textboxID, String value) {
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}

	@When("^I input to \"([^\"]*)\" textbox with random data \"([^\"]*)\"$")
	public void iInputToDynamicTextboxWithDynamicRandomData(String textboxID, String value) {
		value = value + " " + abstractTest.randomNumber();
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}

	@When("^I input to \"([^\"]*)\" textbox with \"([^\"]*)\" data \"([^\"]*)\"$")
	public void iInputToDynamicTextboxWithRandomData(String textboxID, String statusRandom, String value) {
		if (statusRandom.equals("1")) {
			value = value + " " + abstractTest.randomNumber();
		}
		if (statusRandom.equals("2")) {
			value = value + abstractTest.randomEmail();
		}
		abstractPage.inputToDynamicTextbox(textboxID, value);
	}

	@When("^I input to \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
	public void iInputToDynamicTextAreaWithDynamicData(String textboxID, String value) {
		abstractPage.inputToDynamicArea(textboxID, value);
	}

	@When("^I select item in \"([^\"]*)\" dropdown with data \"([^\"]*)\"$")
	public void iSelectToDynamicDropdownListWithDynamicData(String dropdownID, String value) {
		abstractPage.selectDynamicDropdownList(dropdownID, value);
	}

	@When("^I select \"([^\"]*)\" radio button$")
	public void iSelectToDynamicRadioButtontWithDynamicData(String radioButtonID) {
		abstractPage.clickDynamicRadioButton(radioButtonID);
	}

	@When("^I click to \"([^\"]*)\" button$")
	public void iClickToDynamicButton(String buttonID) {
		abstractPage.clickDynamicButton(buttonID);
	}

	@When("^verify message \"([^\"]*)\" displayed success$")
	public void verifyDynamicMessageDisplayed(String message) {
		abstractTest.verifyTrue(abstractPage.isResult(message));
	}

	@When("^I open \"([^\"]*)\" page$")
	public void iOpenDynamicPage(String pageName) {
		abstractPage.clickDynamicPageLink(pageName);
	}

	@When("^I sleep with \"([^\"]*)\" times$")
	public void iSleepDynamicTime(String timeMinute) {
		abstractPage.sleepWithDynamicTime(timeMinute);
	}

	@When("^I input (first|second) Account ID$")
	public void iInputToAccountID(String account) {
		if (account.equalsIgnoreCase("first")) {
		}
		if (account.equalsIgnoreCase("second")) {
		}
	}
	@When("^I (transfer|withdraw) to \"(.*?)\" USD$")
	public void iTransferToSomethingUSD(String amount) {
		
	}
}
