package helper;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * The helper methods.
 */
public class TestUtil {

	public static void click(WebElement webElement) {
		Objects.requireNonNull(webElement, "invalid web element" + webElement);
		webElement.click();
	}

	public static void sendKeys(WebElement webElement, String value) {
		Objects.requireNonNull(webElement, "invalid web element, can't send input" + value);
		webElement.sendKeys(value);
	}

	public static WebElement getElementInArray(List<WebElement> webElements) {
		Objects.requireNonNull(webElements, "web elements are invalid" + webElements);
		return webElements.get(randomNumberGenerator(webElements.size()));
	}

	public static int randomNumberGenerator(int number) {
		Random random = new Random();
		return random.nextInt(number);
	}
}
