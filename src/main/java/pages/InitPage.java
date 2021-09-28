package pages;

import config.PageContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitPage {

	private final WebDriver driver;

	@FindBy(xpath = "//title[contains(text(),'WWE Champions')]")
	private WebElement title;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement initialLogin;

	@FindBy(xpath = "//span[contains(text(),'Login with ScopelyID')]")
	private WebElement loginWithScopelyId;

	public InitPage(PageContext pageContext) {
		this.driver = pageContext.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public WebElement getInitialLogin() {
		return initialLogin;
	}

	public WebElement getLoginWithScopelyId() {
		return loginWithScopelyId;
	}

}
