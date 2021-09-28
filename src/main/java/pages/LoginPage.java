package pages;

import config.PageContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private final WebDriver driver;

	@FindBy(id = "okta-signin-username")
	private WebElement username;

	@FindBy(id = "okta-signin-password")
	private WebElement password;

	@FindBy(id = "okta-signin-submit")
	private WebElement submit;


	public LoginPage(PageContext pageContext) {
		this.driver = pageContext.getDriver();
		PageFactory.initElements(this.driver, this);
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
