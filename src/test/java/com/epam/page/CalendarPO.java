package com.epam.page;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.enums.LocatorTypeEnum;
import com.epam.utils.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarPO {
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    private SelenideElement previousDateBtn = $("div.quicklinks>i.icon-caret-left");
    private String winnerScoreLocator = "//img[@class=\"winner\"]/parent::td/parent::tr/td[@class=\"final-score\"]/span";
    private ElementsCollection winnerScore = $$(By.xpath(winnerScoreLocator));
    private ElementsCollection winnerName = $$(By.xpath("//img[@class=\"winner\"]/parent::td/parent::tr/td[@class=\"team-abbrv\"]/a"));

    @Step("Clicking on previous date button")
    public void clickPreviousBtn() {
        Waiter.fluentWait("div.quicklinks>i.icon-caret-left", LocatorTypeEnum.CSS);
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

}
