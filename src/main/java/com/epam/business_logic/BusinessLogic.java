package com.epam.business_logic;

import ch.qos.logback.classic.Logger;
import com.epam.core2.models.ResponseModel;
import com.epam.core2.utils.JsonUtils;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessLogic {
    private static Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(BusinessLogic.class);

    public static List<String> getFromResponseUserFirstName(String jsonString) {
        return getResponseModel(jsonString).getResult().stream().map(x->x.getFirstName()).collect(Collectors.toList());
    }

    public static List<String> getFromResponseUserLastName(String jsonString) {
        return getResponseModel(jsonString).getResult().stream().map(x->x.getLastName()).collect(Collectors.toList());
    }

    public static List<String> getFromResponseUserEmail(String jsonString) {
        return  getResponseModel(jsonString).getResult().stream().map(x->x.getEmail()).collect(Collectors.toList());

    }

    private static ResponseModel getResponseModel(String jsonString) {
        ResponseModel responseModel = null;
        try {
            responseModel = JsonUtils.fromJsonString(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Couldn't convert jsonString to model");
        }
        Assert.assertFalse(responseModel == null, "Response is empty");
        return responseModel;
    }
}
