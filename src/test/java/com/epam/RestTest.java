package com.epam;

import com.epam.core2.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.core.constants.Constants.*;

public class RestTest {
    @Test
    public void responcnseCodeTest() {
        RestClient restClient = new RestClient();
        Response rs = restClient.getUsers();
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed");
    }

    @Test
    public void createUserTest() {
        RestClient restClient = new RestClient();
        Response rs = restClient.createUser(USERNAME, SURNAME, GENDER, USEREMAIL);
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed ");
        Assert.assertTrue(rs.then().extract().body().toString().contains(USERNAME), "User is created");
    }

    @Test
    public void deleteUserTest() {
        RestClient restClient = new RestClient();
        Response rs = restClient.deleteUser(USERNAME);
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed");
    }
}
