package tests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;


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
        pages.getOPEN_POSITIONS_PAGE().JobListIsDisplayed();
        BrowserUtils.wait(3);
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementPositionsText("Quality Assurance"));
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementDepartmentText("Quality Assurance"));
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementLocationText("Istanbul, Turkey"));


        pages.getOPEN_POSITIONS_PAGE().ApplyNowButtonIsDisplayed();
        BrowserUtils.wait(2);
        pages.getOPEN_POSITIONS_PAGE().clickApplyNowButton();
        BrowserUtils.wait(5);
        BrowserUtils.switchToTab("Insider.-Software Quality Assurance Engineer (Remote)");

        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757");
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Insider. - Software Quality Assurance Engineer (Remote)");


        softAssert.assertAll();

    }
}
