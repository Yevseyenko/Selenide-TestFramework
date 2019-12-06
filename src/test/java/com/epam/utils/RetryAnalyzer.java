package com.epam.utils;

import com.epam.core.constants.Constants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    public int counter = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < Constants.RETRY_LIMIT) {
            counter++;
            return true;
        }
        return false;
    }
}
