package benjerry.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BrowserUtilities {

	public static void selectFromList(List<WebElement> list, String value) {
		for (WebElement element : list)
			if (element.getText().contains(value)) {
				element.click();
				break;
			}
	}

	public static void selectFromListByDataValue(List<WebElement> list, String value) {
		for (WebElement element : list)
			if (element.getAttribute("data-value").equals(value)) {
				element.click();
				break;
			}
	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void switchToWindow(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}

	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}

	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	public static List<String> getElementsText(By locator) {
		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	public static void waitForVisibility(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void waitForVisibility(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
	}

	public static void waitForClickablility(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}

	public static void waitForClickablility(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
	}

	public static void waitForPresenceOfElementLocated(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(locator)));
	}

	public static void waitForTitleContains(String partOfTitle, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(partOfTitle)));
	}

	public static void waitForTitleIs(String title, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.titleIs(title)));
	}

	public static void waitForUrlContains(String partOfUrl, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains(partOfUrl)));
	}

	public static void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void waitForPageToLoad(int seconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timed out waiting for page load");
		}
	}

	

	

	public static boolean elementExists(WebElement element, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), seconds);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
			return true;
		} catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	public static String getScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
		File finalDestination = new File(target);
		FileUtils.copyFile(source, finalDestination);
		return target;
	}

	public static void takeScreenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + fileName + date + ".png";
		File finalDestination = new File(path);
		FileUtils.copyFile(source, finalDestination);
	}

	public static void takeFullScreenshot(String fileName) throws IOException {
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(Driver.getDriver());
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + fileName + date + ".png";
		ImageIO.write(fpScreenshot.getImage(), "PNG", new File(path));
	}

}
