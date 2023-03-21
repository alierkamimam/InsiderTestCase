package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

public class QualityAssurancePage extends BasePage {

	@FindBy(xpath = "//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']")
	private WebElement seeAllQaJobsButton;

	public void clickSeeAllQaJobs() {
		BrowserUtils.wait(1);
		BrowserUtils.waitForClickability(seeAllQaJobsButton, 3);
		seeAllQaJobsButton.click();
	}

}
