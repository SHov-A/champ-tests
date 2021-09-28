package config;

import constants.Browser;
import constants.OS;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pages.HomePage;
import pages.InitPage;
import pages.LoginPage;

import java.util.Properties;

@Configuration
public class PageFactory {

	private static final String BROWSER_PROP = "browser";
	private static final String OS_PROP = "os.name";

	@Bean
	public PageContext pageContext() {
		Properties prop = PageContext.config();
		String browserName = prop.getProperty(BROWSER_PROP);
		String osName = System.getProperty(OS_PROP);
		Browser browser = Browser.of(browserName);
		OS os = OS.of(osName);
		if (os == null) {
			throw new RuntimeException("Unsupported os: " + osName);
		}
		if (browser == null) {
			throw new RuntimeException("Unsupported browser type: " + browserName);
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

}
