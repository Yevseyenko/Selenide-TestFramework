package com.epam.utils;

import com.epam.RestTest;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DataProviderAnalyzer {

    public static String getDataProviderName(String methodName) {
        Method method = null;
        try {
            method = RestTest.class.getMethod("deleteUserTest", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation annotation = method.getAnnotation(Test.class);
        Test t = (Test) annotation;
        return t.dataProviderClass().getSimpleName();
    }
}
