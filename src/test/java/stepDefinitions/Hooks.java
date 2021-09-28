package stepDefinitions;

import config.PageContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

	@Autowired
	private PageContext pageContext;

	@After
	public void after(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(pageContext.getScreenShot(), "image/png");
		}
	}

	@After(value = "@secondTestCase")
	public void close() {
		pageContext.quitBrowser();
	}

}
