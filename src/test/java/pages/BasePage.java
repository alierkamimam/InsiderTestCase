package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

	protected WebDriver driver = Driver.getDriver();

	public BasePage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

	}

}
