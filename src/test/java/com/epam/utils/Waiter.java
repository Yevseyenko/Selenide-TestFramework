package com.epam.utils;

import com.epam.core.enums.LocatorTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.core.enums.LocatorTypeEnum.CSS;
import static com.epam.core.enums.LocatorTypeEnum.XPATH;

//strategy
public class Waiter {
    public static void fluentWait(String locator, LocatorTypeEnum locatorTypeEnum) {
        if (locatorTypeEnum.equals(CSS)) {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(400))
                    .ignoring(NoSuchElementException.class);
            wait.until(webDriver -> webDriver.findElement(By.cssSelector(locator)));
        } else if (locatorTypeEnum.equals(XPATH)) {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(400))
                    .ignoring(NoSuchElementException.class);
            wait.until(webDriver -> webDriver.findElement(By.xpath(locator)));
        }
    }
}
