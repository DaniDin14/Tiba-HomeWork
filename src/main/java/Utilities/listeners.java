package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends commonOps implements ITestListener {

    @Override
    public void onFinish(ITestContext execution) {
        System.out.println("----------- Ending Execution -----------");
    }

    @Override
    public void onStart(ITestContext execution) {
        System.out.println("----------- Starting Execution -----------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult execution) {
    }

    @Override
    public void onTestFailure(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Failed -----------");
        saveScreenshot(driver);
    }

    @Override
    public void onTestSkipped(ITestResult test) {
        System.out.println("----------- Skipping Test:" + test.getName() + "-----------");
    }

    @Override
    public void onTestStart(ITestResult test) {
        System.out.println("----------- Starting Test:" + test.getName() + "-----------");
    }

    @Override
    public void onTestSuccess(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Passed -----------");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}