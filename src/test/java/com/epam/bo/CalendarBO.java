package com.epam.bo;

import ch.qos.logback.classic.Logger;
import com.epam.page.CalendarPO;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarBO {
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());
    CalendarPO calendarPO = new CalendarPO();

    public void getScores() {
        List<String> scoreList = calendarPO.getWinnerScoreList();
        List<String> winnerList = calendarPO.getWinnerNameList();
             Map<String, String> winnerMap = new HashMap<>();
        for (String winner : winnerList) {
            winnerMap.put(winner, scoreList.get(winnerList.indexOf(winner)));
        }
        logger.error(String.valueOf(winnerMap));
    }
}
