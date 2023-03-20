package tests;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CareersPage;
import pages.OpenPositionsPage;
import utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class TestCase03 extends BaseTest {
    SoftAssert softAssert = new SoftAssert();


    @Test
    public void TestCase03() {
        pages.getHOME_PAGE().clickMoreButtonAndClickCareersButton();
        BrowserUtils.scrollDown("2800");
        BrowserUtils.wait(2);
        pages.getCAREER_PAGE().clickSeeAllTeamsButton();
        BrowserUtils.wait(2);
        BrowserUtils.scrollDown("1600");
        BrowserUtils.wait(2);
        pages.getCAREER_PAGE().clickQualityAssuranceButton();
        BrowserUtils.wait(2);
        pages.getQUALITY_ASSURANCE_PAGE().clickSeeAllQaJobs();
        BrowserUtils.wait(2);
        BrowserUtils.scrollDown("600");
        BrowserUtils.wait(2);
        pages.getOPEN_POSITIONS_PAGE().clickFilterByLocationDropDown("Istanbul, Turkey");
        pages.getOPEN_POSITIONS_PAGE().clickFilterByDepartmentDropDown("Quality Assurance");
        BrowserUtils.wait(5);
        pages.getOPEN_POSITIONS_PAGE().elementIsDisplayed();
        BrowserUtils.wait(3);
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementPositionsText("Quality Assurance"));

        softAssert.assertAll();
    }
}
