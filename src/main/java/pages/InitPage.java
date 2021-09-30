package pages;

import config.PageContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Initial Page's related web elements.
 */
public class InitPage {

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement initialLogin;

	@FindBy(xpath = "//span[contains(text(),'Login with ScopelyID')]")
	private WebElement loginWithScopelyId;

	public InitPage(PageContext pageContext) {
		PageFactory.initElements(pageContext.getDriver(), this);
	}

	public WebElement getInitialLogin() {
		return initialLogin;
	}

	public WebElement getLoginWithScopelyId() {
		return loginWithScopelyId;
	}

}
