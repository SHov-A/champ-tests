package helper;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * The helper methods.
 */
public class TestUtil {

	private static final String DATA_ID = "data-id";
	private static String valueForComparing;
	private static int randomNumber;

	public static String getValueForComparing(){
		return valueForComparing;
	}

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
		return webElements.get(randomNumber);
	}

	public static String getElementAttributeValue(List<WebElement> webElements) {
		Objects.requireNonNull(webElements, "web elements are invalid" + webElements);
		randomNumber = randomNumberGenerator(webElements.size());
		valueForComparing = webElements.get(randomNumber).getAttribute(DATA_ID);
		return valueForComparing;
	}

	public static int randomNumberGenerator(int number) {
		Random random = new Random();
		return random.nextInt(number);
	}

}
