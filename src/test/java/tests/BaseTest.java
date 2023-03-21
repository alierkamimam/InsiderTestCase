package tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Pages;

import java.io.File;
import java.io.IOException;

@Slf4j

public class BaseTest {


    protected Pages pages = new Pages();
    WebDriver driver;


    @BeforeSuite
    public void setUp() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");

        Driver.getDriver().get(URL);
        pages.getHOME_PAGE().acceptCookies();
        log.info("::::::Test Information ::::::\n\tURL :" + URL + "\n\tBrowser :" + browser);
        log.info("\t---Starting test Automation---");
        BrowserUtils.wait(1);


    }

    @AfterSuite
    public void tearDown() throws IOException {

        Driver.getDriver().quit();
        }
        //code that is executed after the entire test suite



    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

    }

}



