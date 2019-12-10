package com.epam;

import com.epam.core2.BusinessLogic;
import com.epam.core2.client.ClientResolver;
import com.epam.core2.client.InterfaceClient;
import com.epam.core2.client.RestAssuredClient;
import com.epam.core2.data.NameDataProvider;
import com.epam.core2.data.UserDataProvider;
import com.epam.core2.models.User;
import com.epam.utils.DataProviderAnalyzer;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestTest {

    @Test(description = "Verifying status code scenario")
    public void responseCodeTest() {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("responseCodeTest"));
        Assert.assertEquals(client.getUsersStatusCode(), 200, "Request failed");
    }

    @Test(dataProvider = "userNames", description = "Verifying user name scenario", dataProviderClass = NameDataProvider.class)
    public void getUserByNameFromCSV(String user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("getUserByNameFromCSV"));
        String response = client.getUserByFirstNameResponse(user);
        Assert.assertTrue(response.contains(user), "Request failed");
    }

    @Test(priority = 4, description = "Verifying status code scenario", dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUserTest(User user) {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.createUser(user.getFirst_name(), user.getLast_name(), user.getGender(), user.getEmail());
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed ");
    }

    @Test(priority = 2, description = "Verifying user email scenario", dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void verifyUserEmail(User user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("verifyUserEmail"));
        String response = client.getUserByFirstNameResponse(user.getFirst_name());
        Assert.assertTrue(BusinessLogic.getFromResponseUserEmail(response).contains(user.getEmail()), "Emails are not equal");
    }

    @Test(priority = 1, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUsersTest(User user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("createUsersTest"));
        Assert.assertEquals(client.getCreateUserStatusCode(user), 200, "Request failed ");
    }

    @Test(priority = 2, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void getUsersByNameTest(User user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("getUsersByNameTest"));
        String response = client.getUserByFirstNameResponse(user.getFirst_name());
        Assert.assertTrue(BusinessLogic.getFromResponseUserFirstName(response).contains(user.getFirst_name()), "Request failed ");
    }

    @Test(priority = 2, dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void getUsersByLastNameTest(User user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("getUsersByLastNameTest"));
        String response = client.getUserByFirstNameResponse(user.getFirst_name());
            Assert.assertTrue(BusinessLogic.getFromResponseUserFirstName(response).contains(user.getLast_name()), "Request failed ");
    }

    @Test(priority = 3, description = "Verifying delete user", dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void deleteUserTest(User user) {
        InterfaceClient client = ClientResolver.getClient(DataProviderAnalyzer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getDeleteUserStatusCode(user.getFirst_name()), 200, "Request failed");
    }
}
