package com.epam.bo;

import com.epam.page.NbaPO;

import java.util.List;

public class NbaBO {//very understandible name, in the best practices I feel it

    public NbaPO nbaPO = new NbaPO();

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
