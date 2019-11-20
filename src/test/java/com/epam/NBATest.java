package com.epam;

import com.codeborne.selenide.*;
import com.epam.bo.LoginBO;
import com.epam.page.LoginPO;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.page.NBAPageObject;
import testng.Listener;
import testng.WebDriverListener;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static constants.Constants.*;

@Listeners(Listener.class)

public class NBATest {
    private LoginBO loginBO = new LoginBO();
    private LoginPO loginPO = new LoginPO();
    private NBAPageObject nbaPO = new NBAPageObject();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = SITE;
        Configuration.startMaximized = true;
        open(PATH_NBA);
        EventFiringWebDriver driver = new EventFiringWebDriver(getWebDriver());
        driver.register(new WebDriverListener());
    }

    @Test
    public void verifyTribunaNameTest() {
        Assert.assertEquals(nbaPO.getLogoHeader().getText(), TEST_SITE_NAME, "Logo headeers are not equal");
    }

    @Test
    public void verifyCountOfCommands() {
        nbaPO.clickCommandsButton();
        Assert.assertEquals(nbaPO.getListCommands().texts().size(), COUNT_COMMANDS, "Count of commands is not equal");
    }

    @Test
    public void verifyGloablList() {
        nbaPO.clickGlobalButton();
        Assert.assertEquals(nbaPO.getListGlobal().texts(), VERIFY_GLOBAL_LIST, "Lists are not same");
    }

    @Test
    public void verifyLoginToSite() {
        nbaPO.clickLoginButton();
        loginBO.loginUser(USER, PASS);
        loginPO.clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }
}
