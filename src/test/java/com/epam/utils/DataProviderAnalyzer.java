package com.epam.utils;

import com.epam.RestTest;
import com.epam.core2.models.User;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DataProviderAnalyzer {

    public static String getDataProviderName(String methodName) {
        Method method = null;
        try {
            if (methodName.contains("CSV")) {
                method = RestTest.class.getMethod(methodName, String.class);
            } else {
                method = RestTest.class.getMethod(methodName, User.class);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation annotation = method.getAnnotation(Test.class);
        Test t = (Test) annotation;
        return t.dataProviderClass().getSimpleName();
    }
}
