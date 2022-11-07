package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //This interface class implements the methods we want to be applied before, during and after each test.

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("Test failed because of  ==> " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Test skipped because of ==> " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("<<<<<<<<<<<<<<< Start " + context.getName() + " >>>>>>>>>>>>>>>");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("<<<<<<<<<<<<<<< Finish " + context.getName() + " >>>>>>>>>>>>>>>");


    }

}
