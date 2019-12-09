package com.epam.utils;

import org.testng.Assert;

import java.util.List;

import static com.epam.core.constants.Constants.*;

public class Validation {
    private static LazyAssert lazyAssert = new LazyAssert();

    public static void validateLogoHeader(String text) {
        Assert.assertEquals(text, TEST_SITE_NAME, "Logo headers are not equal");
    }

    public static void validateCommandListSize(int size) {
        Assert.assertEquals(size, COUNT_COMMANDS, "Count of commands is not equal");
    }

    public static void validateGlobalList(List<String> globalList) {
        Assert.assertEquals(globalList, VERIFY_GLOBAL_LIST, "Lists are not same");
    }

    public static void validateSearchResult(boolean searchResult) {
        Assert.assertTrue(searchResult, "Search result page doesn't appear");
    }

    public static void validateCalendarIsDisplayed(boolean isCalendarDisplayed, boolean isTableDisplayed) {
        lazyAssert.assertTrue(isCalendarDisplayed, "Calendar button isn't displayed");
        lazyAssert.assertTrue(isTableDisplayed, "Final table isn't displayed");
        lazyAssert.assertAll();
    }

    public static void validateLoginPage(boolean isLoginedTabDisplayed){
        Assert.assertTrue(isLoginedTabDisplayed, "User is logged");
    }
}
