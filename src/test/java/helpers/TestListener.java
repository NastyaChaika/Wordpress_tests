package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure (ITestResult result) {
        takeScreenshot(result);
        System.out.println("Test failed.");
    }

    @Override
    public void onTestSuccess (ITestResult result) {
        takeScreenshot(result);
        System.out.println("Test passed.");
    }

    private void takeScreenshot (ITestResult result) {
        File scrn = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH:mm:ss");
        Date resultdate = new Date(System.currentTimeMillis());
        String screenshotName;
        if (result.getStatus() == ITestResult.FAILURE)
            screenshotName = "scrn_" + result.getName() + "_failure_" + sdf.format(resultdate) + ".png";
        else
            if (result.getStatus() == ITestResult.SUCCESS)
                screenshotName = "scrn_" + result.getName() + "_success_" + sdf.format(resultdate) + ".png";
            else
                if (result.getStatus() == ITestResult.SKIP)
                    screenshotName = "scrn_" + result.getName() + "_skip_" + sdf.format(resultdate) + ".png";
                else
                    screenshotName = "scrn_" + result.getName() + "_NA_" + sdf.format(resultdate) + ".png";
        String path = "./target/screenshots/" + screenshotName;
        try {
            FileUtils.copyFile(scrn, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

}