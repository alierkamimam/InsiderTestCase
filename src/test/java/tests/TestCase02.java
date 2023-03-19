package tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.IOException;

@Slf4j
public class TestCase02 extends BaseTest{
    SoftAssert softAssert=new SoftAssert();



    @Test
    public void Test_Case02() throws IOException {

        pages.getHOME_PAGE().clickMoreButtonAndClickCareersButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://useinsider.com/careers/");
        softAssert.assertEquals(Driver.getDriver().getTitle(),"Insider Careers");

        BrowserUtils.wait(2);
        BrowserUtils.scrollDown("2200");
        BrowserUtils.wait(2);

        getScreenshot("TestCase02TeamsBlock", Driver.getDriver());
        softAssert.assertEquals(pages.getCAREER_PAGE().getCustomerSuccessText(),"Customer Success");
        softAssert.assertEquals(pages.getCAREER_PAGE().getSalesMessageText(),"Sales");
        softAssert.assertEquals(pages.getCAREER_PAGE().getProductEngineeringText(),"Product & Engineering");


        BrowserUtils.scrollDown("800");
        BrowserUtils.wait(2);
        getScreenshot("TestCase02LocationsBlock", Driver.getDriver());
        softAssert.assertEquals(pages.getCAREER_PAGE().getOurLocationText(),"Our Locations");

        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("New York"));
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("Sao Paulo"));
        softAssert.assertTrue(pages.getCAREER_PAGE().isDisplayedLocation("Barcelona"));

        BrowserUtils.scrollDown("700");
        BrowserUtils.wait(2);
        getScreenshot("TestCase02LifeatInsiderBlock", Driver.getDriver());
        softAssert.assertEquals(pages.getCAREER_PAGE().getLifeAtInsiderText(),"Life at Insider");






    }

}
