package com.epam.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TribunaPO {

    private SelenideElement basketButton = $(By.xpath("//li[contains(@class,'nav')][6]/a[contains(@href,'bas')]"));

    private SelenideElement nbaBtn = $(By.xpath("//li[contains(@class,'nav')]/a[contains(@href,'nba/')]"));

    public TribunaPO hoverBasketBtn() {
        basketButton.hover();
        return this;
    }

    @Step("Clicking on NBA Button")
    public TribunaPO clickNbaBtn() {
        nbaBtn.click();
        return this;
    }
}
