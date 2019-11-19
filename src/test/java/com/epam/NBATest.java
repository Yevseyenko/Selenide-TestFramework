package com.epam;

import com.codeborne.selenide.*;
import com.epam.bo.LoginBO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.page.NBAPageObject;
import testng.Listener;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.*;

@Listeners(Listener.class)

public class NBATest {
    private static final Logger log = LogManager.getLogger("log4j2");
    private LoginBO loginBO = new LoginBO();
    private NBAPageObject nbaPO = new NBAPageObject();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = SITE;
        Configuration.startMaximized = true;
        open(PATH_NBA);
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
        loginBO.loginUser(USER,PASS);
         Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }
}
