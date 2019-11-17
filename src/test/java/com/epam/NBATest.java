package com.epam;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.Listener;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.*;

@Listeners(Listener.class)
public class NBATest {

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = SITE;
        Configuration.startMaximized = true;
    }

    @Test
    public void verifyTribunaNameTest() {
        open("/");
        $("header>div>a:first-child").shouldHave(Condition.matchesText(TEST_SITE_NAME));
    }

    @Test
    public void verifyCountOfCommands() {
        open("/");
        $("ul#global-nav-1>li:nth-child(2)").click();
        $$("ul#global-nav-1>li:nth-child(2)>ul>li").shouldHave(CollectionCondition.size(COUNT_COMMANDS));
    }

    @Test
    public void verifyGloablList() {
        open("/");
        $("ul#global-nav-1>li:nth-child(3)").click();
        $$("ul#global-nav-1>li:nth-child(3)>ul>li").shouldHave(CollectionCondition.texts(VERIFY_GLOBAL_LIST));

    }

    @Test
    public void verifyLoginToSite() {
        open("/");
        $$("li.user-panel__menu-block-item:first-child").findBy(Condition.visible).click();
        $(By.xpath("//div[1]/div/form/div[2]/label/input")).setValue("surfakeemail@gmail.com");
        $(By.xpath("//div[1]/div/form/div[3]/label/input")).setValue("qazwsx159");
        $("form>div:nth-child(6) button").click();
        SelenideElement tab = $$(By.xpath("//div[4]/div/div/div/ul")).findBy(Condition.appear);
        Assert.assertTrue(tab.isDisplayed(), "User is logged");
    }

    @Test
    public void verifySerchBar() {
        open("/");
        $("div.sportsru.sportsru--d>header>div>div>div>form>input").setValue("Atlanta");
        $("form.search-block__form~ul>li:nth-child(1)>a").click();
        $("div.short-info>div.descr").shouldHave(Condition.exactText("Atlanta Hawks"));
    }
}
