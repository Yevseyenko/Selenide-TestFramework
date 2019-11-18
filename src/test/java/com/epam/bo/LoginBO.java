package com.epam.bo;

import com.epam.page.LoginPO;

public class LoginBO {
    private LoginPO loginPO = new LoginPO();

    public void loginUser(String user, String password) {
        loginPO.inputUserEmail(user).inputPassword(password).clickLogin();
    }
}
