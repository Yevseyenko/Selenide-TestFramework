package com.epam.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPO {

    private SelenideElement userNameInput = $(By.xpath("//div[@class='auth__form-row']//input[contains(@class,'auth__login-input a')]"));
    private SelenideElement userPassword = $(By.xpath("//div[@class='auth__form-row']//input[contains(@class,'auth__login-input i')]"));
    private SelenideElement buttonLogin = $(By.xpath("//div[@class='auth__form-row']/button[contains(@class,'p')]"));
//    private SelenideElement buttonLogin = $("form>div:nth-child(6) button");
    public LoginPO inputUserEmail(String user) {
        userNameInput.setValue(user);
        return this;
    }

    public LoginPO inputPassword(String password) {
        userPassword.setValue(password);
        return this;
    }

    public void clickLogin() {
        buttonLogin.should(Condition.appear).click();
    }
}


