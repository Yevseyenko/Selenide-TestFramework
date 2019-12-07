package com.epam;

import ch.qos.logback.classic.Logger;
import com.epam.bo.CalendarBO;
import com.epam.bo.LoginBO;
import com.epam.bo.NbaBO;
import com.epam.core.testng.Listener;
import com.epam.page.CalendarPO;
import com.epam.page.LoginPO;
import com.epam.page.NbaPO;
import com.epam.page.TribunaPO;
import com.epam.utils.LazyAssert;
import com.epam.utils.SelenideConfigurator;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.core.constants.Constants.*;

@Listeners({Listener.class, TestListenerAdapter.class})

public class NBATest {

    //todo fix unused var
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    private LoginBO loginBO = new LoginBO();
    private LoginPO loginPO = new LoginPO();
    private CalendarBO calendarBO = new CalendarBO();
    private CalendarPO calendarPO = new CalendarPO();
    private NbaPO nbaPO = new NbaPO();
    private NbaBO nbaBO = new NbaBO();
    private TribunaPO tribunaPO = new TribunaPO();
    private LazyAssert lazyAssert = new LazyAssert();

    @BeforeClass
    public void setup() {
        SelenideConfigurator.configure();
        tribunaPO.hoverBasketBtn().clickNbaBtn();
    }

    @Test(priority = 1, description = "Scenario with verifying name logo", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifyTribunaNameTest() {
        nbaPO.clickDefaultBtn();
        Assert.assertEquals(nbaBO.getLogoHeaderText(), TEST_SITE_NAME, "Logo headeers are not equal");
    }

    @Test(priority = 2, description = "Scenario with verifying count of commands")
    public void verifyCountOfCommands() {
        nbaPO.clickCommandsButton();
        Assert.assertEquals(nbaBO.getCommandListSize(), COUNT_COMMANDS, "Count of commands is not equal");
    }

    @Test(priority = 3, description = "Scenario with verifying Global list")
    public void verifyGloablList() {
        nbaPO.clickGlobalButton();
        Assert.assertEquals(nbaBO.getGlobalList(), VERIFY_GLOBAL_LIST, "Lists are not same");
    }

    @Test(enabled = false, description = "Scenario with login to site")
    public void verifyLoginToSite() {
        tribunaPO.hoverBasketBtn().clickNbaBtn();
        nbaPO.clickLoginButton();
        loginBO.loginUser(USEREMAIL, PASS);
        loginPO.clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test(priority = 4, description = "Scenario with verifying searching page", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }


    @Test(priority = 3, description = "Scenario with verifying calendar page")
    public void verifyCalendarButtonAndSendingMatchResults() {
        nbaPO.clickCalendarBtn();
        calendarPO.clickPreviousBtn();
        calendarBO.getScores();
        lazyAssert.assertTrue(calendarPO.isCalenadrBtnDisplayed(), "Calendar button isn't displayed");
        lazyAssert.assertTrue(calendarPO.isFinalTableDisplayed(), "Final table isn't displayed");
        lazyAssert.assertAll();
    }
}
