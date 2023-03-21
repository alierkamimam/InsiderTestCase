package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;

public class Listener extends BaseTest implements ITestListener {

	// we use Listener for screenshot on failure condition
	ExtentReports extent = ExtentReportsNG.getReportObject();

	ExtentTest test;

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	WebDriver driver = Driver.getDriver();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		String filePath = null;

		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
			tearDown();

		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
