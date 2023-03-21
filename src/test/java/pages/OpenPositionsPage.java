package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

import java.util.List;
@Slf4j
public class OpenPositionsPage extends BasePage {

    @FindBy(xpath = "(//select[@id='filter-by-location'])[1]")
    private WebElement filterByLocationDropDown;


    @FindBy(xpath = "(//select[@id='filter-by-department'])[1]")
    private WebElement filterByDepartmentDropDown;

    @FindBy(xpath = "//div[@id='jobs-list']")
    private WebElement jobList;

    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")
    private List<WebElement> positions;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    private List<WebElement> departments;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    private List<WebElement> location;

    @FindBy(xpath = "(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[1]")
    private WebElement applyNowButton;




    public void clickFilterByLocationDropDown(String location) {
        BrowserUtils.dropDownsByVisibleText(filterByLocationDropDown, location);

    }


    public void clickFilterByDepartmentDropDown(String department) {
        BrowserUtils.dropDownsByVisibleText(filterByDepartmentDropDown, department);

    }

    public void JobListIsDisplayed() {
        BrowserUtils.waitForVisibility(jobList,5);
        BrowserUtils.verifyElementDisplayed(jobList, "element is not displayed");
    }
    public void ApplyNowButtonIsDisplayed() {
        BrowserUtils.hoverOver(applyNowButton);
        BrowserUtils.verifyElementDisplayed(applyNowButton, "element is not displayed");
        BrowserUtils.wait(2);
    }

    public void clickApplyNowButton(){
        applyNowButton.click();
    }


    public  boolean verifyElementPositionsText(String text) {
        for (int i = 0; i <positions.size() ; i++) {
            if (!positions.get(i).getText().contains(text)){
                return false;
            }
        }
        return true;
    }

    public  boolean verifyElementDepartmentText(String text) {
        for (int i = 0; i <departments.size() ; i++) {
            if (!departments.get(i).getText().contains(text)){
                return false;
            }
        }
        return true;
    }
    public boolean verifyElementLocationText(String text) {
        for (int i = 0; i <location.size() ; i++) {
            if (!location.get(i).getText().contains(text)){
                return false;
            }
        }
        return true;
    }




}


