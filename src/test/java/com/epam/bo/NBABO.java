package com.epam.bo;

import com.epam.page.NBAPO;

import java.util.List;

public class NBABO {//very understandible name, in the best practices I feel it
    //default modifier
    NBAPO nbaPO = new NBAPO();

    public String getLogoHeaderText() {
        return nbaPO.getLogoHeader().getText();
    }

    public int getCommandListSize() {
        return nbaPO.getListCommands().texts().size();
    }

    public List<String> getGlobalList() {
        return nbaPO.getListGlobal().texts();
    }
}
