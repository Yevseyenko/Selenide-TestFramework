package com.epam.utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.epam.core.testng.WebDriverListener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.core.constants.Constants.SITE;

public class SelenideConfigurator {
    public static void configure() {
        Configuration.baseUrl = SITE;
        Configuration.startMaximized = true;
        open("/");
        EventFiringWebDriver driver = new EventFiringWebDriver(getWebDriver());
        driver.register(new WebDriverListener());
    }
}
