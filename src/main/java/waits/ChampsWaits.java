package waits;

import config.PageContext;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Common waits for web elements.
 */
public class ChampsWaits {

	private static final String ATTRIBUTE_NAME = "data-id";
	private static final int DURATION_FOR_WAIT_IN_SECONDS = 60;
	private static final int DURATION_FOR_POLLING_IN_MILLIS_SECONDS = 500;

	private final PageContext pageContext;
	private final WebDriverWait wait;

	public ChampsWaits(PageContext pageContext) {
		this.pageContext = pageContext;
		wait = new WebDriverWait(pageContext.getDriver(), DURATION_FOR_WAIT_IN_SECONDS);
		wait.pollingEvery(Duration.ofMillis(DURATION_FOR_POLLING_IN_MILLIS_SECONDS));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
	}

	public WebElement elementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String getAttributeValueByJS(WebElement element) {
		String js = String.format("return arguments[0].getAttribute('%s');", ATTRIBUTE_NAME);
		return ((JavascriptExecutor) pageContext.getDriver()).executeScript(js, element).toString();
	}

	public boolean titleIs(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}

	public WebElement visibilityOf(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> visibilityOfAllElements(List<WebElement> element) {
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
}
