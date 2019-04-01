package actions;

import org.openqa.selenium.WebDriver;

import interfaces.LoginPageUI;

public class PageFactoryManager {
	public static LoginPageObject openLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);	
	}
	public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);	
	}
	public static EditCustomerPageObject openEditPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);	
	}
	public static HomePageObject openHomePage(WebDriver driver) {
		return new HomePageObject(driver);	
	}
	public static NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);	
	}
	public static RegisterPageObject openRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);	
	}
	public static WithdrawPageObject openWithdrawPage(WebDriver driver) {
		return new WithdrawPageObject(driver);	
	}
	public static AbstractPageObject openAbstractPage(WebDriver driver) {
		return new AbstractPageObject(driver);	
	}
}
