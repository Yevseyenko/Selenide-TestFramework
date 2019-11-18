package com.epam;

import com.codeborne.selenide.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPO;
import page.NBAPageObject;
import testng.Listener;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.*;

//
@Listeners(Listener.class)
public class NBATest {
    private static final Logger log = LogManager.getLogger("log4j2");
    private LoginPO loginPO = new LoginPO();
    private NBAPageObject nbaPO = new NBAPageObject();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = SITE;
        Configuration.startMaximized = true;
    }

    @Test
    public void verifyTribunaNameTest() {
        //what is this? test should be understandable
        open("/");
        //asserts?
        nbaPO.getLogoHeader().shouldHave(Condition.matchesText(TEST_SITE_NAME));
    }

    @Test
    public void verifyCountOfCommands() {
        open("/");
        nbaPO.clickCommandsButton();
        //asserts?
        nbaPO.getListCommands().shouldHave(CollectionCondition.size(COUNT_COMMANDS));
    }

    @Test
    public void verifyGloablList() {
        open("/");
        nbaPO.clickGlobalButton();
        //asserts?
        nbaPO.getListGlobal().shouldHave(CollectionCondition.texts(VERIFY_GLOBAL_LIST));
    }

    @Test
    public void verifyLoginToSite() {
        open("/");
        nbaPO.clickLoginButton();
        //make this general, make different users
        loginPO.inputUserEmail(USER).inputPassword(PASS).clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test
    public void verifySerchBar() {
        open("/");
        try {
            nbaPO.inputValueToSearch(VERIFY_VALUE).clickSearchButton();
        } catch (InterruptedException e) {
            log.error("Element is not clickable");
        }
        //what if team does not play this week or gets out of nba?
        nbaPO.getDescription().shouldHave(Condition.exactText(VERIFY_TEAM));
    }
}
