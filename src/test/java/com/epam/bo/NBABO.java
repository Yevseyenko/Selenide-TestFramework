package com.epam.bo;

import com.epam.page.NBAPO;

import java.util.List;

public class NBABO {
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
