package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

import java.util.List;

@Slf4j
public class CareersPage extends BasePage {

    @FindBy(xpath = "//p[text() = 'New York']\"")
    private WebElement locationBlock;

    @FindBy(xpath = "(//*[@class='text-center mb-4 mb-xl-5'])[1]")
    private WebElement customerSuccess;
    @FindBy(xpath = "(//*[@class='text-center mb-4 mb-xl-5'])[2]")
    private WebElement sales;

    @FindBy(xpath = "(//*[@class='text-center mb-4 mb-xl-5'])[3]")
    private WebElement productEngineering;


    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    private WebElement ourLocations;

    @FindBy(xpath = "//p[@class='mb-0']")
    private List<WebElement> locations;

    @FindBy(xpath = "//h2[text()='Life at Insider']")
    private WebElement lifeAtInsiderText;

    @FindBy(xpath = "//a[@href='javascript:void(0)']")
    private WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h3[text()='Quality Assurance']")
    private WebElement qualityAssurance;

    @FindBy(xpath = "//section[@id='career-find-our-calling']")
    private WebElement teamsBlock;

    @FindBy(xpath = "//section[@data-id='a8e7b90']")
    private WebElement lifeAtInsiderBlock;


    public boolean teamsBlockIsDisplayed() {
        return teamsBlock.isDisplayed();

    }

    public boolean lifeAtInsiderBlockIsDisplayed() {
        return teamsBlock.isDisplayed();

    }


    public String getCustomerSuccessText() {
        return customerSuccess.getText();
    }

    public String getSalesMessageText() {
        return sales.getText();
    }

    public String getProductEngineeringText() {
        return productEngineering.getText();
    }


    public String getOurLocationText() {
        return ourLocations.getText();
    }

    public String getLifeAtInsiderText() {
        return lifeAtInsiderText.getText();
    }

    public void clickSeeAllTeamsButton() {
        BrowserUtils.wait(1);
        BrowserUtils.waitForVisibility(seeAllTeamsButton, 5);
        seeAllTeamsButton.click();
    }

    public void clickQualityAssuranceButton() {
        BrowserUtils.wait(2);
        BrowserUtils.waitForClickability(qualityAssurance, 3);
        qualityAssurance.click();
    }


    public boolean isDisplayedLocation(String location) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getText().contains(location)) {
                return true;
            }
        }
        return false;
    }

}



