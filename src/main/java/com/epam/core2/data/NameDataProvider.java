package com.epam.core2.data;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NameDataProvider {
    static List<String> readCSV() {
        String fileName = System.getProperty("user.dir") + "/src/main/resources/UserListTest.csv";
        List<String> stringList = null;
        try {
            stringList = Files.lines(Paths.get(String.format(fileName))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    @org.testng.annotations.DataProvider
    public Object[][] userNames() {
        List<String> listString = readCSV();
        Object[][] objArray = new Object[listString.size()][];
        for (int i = 0; i < listString.size(); i++) {
            objArray[i] = new Object[1];
            objArray[i][0] = listString.get(i);
        }
        return objArray;
    }

}
