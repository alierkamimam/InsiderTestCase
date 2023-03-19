package tests;


import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class TestCase03 extends BaseTest {
    @Test
    public void TestCase03() {
        pages.getHOME_PAGE().clickMoreButtonAndClickCareersButton();
        BrowserUtils.scrollDown("2800");
        BrowserUtils.wait(2);
        pages.getCAREER_PAGE().clickSeeAllTeamsButton();
        BrowserUtils.wait(3);
        BrowserUtils.scrollDown("1600");
        BrowserUtils.wait(2);
        pages.getCAREER_PAGE().clickQualityAssuranceButton();




    }
}
