package com.epam;

import com.epam.core2.ClientGenerator;
import com.epam.core2.InterfaceClient;
import com.epam.core2.RestAssuredClient;
import com.epam.core2.utils.NameDataProvider;
import com.epam.utils.Definer;
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

    @Test(dataProvider = "searchWords", dataProviderClass = NameDataProvider.class)
    public void deleteUserTest(String user) throws NoSuchFieldException, NoSuchMethodException {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        client.getDeleteUserStatusCode(user);
        Assert.assertEquals(client.getDeleteUserStatusCode(user), "400", "Request failed");
    }
}
