package stepDefinitions;

import config.PageContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Required actions after all scenarios.
 */
public class Hooks {

	@Autowired
	private PageContext pageContext;

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.attach(pageContext.getScreenShot(), "image/png", "The Screenshot");
		}
	}

	@After(value = "@secondTestCase")
	public void close() {
		pageContext.quitBrowser();
	}

}
