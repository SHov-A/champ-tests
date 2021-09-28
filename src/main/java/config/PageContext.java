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

public class PageContext {

	private static final int PAGE_LOAD_TIMEOUT = 15;
	private static final int IMPLICIT_WAIT = 15;

	private final WebDriver driver;

	public PageContext(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, SECONDS);
		driver.get(config().getProperty("url"));
		driver.manage().deleteAllCookies();
	}

	public static Properties config() {
		Properties prop = null;
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(new File("./src/main/resources/config.properties"));
			prop.load(file);
		} catch (IOException e) {
			System.err.println("can't find properties file");
		}
		return prop;
	}

	public WebDriver getDriver() {
		return driver;
	}

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
