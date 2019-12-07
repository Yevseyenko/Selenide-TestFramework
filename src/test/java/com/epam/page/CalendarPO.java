package com.epam.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.core.enums.LocatorTypeEnum;
import com.epam.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarPO {
    private SelenideElement previousDateBtn = $("div.quicklinks>i.icon-caret-left");
    private String previousBtnLocator = "div.quicklinks>i.icon-caret-left";
    private String winnerScoreLocator = "//img[@class=\"winner\"]/parent::td/parent::tr/td[@class=\"final-score\"]/span";
    private ElementsCollection winnerScore = $$(By.xpath(winnerScoreLocator));
    private ElementsCollection winnerName = $$(By.xpath("//img[@class=\"winner\"]/parent::td/parent::tr/td[@class=\"team-abbrv\"]/a"));
    private SelenideElement calendarBtn = $("a.calendar-button");
    private SelenideElement tableWinner = $("div.final-game-table-wrapper");

    @Step("Clicking on previous date button")
    public void clickPreviousBtn() {
        Waiter.fluentWait(previousBtnLocator, LocatorTypeEnum.CSS);
        previousDateBtn.click();
    }

    @Step("Getting winner score list")
    public List<String> getWinnerScoreList() {
        Waiter.fluentWait(winnerScoreLocator, LocatorTypeEnum.XPATH);
        return winnerScore.texts();
    }

    @Step("Getting winner name list")
    public List<String> getWinnerNameList() {
        return winnerName.texts();
    }

    public boolean isCalenadrBtnDisplayed() {
        return calendarBtn.isDisplayed();
    }

    public boolean isFinalTableDisplayed() {
        return tableWinner.isDisplayed();
    }
}
