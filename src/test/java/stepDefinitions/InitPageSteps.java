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
import waits.ChampsWaits;

/**
 * Importing the spring context configuration and
 * actions related to initial page.
 */
@CucumberContextConfiguration
@ContextConfiguration(classes = PageFactory.class)
public class InitPageSteps {

	@Autowired
	private InitPage initPage;

	@Autowired
	private ChampsWaits champsWaits;

	@Given("^User is in initial page and title should by \"([^\"]*)\"$")
	public void user_is_in_initial_page(String titleText) {
		final boolean titleCheck = champsWaits.titleIs(titleText);
		Assert.assertTrue(titleCheck);
	}

	@Then("^User clicks on initial login button$")
	public void user_clicks_on_initial_login_button() {
		TestUtil.click(champsWaits.elementToBeClickable(initPage.getInitialLogin()));
	}

	@Then("^User clicks on login with ScopelyID button$")
	public void user_clicks_on_login_with_scopelyId_button() {
		TestUtil.click(champsWaits.elementToBeClickable(initPage.getLoginWithScopelyId()));
	}

}
