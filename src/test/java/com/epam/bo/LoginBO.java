package com.epam.bo;

import com.epam.NBATest;
import com.epam.page.LoginPO;
import com.epam.utils.Utils;

public class LoginBO {

    private LoginPO loginPO = new LoginPO();

    public void loginUser(String user, char[] password, NBATest claz) {
        loginPO.inputUserEmail(user).inputPassword(Utils.getPassword(password));
    }
}
