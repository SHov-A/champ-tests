package stepDefinitions;

import helper.TestUtil;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.springframework.beans.factory.annotation.Autowired;
import pages.HomePage;
import waits.ChampsWaits;

/**
 * Home Page's related actions.
 */
public class HomePageSteps {

	@Autowired
	private HomePage homePage;

	@Autowired
	private ChampsWaits champsWaits;

	@Then("^User clicks on account settings button$")
	public void user_clicks_on_account_settings_button() {
		try {
			TestUtil.click(champsWaits.elementToBeClickable(homePage.getAccountSettings()));
		} catch (StaleElementReferenceException exception) {
			System.err.print("element not found " + homePage.getAccountSettings());
			TestUtil.click(champsWaits.elementToBeClickable(homePage.getAccountSettings()));
		}
	}

	@Then("^User clicks on change avatar button$")
	public void user_clicks_on_change_avatar_button() {
		TestUtil.click(champsWaits.elementToBeClickable(homePage.getChangeAvatar()));
	}

	@Then("^User clicks on change frame button$")
	public void user_clicks_on_change_frame_button() {
		TestUtil.click(champsWaits.elementToBeClickable(homePage.getChangeFrame()));
	}

	@Then("^User gets avatar attribute value for comparing$")
	public void user_gets_avatar_attribute_value_for_comparing() {
		TestUtil.getElementAttributeValue(champsWaits.visibilityOfAllElements(homePage.getDadAvatarsListForCompare()));
	}

	@Then("^User gets frame attribute value for comparing$")
	public void user_gets_frame_attribute_value_for_comparing() {
		TestUtil.getElementAttributeValue(champsWaits.visibilityOfAllElements(homePage.getDadFramesListForCompare()));
	}

	@Then("^User changes avatar$")
	public void user_changes_avatar() {
		TestUtil.click(champsWaits.elementToBeClickable(TestUtil.getElementInArray(homePage.getAvatarsList())));
	}

	@Then("^User changes frame")
	public void user_changes_frame() {
		TestUtil.click(champsWaits.elementToBeClickable(TestUtil.getElementInArray(homePage.getFramesList())));
	}

	@Then("^User applies to change avatar$")
	public void user_applies_to_change_avatar() {
		TestUtil.click(champsWaits.elementToBeClickable(homePage.getApplyAvatarAndFrame()));
	}

	@Then("^User applies to change frame$")
	public void user_applies_to_change_frame() {
		TestUtil.click(champsWaits.elementToBeClickable(homePage.getApplyAvatarAndFrame()));
	}

	@Then("^User checks that avatar is changed$")
	public void user_checks_that_avatar_is_changed() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(champsWaits.getAttributeValueByJS(homePage.getAddedAvatarForCompare()),
				TestUtil.getValueForComparing());
	}

	@Then("^User checks that frame is changed$")
	public void user_checks_that_frame_is_changed() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(champsWaits.getAttributeValueByJS(homePage.getAddedFrameForCompare()),
				TestUtil.getValueForComparing());
	}

	@Then("^User logouts the page$")
	public void user_logouts_the_page() {
		TestUtil.click(champsWaits.elementToBeClickable(homePage.getLogout()));
	}

}
