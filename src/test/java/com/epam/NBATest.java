package com.epam;

import com.epam.bo.LoginBO;
import com.epam.page.LoginPO;
import com.epam.page.TribunaPO;
import com.epam.utils.SelenideConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.epam.page.NBAPO;
import testng.Listener;

import static constants.Constants.*;

@Listeners(Listener.class)

public class NBATest {
    private LoginBO loginBO = new LoginBO();
    private LoginPO loginPO = new LoginPO();
    private NBAPO nbaPO = new NBAPO();
    private TribunaPO tribunaPO = new TribunaPO();

    @BeforeClass
    public void setup() {
        SelenideConfigurator.configure();
        tribunaPO.hoverBasketBtn().clickNbaBtn();
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

    @Test(priority = 2)
    public void verifyLoginToSite() {
        tribunaPO.hoverBasketBtn().clickNbaBtn();
        nbaPO.clickLoginButton();
        loginBO.loginUser(USER, PASS);
        loginPO.clickLogin();
        Assert.assertTrue(nbaPO.isLoginedTabDisplayed(), "User is logged");
    }

    @Test(priority = 1)
    public void verifySearchResults() {
        nbaPO.inputValueToSearch("").clickSearchButton();
        Assert.assertTrue(nbaPO.isSearchResultAppear(), "Search result page doesn't appear");
    }
}
