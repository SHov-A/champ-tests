package pages;

import config.PageContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login Page's related web elements.
 */
public class LoginPage {

	@FindBy(id = "okta-signin-username")
	private WebElement username;

	@FindBy(id = "okta-signin-password")
	private WebElement password;

	@FindBy(id = "okta-signin-submit")
	private WebElement submit;


	public LoginPage(PageContext pageContext) {
		PageFactory.initElements(pageContext.getDriver(), this);
	}

	public WebElement getUserName() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}

}
