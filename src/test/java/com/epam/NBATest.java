package com.epam;

import ch.qos.logback.classic.Logger;
import com.epam.bo.CalendarBO;
import com.epam.bo.LoginBO;
import com.epam.page.CalendarPO;
import com.epam.page.LoginPO;
import com.epam.page.TribunaPO;
import com.epam.utils.SelenideConfigurator;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.page.NBAPO;
import testng.Listener;


import static constants.Constants.*;

@Listeners(Listener.class)

public class NBATest {
    Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
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

    @Test(description = "Scenario with verifying name logo")
    public void verifyTribunaNameTest() {
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

    @Test(priority = 2, enabled = false, description = "Scenario with login to site")
    public void verifyLoginToSite() {
        tribunaPO.hoverBasketBtn().clickNbaBtn();
        nbaPO.clickLoginButton();
        loginBO.loginUser(USER, PASS);
        loginPO.clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test(priority = 1,description = "Scenario with verifying searching page")
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }

    @Test
    public void verifyMatchResults() {
        nbaPO.clickCalendarBtn();
        calendarPO.clickPreviousBtn();
        calendarBO.getScores();
    }
}
