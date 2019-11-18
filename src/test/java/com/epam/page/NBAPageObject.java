package com.epam.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NBAPageObject {
    //todo fix url, I bet you can locate any element with 1, maximum 2 nodes
    private SelenideElement logoHeader = $("header>div>a:first-child");

    private SelenideElement inputSearch = $("div.sportsru.sportsru--d>header>div>div>div>form>input");

    private SelenideElement searchButon = $("form.search-block__form~ul>li:nth-child(1)>a");

    private SelenideElement description = $("div.short-info>div.descr");

    private ElementsCollection loginButton = $$("li.user-panel__menu-block-item:first-child");

    private SelenideElement commandsButton = $("ul#global-nav-1>li:nth-child(2)");

    private SelenideElement globalButton = $("ul#global-nav-1>li:nth-child(3)");

    private ElementsCollection listCommands = $$("ul#global-nav-1>li:nth-child(2)>ul>li");

    private ElementsCollection listGlobal = $$("ul#global-nav-1>li:nth-child(3)>ul>li");

    private ElementsCollection loginedTab = $$(By.xpath("//div[4]/div/div/div/ul"));

    private SelenideElement results = $("div.search-result");

    private SelenideElement basketballBtn = $("ul.nav-list>li:nth-child(3)");

    public NBAPageObject inputValueToSearch(String value) throws InterruptedException {
        //this
        wait(1000);
        //the above code
        inputSearch.setValue(value);
        return this;
    }

    public void clickSearchButton() {
        searchButon.click();
    }

    public SelenideElement getDescription() {
        return description;
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
        return loginedTab.findBy(Condition.appear).isDisplayed();
    }
}
