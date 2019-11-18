package com.epam.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPO {
//todo fix url
    private SelenideElement userNameInput = $(By.xpath("//div[1]/div/form/div[2]/label/input"));
    //todo fix url
    private SelenideElement userPassword = $(By.xpath("//div[1]/div/form/div[3]/label/input"));
    //todo fix url
    private SelenideElement buttonLogin = $("form>div:nth-child(6) button");

    public LoginPO inputUserEmail(String user) {
        userNameInput.setValue(user);
        return this;
    }

    public LoginPO inputPassword(String password) {
        userPassword.setValue(password);
        return this;
    }

    public void clickLogin() {
        buttonLogin.click();
    }
}


