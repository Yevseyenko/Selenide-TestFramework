package com.epam.bo;

import com.epam.page.NbaPO;

import java.util.List;

public class NbaBO {

    public NbaPO nbaPO;

    public NbaBO() {
        nbaPO = new NbaPO();
    }

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
