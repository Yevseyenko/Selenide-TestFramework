package com.epam.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.enums.LocatorTypeEnum;
import com.epam.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NBAPO {

    private SelenideElement logoHeader = $(By.xpath("//a[contains(@class,' tribuna')]"));

    private static String inputSearchLocator = "form[action*=\"tr\"]>input.search-block__input";

    private static String resultsLocator = "div.search-result";

    private static SelenideElement inputSearch = $(inputSearchLocator);

    private SelenideElement searchButon = $("form[action*=\"tr\"]>button");

    private ElementsCollection loginButton = $$("li.user-panel__menu-block-item:first-child");

    private SelenideElement commandsButton = $("ul#global-nav-1>li:nth-child(2)");

    private SelenideElement globalButton = $("ul#global-nav-1>li:nth-child(3)");

    private ElementsCollection listCommands = $$("li:nth-child(2)>ul>li");

    private ElementsCollection listGlobal = $$("li:nth-child(3)>ul>li");

    private SelenideElement loginedTab = $(By.xpath("//li[contains(@class,'menu-block-user')]/a"));

    private SelenideElement calendarButton = $("li>a[href*=scores]");

    private SelenideElement results = $(resultsLocator);

    private SelenideElement defaultVersion = $("span[data-ng-i18next*=\"editionLabel\"]");

    @Step("Waiting for input Search")
    public NBAPO inputValueToSearch(String value) {
        Waiter.fluentWait(inputSearchLocator, LocatorTypeEnum.CSS);
        inputSearch.setValue(value);
        return this;
    }

    @Step("Clicking on Search Button")
    public void clickSearchButton() {
        searchButon.click();
    }

    public void clickLoginButton() {
        loginButton.findBy(Condition.visible).click();
    }

    public SelenideElement getLogoHeader() {
        return logoHeader;
    }

    @Step("Clicking on Command Button")
    public void clickCommandsButton() {
        commandsButton.click();
    }

    public ElementsCollection getListCommands() {
        return listCommands;
    }

    public ElementsCollection getListGlobal() {
        return listGlobal;
    }

    @Step("Clicking on Global Button")
    public void clickGlobalButton() {
        globalButton.click();
    }

    @Step("Clicking on Callendar Button")
    public void clickCalendarBtn() {
        calendarButton.click();
    }

    public void clickDefaultBtn() {
        defaultVersion.click();
    }

    public boolean isLoginedTabDisplayed() {
        return loginedTab.isDisplayed();
    }

    public boolean isSearchResultAppear() {
        Waiter.fluentWait(resultsLocator, LocatorTypeEnum.CSS);
        return results.exists();
    }
}
