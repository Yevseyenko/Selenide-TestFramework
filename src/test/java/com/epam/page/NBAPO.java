package com.epam.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.enums.LocatorTypeEnum;
import com.epam.utils.Waiter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NBAPO {

    private SelenideElement logoHeader = $(By.xpath("//a[contains(@class,'tribuna')]"));

    private static String inputSearchLocator = "form[action*=\"tr\"]>input.search-block__input";

    private static String resultsLocator = "div.search-result";

    private static SelenideElement inputSearch = $(inputSearchLocator);

    private SelenideElement searchButon = $("form[action*=\"tr\"]>button");

    private SelenideElement description = $("div.short-info>div.descr");

    private ElementsCollection loginButton = $$("li.user-panel__menu-block-item:first-child");

    private SelenideElement commandsButton = $("ul#global-nav-1>li:nth-child(2)");

    private SelenideElement globalButton = $("ul#global-nav-1>li:nth-child(3)");

    private ElementsCollection listCommands = $$("li:nth-child(2)>ul>li");

    private ElementsCollection listGlobal = $$("li:nth-child(3)>ul>li");

    private SelenideElement loginedTab = $(By.xpath("//li[contains(@class,'menu-block-user')]/a"));

    private SelenideElement results = $(resultsLocator);

    public NBAPO inputValueToSearch(String value) {
        Waiter.fluentWait(inputSearchLocator, LocatorTypeEnum.CSS);
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
        Waiter.fluentWait(resultsLocator, LocatorTypeEnum.CSS);
        return results.exists();
    }
}
