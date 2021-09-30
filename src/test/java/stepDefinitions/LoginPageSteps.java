package stepDefinitions;

import helper.TestUtil;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;
import waits.ChampsWaits;

/**
 * Login Page's related actions.
 */
public class LoginPageSteps {

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private ChampsWaits champsWaits;

	@Then("^User fills \"([^\"]*)\" in username field$")
	public void user_fills_in_username_field(String email) {
		TestUtil.sendKeys(champsWaits.visibilityOf(loginPage.getUserName()), email);
	}

	@Then("^User fills \"([^\"]*)\" in password field$")
	public void user_fills_in_password_field(String password) {
		TestUtil.sendKeys(champsWaits.visibilityOf(loginPage.getPassword()), password);
	}

	@Then("^User clicks on submit button$")
	public void user_clicks_on_submit_button() {
		TestUtil.click(champsWaits.elementToBeClickable(loginPage.getSubmit()));
	}

}
