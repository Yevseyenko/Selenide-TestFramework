package com.epam.core.testng;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;


public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.info("Invoking method");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    @Override
    public void onStart(ISuite suite) {
        logger.info("Start suite test");
    }

    @Override
    public void onFinish(ISuite suite) {
        logger.info("Finish suite test");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Start executing test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test run successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("Test runned not fully");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Finish");
    }
}
