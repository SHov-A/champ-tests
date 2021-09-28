package pages;

import config.PageContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

	private final WebDriver driver;

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
		this.driver = pageContext.getDriver();
		PageFactory.initElements(this.driver, this);
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
