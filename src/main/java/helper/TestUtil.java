package helper;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class TestUtil {

	public static void click(WebElement webElement) {
		webElement.click();
	}

	public static void sendKeys(WebElement webElement, String value) {
		webElement.sendKeys(value);
	}

	public static WebElement getElementInArray(List<WebElement> webElements) {
		return webElements.get(randomNumberGenerator(webElements.size()));
	}

	public static int randomNumberGenerator(int number) {
		Random random = new Random();
		return random.nextInt(number);
	}
}
