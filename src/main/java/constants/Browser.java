package constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.springframework.lang.Nullable;

import java.util.HashMap;

public enum Browser {

	CHROME("webdriver.chrome.driver", DriverProps.chrome) {
		@Override
		public WebDriver driver() {
			return new ChromeDriver();
		}
	},
	FIREFOX("webdriver.gecko.driver", DriverProps.firefox) {
		@Override
		public WebDriver driver() {
			return new FirefoxDriver();
		}
	},
	OPERA("webdriver.opera.driver", DriverProps.opera) {
		@Override
		public WebDriver driver() {
			return new OperaDriver();
		}
	},
	IE("webdriver.ie.driver", DriverProps.ie) {
		@Override
		public WebDriver driver() {
			return new InternetExplorerDriver();
		}
	};

	private final String property;
	private final HashMap<OS, String> value;

	Browser(String property, HashMap<OS, String> value) {
		this.property = property;
		this.value = value;
	}

	@Nullable
	public static Browser of(String name) {
		for (Browser browser : values()) {
			if (browser.name().equalsIgnoreCase(name)) {
				return browser;
			}
		}
		return null;
	}

	public String getProperty() {
		return property;
	}

	public HashMap<OS, String> getValue() {
		return value;
	}

	public abstract WebDriver driver();
}
