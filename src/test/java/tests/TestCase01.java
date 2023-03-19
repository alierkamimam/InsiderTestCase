package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.io.IOException;

public class TestCase01 extends BaseTest {

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    // 1) Visit https://useinsider.com/ and check Insider home page is opened or not
    @Test
    public void TestCase_01_GoTo_Insider_Home_Page() throws IOException {
        //Launch browser via @BeforeSuit in BaseTest and Navigate to url 'https://useinsider.com/'
        String message = "One platform for individualized, cross-channel customer experiences";
        softAssert.assertEquals(pages.getHOME_PAGE().getMessage(),message);
        System.out.println("\tInsider home page Opened");
        getScreenshot("TestCase01",Driver.getDriver());
        softAssert.assertAll();




    }



}
