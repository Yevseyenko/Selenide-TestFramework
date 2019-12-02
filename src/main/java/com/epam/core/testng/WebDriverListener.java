package com.epam.core.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebDriverListener extends AbstractWebDriverEventListener {
    private static final Logger log = LoggerFactory.getLogger(WebDriverListener.class);

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("WebDriver navigated to '" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("WebDriver click on element - "
                + elementDescription(element));
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("WebDriver is trying to find element - "
                + elementDescription(element));
    }

    private String elementDescription(WebElement element) {
        String description = "tag:" + element.getTagName();
        if (element.getAttribute("id") != null) {
            description += " id: " + element.getAttribute("id");
        } else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }
        description += " ('" + element.getText() + "')";
        return description;
    }
}
