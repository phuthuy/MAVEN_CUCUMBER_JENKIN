package commons;

import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	static WebDriver driver;
	protected final Log log;

	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			// Add status (true/ false) to Report (ReportNG)
			Reporter.getCurrentTestResult().setThrowable(e);	
			}
		return pass;
	}

	public boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	public boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	public boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	public int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}
	public String randomEmail() {
		Random random = new Random();
		String number = random.nextInt(99999) + "@gmail.com";
		return number;
	}

}
