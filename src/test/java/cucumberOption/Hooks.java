package cucumberOption;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	// Run for many thread
	private static WebDriver driver;
	private static Scenario scenario;
	private static final Logger log = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		// Run by Maven command line
		String browser = System.getProperty("BROWSER");

		if (driver == null) {
			try {
				// Kiem tra BROWSER = null -> gan = chrome
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "chrome";
					}
				}

				switch (browser) {
				case "chrome":
					 System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				case "hchrome":
					System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1366x768");
					driver = new ChromeDriver(options);
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "hfirefox":
					driver = new FirefoxDriver();
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				default:
					// WebDriverManager.chromedriver().setup();
					System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				}
			} catch (UnreachableBrowserException e) {
				driver = new ChromeDriver();
			} catch (WebDriverException e) {
				driver = new ChromeDriver();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get("http://demo.guru99.com/v4/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			log.info("------------- Started the browser -------------");
		}
		return driver;
	}

	public static void  endTest(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) openBrowser()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) openBrowser()).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		openBrowser().quit();
	}

	public static void close() {
		try {
			if (driver != null) {
//				openBrowser().quit();
				log.info("------------- Closed the browser -------------");
			}
		} catch (UnreachableBrowserException e) {
			System.out.println("Can not close the browser");
		}
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			endTest(scenario);
		}
	}

}
