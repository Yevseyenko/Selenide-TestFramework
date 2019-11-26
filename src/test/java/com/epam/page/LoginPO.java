package com.epam.page;

import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class LoginPO {
    Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    private SelenideElement userNameInput = $(By.xpath("//div[@class='auth__form-row']//input[contains(@class,'email')]"));
    private SelenideElement userPassword = $(By.xpath("//div[@class='auth__form-row']//input[contains(@class,'auth__login-input i')]"));
    private SelenideElement buttonLogin = $(By.xpath("//div/button[contains(@class,'piwik')]"));

    public LoginPO inputUserEmail(String user) {
        userNameInput.setValue(user);
        return this;
    }

    public LoginPO inputPassword(String password) {
        userPassword.setValue(password);
        return this;
    }

    public void clickLogin() {

        buttonLogin.doubleClick();
    }
}


