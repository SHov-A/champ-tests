package stepDefinitions;

import helper.TestUtil;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import pages.HomePage;

public class HomePageSteps {

	@Autowired
	private HomePage homePage;

	@Then("^User clicks on account settings button$")
	public void user_clicks_on_account_settings_button() throws InterruptedException {
		Thread.sleep(3000);
		TestUtil.click(homePage.getAccountSettings());
	}

	@Then("^User clicks on change avatar button$")
	public void user_clicks_on_change_avatar_button() {
		TestUtil.click(homePage.getChangeAvatar());
	}

	@Then("^User clicks on change frame button$")
	public void user_clicks_on_change_frame_button() {
		TestUtil.click(homePage.getChangeFrame());
	}

	@Then("^User changes avatar$")
	public void user_changes_avatar() {
		TestUtil.click(TestUtil.getElementInArray(homePage.getAvatarsList()));
	}

	@Then("^User changes frame")
	public void user_changes_frame() {
		TestUtil.click(TestUtil.getElementInArray(homePage.getFramesList()));
	}

	@Then("^User applies to change avatar$")
	public void user_applies_to_change_avatar() {
		TestUtil.click(homePage.getApplyAvatarAndFrame());
	}

	@Then("^User applies to change frame$")
	public void user_applies_to_change_frame() {
		TestUtil.click(homePage.getApplyAvatarAndFrame());
	}

	@Then("^User logouts the page$")
	public void user_logouts_the_page() {
		TestUtil.click(homePage.getLogout());
	}

}
