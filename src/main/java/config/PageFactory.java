package config;

import constants.Browser;
import constants.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pages.HomePage;
import pages.InitPage;
import pages.LoginPage;
import waits.ChampsWaits;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

/**
 * The configuration of spring beans.
 */
@Configuration
public class PageFactory {

	private static final String BROWSER_PROP = "browser";
	private static final String OS_PROP = "os.name";

	@Bean
	public PageContext pageContext()  {
		Properties prop = PageContext.config();
		String browserName = prop.getProperty(BROWSER_PROP);
		String osName = System.getProperty(OS_PROP);
		Browser browser = Browser.of(browserName);
		OS os = OS.of(osName);
		if (os == null) {
			throw new RuntimeException("Unsupported os: " + osName);
		}
		if (browser == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("browserVersion", "96.0");
			capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
				put("enableVNC", true);
			}});
			RemoteWebDriver remoteWebDriver = null;
			try {
				remoteWebDriver = new RemoteWebDriver(
						new URL("http://10.245.8.170:4444/wd/hub/"),
						capabilities
				);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			remoteWebDriver.setFileDetector(new LocalFileDetector());
			return new PageContext(remoteWebDriver);
		}
		String valueOfProperty = browser.getValue().get(os);
		if (valueOfProperty == null) {
			throw new RuntimeException(String.format("The browser %s is not supported by the %s operating system.", browserName, osName));
		}
		System.setProperty(browser.getProperty(), valueOfProperty);
		WebDriver driver = browser.driver();
		return new PageContext(driver);
	}

	@Bean
	public InitPage initPage() {
		return new InitPage(pageContext());
	}

	@Bean
	public LoginPage loginPage() {
		return new LoginPage(pageContext());
	}

	@Bean
	public HomePage homePage() {
		return new HomePage(pageContext());
	}

	@Bean
	public ChampsWaits champsWaits(){
		return new ChampsWaits(pageContext());
	}

}
