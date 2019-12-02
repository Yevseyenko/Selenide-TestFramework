package com.epam;

import com.epam.core2.RestAssuredClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.core.constants.Constants.*;

public class RestTest {
    @Test
    public void responcnseCodeTest() {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.getUsers();
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed");
    }

    @Test
    public void createUserTest() {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.createUser(USERNAME, SURNAME, GENDER, USEREMAIL);
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed ");
        Assert.assertTrue(rs.then().extract().body().toString().contains(USERNAME), "User is created");
    }

    @Test
    public void deleteUserTest() {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.deleteUser(USERNAME);
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed");
    }
}
