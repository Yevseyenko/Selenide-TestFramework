package com.epam;

import ch.qos.logback.core.net.server.Client;
import com.epam.core2.ClientGenerator;
import com.epam.core2.InterfaceClient;
import com.epam.core2.RestAssuredClient;
import com.epam.core2.model.User;
import com.epam.core2.utils.NameDataProvider;
import com.epam.core2.utils.UserDataProvider;
import com.epam.utils.Definer;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTest {

    @Test
    public void responcnseCodeTest() {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Assert.assertEquals(restAssuredClient.getUsersStatusCode(), "200", "Request failed");
    }

    @Test(dataProvider = "userNames", dataProviderClass = NameDataProvider.class)
    public void getUserByName(String user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("getUserByName"));
        Assert.assertTrue(client.getUserByFirstNameResponse(user).contains("200"), "Request failed");
    }


    @Test(priority = 4, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUserTest(User user) {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.createUser(user.getFirst_name(), user.getLast_name(), user.getGender(), user.getEmail());
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed ");
    }

    @Test(priority = 1, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUsersTest(User user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getCreateUserStatusCode(user), 200, "Request failed ");
    }

    @Test(priority = 2, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void getUsersByNameTest(User user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertTrue(client.getUserByFirstNameResponse(user.getFirst_name()).contains(user.getFirst_name()), "Request failed ");
    }

    @Test(priority = 3, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void deleteUserTest(User user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getDeleteUserStatusCode(user.getFirst_name()), 200, "Request failed");
    }

    @Test(priority = 5, dataProvider = "userNames", dataProviderClass = NameDataProvider.class)
    public void deleteUserTest(String user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getDeleteUserStatusCode(user), 200, "Request failed");
    }
}
