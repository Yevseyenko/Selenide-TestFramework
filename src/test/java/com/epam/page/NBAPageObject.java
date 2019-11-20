package com.epam.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NBAPageObject {
    //todo fix url, I bet you can locate any element with 1, maximum 2 nodes
    private SelenideElement logoHeader = $(By.xpath("//a[contains(@class,'tribuna')]"));

    private static SelenideElement inputSearch = $("form[action*=\"tr\"]>input.search-block__input");

    private SelenideElement searchButon = $("form[action*=\"tr\"]>button");

    private SelenideElement description = $("div.short-info>div.descr");

    private ElementsCollection loginButton = $$("li.user-panel__menu-block-item:first-child");

    private SelenideElement commandsButton = $("ul#global-nav-1>li:nth-child(2)");

    private SelenideElement globalButton = $("ul#global-nav-1>li:nth-child(3)");

    private ElementsCollection listCommands = $$("ul#global-nav-1>li:nth-child(2)>ul>li");

    private ElementsCollection listGlobal = $$("ul#global-nav-1>li:nth-child(3)>ul>li");

    private SelenideElement loginedTab = $(By.xpath("//li[contains(@class,'menu-block-user')]/a"));

    private SelenideElement results = $("div.search-result");

    public NBAPageObject inputValueToSearch(String value) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(webDriver -> webDriver.findElement(By.cssSelector("form[action*=\"tr\"]>input.search-block__input")));
        inputSearch.setValue(value);
        return this;
    }

    public void clickSearchButton() {
        searchButon.click();
    }

    public void clickLoginButton() {
        loginButton.findBy(Condition.visible).click();
    }

    public SelenideElement getLogoHeader() {
        return logoHeader;
    }

    public void clickCommandsButton() {
        commandsButton.click();
    }

    public ElementsCollection getListCommands() {
        return listCommands;
    }

    public ElementsCollection getListGlobal() {
        return listGlobal;
    }

    public void clickGlobalButton() {
        globalButton.click();
    }

    public boolean isLoginedTabDisplayed() {
              return loginedTab.isDisplayed();
    }

    public boolean isSearchResultAppear() {
        return results.exists();
    }
}
