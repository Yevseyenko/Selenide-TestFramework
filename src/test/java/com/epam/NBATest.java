package com.epam;

import ch.qos.logback.classic.Logger;
import com.epam.bo.CalendarBO;
import com.epam.bo.LoginBO;
import com.epam.page.CalendarPO;
import com.epam.page.LoginPO;
import com.epam.page.TribunaPO;
import com.epam.utils.SelenideConfigurator;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.page.NBAPO;
import testng.Listener;


import static constants.Constants.*;

@Listeners({Listener.class, TestListenerAdapter.class})

public class NBATest {
    private LoginBO loginBO = new LoginBO();
    private LoginPO loginPO = new LoginPO();
    private CalendarBO calendarBO = new CalendarBO();
    private CalendarPO calendarPO = new CalendarPO();
    private NBAPO nbaPO = new NBAPO();
    private TribunaPO tribunaPO = new TribunaPO();

    @BeforeClass
    public void setup() {
        SelenideConfigurator.configure();
        tribunaPO.hoverBasketBtn().clickNbaBtn();
    }

    @Test(priority = 1,enabled = false, description = "Scenario with verifying name logo", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifyTribunaNameTest() {
        nbaPO.hoverDefault();
        Assert.assertEquals(nbaPO.getLogoHeader().getText(), TEST_SITE_NAME, "Logo headeers are not equal");
    }

    @Test(description = "Scenario with verifying count of commands")
    public void verifyCountOfCommands() {
        nbaPO.clickCommandsButton();
        Assert.assertEquals(nbaPO.getListCommands().texts().size(), COUNT_COMMANDS, "Count of commands is not equal");
    }

    @Test(description = "Scenario with verifying Global list")
    public void verifyGloablList() {
        nbaPO.clickGlobalButton();
        Assert.assertEquals(nbaPO.getListGlobal().texts(), VERIFY_GLOBAL_LIST, "Lists are not same");
    }

    @Test(enabled = false, description = "Scenario with login to site")
    public void verifyLoginToSite() {
        tribunaPO.hoverBasketBtn().clickNbaBtn();
        nbaPO.clickLoginButton();
        loginBO.loginUser(USER, PASS);
        loginPO.clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test(priority = 2, description = "Scenario with verifying searching page", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }


    @Test(description = "Scenario with verifying calendar page")
    public void verifyCalendarButtonAndSendingMatchResults() {
        nbaPO.clickCalendarBtn();
        calendarPO.clickPreviousBtn();
        calendarBO.getScores();
        Assert.assertTrue(calendarPO.isCalenadrBtnDisplayed(), "Calendar button isn't displayed");
        Assert.assertTrue(calendarPO.isFinalTableDisplayed(), "Final table isn't displayed");
    }
}
