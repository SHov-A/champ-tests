package config;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Driver and configuration required actions.
 */
public class PageContext {

	private static final int PAGE_LOAD_TIMEOUT = 20;
	private static final String URL_PROPERTY = "url";

	private final WebDriver driver;

	/**
	 * Configures the web driver behavior.
	 * @param driver - {@link WebDriver}
	 */
	public PageContext(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
		driver.get(config().getProperty(URL_PROPERTY));
	}

	/**
	 * Reads configuration from config file.
	 * @return - {@link Properties}
	 */
	public static Properties config() {
		Properties prop = null;
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(new File("./src/main/resources/config.properties"));
			prop.load(file);
		} catch (IOException e) {
			final String msg = "can't find properties file";
			System.err.println(msg);
			throw new RuntimeException(msg);
		}
		return prop;
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Takes screenshot when test fails.
	 * @return - array of bytes
	 */
	public byte[] getScreenShot() {
		byte[] screenshot;
		if (driver instanceof TakesScreenshot) {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		} else {
			screenshot = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
		}
		return screenshot;
	}

	public void quitBrowser() {
		driver.quit();
	}

}
