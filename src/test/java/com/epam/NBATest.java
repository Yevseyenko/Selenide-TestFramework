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
import com.epam.utils.SelenideConfigurator;
import com.epam.utils.Validation;
import org.slf4j.LoggerFactory;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.epam.core.constants.Constants.PASS;
import static com.epam.core.constants.Constants.USEREMAIL;

@Listeners({Listener.class, TestListenerAdapter.class})

public class NBATest {

    private LoginBO loginBO = new LoginBO();
    private LoginPO loginPO = new LoginPO();
    private CalendarBO calendarBO = new CalendarBO();
    private CalendarPO calendarPO = new CalendarPO();
    private NbaPO nbaPO = new NbaPO();
    private NbaBO nbaBO = new NbaBO();
    private TribunaPO tribunaPO = new TribunaPO();

    @BeforeClass
    public void setup() {
        SelenideConfigurator.configure();
        tribunaPO.hoverBasketBtn().clickNbaBtn();
    }

    @Test(priority = 1, description = "Scenario with verifying name logo", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifyTribunaNameTest() {
        nbaPO.clickDefaultBtn();
        Validation.validateLogoHeader(nbaBO.getLogoHeaderText());
    }

    @Test(priority = 2, description = "Scenario with verifying count of commands")
    public void verifyCountOfCommands() {
        nbaPO.clickCommandsButton();
        Validation.validateCommandListSize(nbaBO.getCommandListSize());
    }

    @Test(priority = 3, description = "Scenario with verifying Global list")
    public void verifyGloablList() {
        nbaPO.clickGlobalButton();
        Validation.validateGlobalList(nbaBO.getGlobalList());
    }

    @Test(enabled = false, description = "Scenario with login to site")
    public void verifyLoginToSite() {
        tribunaPO.hoverBasketBtn().clickNbaBtn();
        nbaPO.clickLoginButton();
        loginBO.loginUser(USEREMAIL, PASS);
        loginPO.clickLogin();
        Validation.validateLoginPage(nbaPO.isLoginedTabDisplayed());
    }

    @Test(priority = 4, description = "Scenario with verifying searching page", retryAnalyzer = com.epam.utils.RetryAnalyzer.class)
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Validation.validateSearchResult(nbaPO.isSearchResultAppear());
    }


    @Test(priority = 3, description = "Scenario with verifying calendar page")
    public void verifyCalendarButtonAndSendingMatchResults() {
        nbaPO.clickCalendarBtn();
        calendarPO.clickPreviousBtn();
        calendarBO.getScores();
        Validation.validateCalendarIsDisplayed(calendarPO.isCalenadrBtnDisplayed(), calendarPO.isFinalTableDisplayed());
    }
}
