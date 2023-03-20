package utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


import static org.testng.AssertJUnit.assertTrue;

@Slf4j
public class BrowserUtils {

    /**
     * Performs a double click on the given web element.
     *
     * @param element The web element to be double-clicked.
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Performs a drag and drop operation from the source element to the target element.
     *
     * @param source The source element to drag from.
     * @param target The target element to drop onto.
     */
    public static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(source, target).build().perform();
    }


    /**
     * Performs thread sleep for the desired seconds
     */
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            log.error("An InterruptedException occurred ", e);
        }
    }

    /**
     * Navigates to the target window
     *
     * @param targetTitle
     */
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


    /**
     * scroll down by given value
     *
     * @param value
     */
    public static void scrollDown(String value) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0," + value + ")");

    }
    /**
     * scroll up by given value
     *
     * @param value
     */
    public static void scrollUp(String value) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,-" + value + ")");

    }



    /**
     * Performs a hover over action on the specified web element.
     *
     * @param element The web element to hover over.
     */
    public static void hoverOver(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();
    }

    /**
     * Moves the mouse pointer to the specified web element.
     *
     * @param element The web element to move the mouse pointer to.
     */
    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).build().perform();
    }


    /**
     * Finds element via ByVisibleText() method of Select class from DropDowns
     *
     * @param element
     * @param location
     */

    public static void dropDownsByVisibleText(WebElement element, String location) {
        Select select = new Select(element);
        select.selectByVisibleText(location);
    }


    /**
     * Verifies if the given web element is displayed on the page.
     * If the element is not displayed, the test will fail with the given message.
     *
     * @param element The web element to check for visibility.
     * @param message The message to be displayed in case the element is not visible.
     */
    public static void verifyElementDisplayed(WebElement element, String message) {
        try {
            assertTrue(message, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail(message);
        }
    }


    /**
     * Navigates to a target window based on its title
     *
     * @param targetTitle the title of the target window
     */
    public static void navigateToWindow(String targetTitle) {
        String currentWindow = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(currentWindow);
    }

    /**
     * Waits for the specified element to become visible
     *
     * @param element         - The WebElement to wait for
     * @param timeToWaitInSec - The time to wait in seconds
     * @return The visible WebElement
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Waits for an element to be visible
     *
     * @param locator         - element locator
     * @param timeToWaitInSec - time to wait in seconds
     * @return WebElement - visible element
     */
    public static WebElement waitForVisibility(By locator, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Waits for element to be clickable
     *
     * @param element         - WebElement to be clicked
     * @param timeToWaitInSec - timeout in seconds
     * @return WebElement
     */
    public static WebElement waitForClickability(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for an element to be clickable
     *
     * @param locator
     * @param timeToWaitInSec
     * @return WebElement
     */
    public static WebElement waitForClickable(By locator, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Switches to a specified frame by its name or ID.
     *
     * @param frameNameOrId the name or ID of the frame to switch to
     */
    public static void switchToFrame(String frameNameOrId) {
        Driver.getDriver().switchTo().frame(frameNameOrId);
    }

    /**
     * Accepts an alert and returns its text.
     *
     * @return the text of the alert
     */
    public static String handleAlertAcceptByReturningMessage() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    /**
     * Accepts an alert
     *
     * @return the text of the alert
     */
    public static void handleAlertAccept() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    /**
     * Dismisses an alert and returns its text.
     *
     * @return the text of the alert
     */
    public static String handleAlertDismissByReturningMessage() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }

    /**
     * Dismisses an alert and returns its text.
     *
     * @return the text of the alert
     */
    public static void handleAlertDismiss() {
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
    }

    /**
     * Switches to the browser tab with the specified title.
     *
     * @param title The title of the browser tab to switch to.
     */
    public static void switchToTab(String title) {
        WebDriver driver = Driver.getDriver();

        // Get a list of all open window handles
        for (String windowHandle : driver.getWindowHandles()) {
            // Switch to each window handle and check its title
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                // If the title matches, break out of the loop
                break;
            }
        }


    }

}
