package stepDefinitions;

import config.PageFactory;
import helper.TestUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.InitPage;

/**
 * Importing the spring context configuration and
 * actions related to initial page.
 */
@CucumberContextConfiguration
@ContextConfiguration(classes = PageFactory.class)
public class InitPageSteps {

	@Autowired
	private InitPage initPage;

	@Given("^User is in initial page and title should by \"([^\"]*)\"$")
	public void user_is_in_initial_page(String titleText) {
		String title = initPage.getHomePageTitle();
		Assert.assertEquals(titleText, title);
	}

	@Then("^User clicks on initial login button$")
	public void user_clicks_on_initial_login_button() {
		TestUtil.click(initPage.getInitialLogin());
	}

	@Then("^User clicks on login with ScopelyID button$")
	public void user_clicks_on_login_with_scopelyId_button() {
		TestUtil.click(initPage.getLoginWithScopelyId());
	}

}
