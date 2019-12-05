package com.epam.core2.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class NameDataProvider {
    static List<String> readCSV(String testName) {
        String fileName = System.getProperty("user.dir") + "/src/main/resources/%s.csv";
        List<String> stringList = null;
        try {
            stringList = Files.lines(Paths.get(String.format(fileName, testName))).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    private static Object[][] generateDimensionArray(String testName) {
        List<String> listString = readCSV(testName);
        Object[][] objArray = new Object[listString.size()][];
        for (int i = 0; i < listString.size(); i++) {
            objArray[i] = new Object[1];
            objArray[i][0] = listString.get(i);
        }
        return objArray;
    }

    @org.testng.annotations.DataProvider
    public static Object[][] userNames(Method method) {
        return generateDimensionArray(method.getName());
    }
}
