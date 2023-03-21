package tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class End2End extends BaseTest {

    /*
         1. Visit https://useinsider.com/ and check Insider home page is opened or not
         2. Select “More” menu in navigation bar, select “Careers” and check Career page, its
            Locations, Teams and Life at Insider blocks are opened or not
         3. Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
            Location - Istanbul, Turkey and department - Quality Assurance, check presence of
            jobs list
         4. Check that all jobs’ Position contains “Quality Assurance”, Department contains
            “Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button
         5. Click “Apply Now” button and check that this action redirects us to Lever Application
            form page
     */
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;


    @Test
    public void insiderWebPageTest() throws IOException {
        //Launch browser via @BeforeSuit in BaseTest and Navigate to urlHomePage 'https://useinsider.com/'

        //Checks Insider Home Page is opened or not.
        String message = "One platform for individualized, cross-channel customer experiences";
        String urlHomePage = ConfigurationReader.getProperty("url");
        String title = "#1 Leader in Individualized, Cross-Channel CX — Insider";


        softAssert.assertEquals(pages.getHOME_PAGE().getMessage(), message);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), urlHomePage);
        softAssert.assertEquals(Driver.getDriver().getTitle(), title);


        //Select “More” menu in navigation bar, select “Careers”
        pages.getHOME_PAGE().clickMoreButtonAndClickCareersButton();

        //Checks Career page is opened or not
        String urlCareersPage = "https://useinsider.com/careers/";
        String careerPageTitle = "Insider Careers";

        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), urlCareersPage);
        softAssert.assertEquals(Driver.getDriver().getTitle(), careerPageTitle);

        //Scrolls down in order to see Teams Block
        BrowserUtils.scrollDown("2200");
        BrowserUtils.wait(2);

        //Checks Teams Blocks is opened or not
        softAssert.assertTrue(pages.getCAREER_PAGE().teamsBlockIsDisplayed());
        softAssert.assertEquals(pages.getCAREER_PAGE().getCustomerSuccessText(), "Customer Success");
        softAssert.assertEquals(pages.getCAREER_PAGE().getSalesMessageText(), "Sales");
        softAssert.assertEquals(pages.getCAREER_PAGE().getProductEngineeringText(), "Product & Engineering");


        //Scrolls Down in order to see  Locations Block
        BrowserUtils.scrollDown("800");
        BrowserUtils.wait(2);

        //Checks Location Block is opened or not
        softAssert.assertEquals(pages.getCAREER_PAGE().getOurLocationText(), "Our Locations");
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("New York"));
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("Sao Paulo"));
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("London"));
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("Paris"));


        //Scrolls Down in order to see  Life at Insider Block
        BrowserUtils.scrollDown("700");
        BrowserUtils.wait(2);

        //Checks Life at Insider Block is opened or not
        softAssert.assertEquals(pages.getCAREER_PAGE().getLifeAtInsiderText(), "Life at Insider");
        softAssert.assertTrue(pages.getCAREER_PAGE().lifeAtInsiderBlockIsDisplayed());

        //Scroll up in order to click 'See all teams' button
        BrowserUtils.scrollUp("1000");

        //Clicks 'See all teams' button
        pages.getCAREER_PAGE().clickSeeAllTeamsButton();

        //Scrolls Down in order to see  Quality Assurance section
        BrowserUtils.scrollDown("1600");

        //Clicks 'Quality Assurance' section
        pages.getCAREER_PAGE().clickQualityAssuranceButton();

        //Clicks 'See all QA jobs
        pages.getQUALITY_ASSURANCE_PAGE().clickSeeAllQaJobs();
        BrowserUtils.wait(1);

        //Filters Location -'Istanbul,Turkey' and department 'Quality Assurance'
        BrowserUtils.scrollDown("600");
        pages.getOPEN_POSITIONS_PAGE().clickFilterByLocationDropDown("Istanbul, Turkey");
        pages.getOPEN_POSITIONS_PAGE().clickFilterByDepartmentDropDown("Quality Assurance");

        //check presence of jobs list
        pages.getOPEN_POSITIONS_PAGE().JobListIsDisplayed();
        BrowserUtils.wait(4);

        //Checks that all jobs’ Position contains “Quality Assurance”, Department contains
        //“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementPositionsText("Quality Assurance"));
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementDepartmentText("Quality Assurance"));
        softAssert.assertTrue(pages.getOPEN_POSITIONS_PAGE().verifyElementLocationText("Istanbul, Turkey"));
        pages.getOPEN_POSITIONS_PAGE().ApplyNowButtonIsDisplayed();


        //Clicks “Apply Now” button and switchToTab Lever Application gorm page
        pages.getOPEN_POSITIONS_PAGE().clickApplyNowButton();
        BrowserUtils.switchToTab("Insider.-Software Quality Assurance Engineer (Remote)");

        //Checks that this action redirects us to Lever Application form page
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://jobs.lever.co/useinsider/0ba4065b-955a-4661-ad4a-f32479f63757");
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Insider. - Software Quality Assurance Engineer (Remote)");
        softAssert.assertTrue(pages.getLEVER_APP_PAGE().definitionBlockIsDisplayed());

        softAssert.assertAll();

    }

}
