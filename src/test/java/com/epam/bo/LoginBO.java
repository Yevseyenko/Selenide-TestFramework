package com.epam.bo;

import ch.qos.logback.classic.Logger;
import com.epam.page.LoginPO;
import com.epam.utils.Utils;
import org.slf4j.LoggerFactory;

public class LoginBO {
    //again

    Logger logger =
            (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.epam.page");
    private LoginPO loginPO = new LoginPO();

    public void loginUser(String user, char[] password) {
        loginPO.inputUserEmail(user).inputPassword(Utils.getPassword(password));
    }
}
