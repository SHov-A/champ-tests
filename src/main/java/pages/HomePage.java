package pages;

import config.PageContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Home Page's related web elements.
 */
public class HomePage {

	@FindBy(className = "account-profile__account-settings__button")
	private WebElement accountSettings;

	@FindBy(xpath = "//p[contains(text(),'Change Avatar')]")
	private WebElement changeAvatar;

	@FindBy(xpath = "//button[contains(text(),'Frame')]")
	private WebElement changeFrame;

	@FindBy(xpath = "//div[@class='avatar-select-image']")
	private List<WebElement> avatarsList;

	@FindBy(xpath = "//div[@class='avatar-select-image-frame']")
	private List<WebElement> framesList;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private WebElement applyAvatarAndFrame;

	@FindBy(xpath = "//p[contains(text(),'Logout')]")
	private WebElement logout;

	public HomePage(PageContext pageContext) {
		PageFactory.initElements(pageContext.getDriver(), this);
	}

	public WebElement getAccountSettings() {
		return accountSettings;
	}

	public WebElement getChangeAvatar() {
		return changeAvatar;
	}

	public WebElement getChangeFrame() {
		return changeFrame;
	}

	public List<WebElement> getAvatarsList() {
		return avatarsList;
	}

	public List<WebElement> getFramesList() {
		return framesList;
	}

	public WebElement getApplyAvatarAndFrame() {
		return applyAvatarAndFrame;
	}

	public WebElement getLogout() {
		return logout;
	}

}
