package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeverAppPage extends BasePage {

	@FindBy(xpath = "//div[@class='section-wrapper accent-section page-full-width']")
	private WebElement definitionBlock;

	public boolean definitionBlockIsDisplayed() {
		return definitionBlock.isDisplayed();

	}

}
