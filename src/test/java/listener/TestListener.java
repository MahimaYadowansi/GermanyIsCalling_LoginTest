package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import baseTest.BaseTest;
import utilities.ScreenshotUtility;

public class TestListener extends BaseTest implements ITestListener{
	 @Override
	    public void onTestFailure(ITestResult result) {
	        // Log failure in Extent Reports
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

	        
	        String screenshotPath = ScreenshotUtility.captureScreenshot(driver, result.getMethod().getMethodName());

	        test.addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	        test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

}
