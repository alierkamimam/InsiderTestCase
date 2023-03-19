package utilities;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
@Slf4j
public class BrowserUtils {



    /**
     * Performs thread sleep for the desired seconds
     */
    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            log.error("An InterruptedException occurred ",e);
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

    public static void hoverOver(WebElement element) {
        new Actions(Driver.getDriver()).moveToElement(element);
    }


}
