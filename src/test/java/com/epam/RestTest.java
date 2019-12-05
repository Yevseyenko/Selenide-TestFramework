package com.epam;

import com.epam.core2.ClientGenerator;
import com.epam.core2.InterfaceClient;
import com.epam.core2.RestAssuredClient;
import com.epam.core2.model.User;
import com.epam.core2.utils.NameDataProvider;
import com.epam.core2.utils.UserDataProvider;
import com.epam.utils.Definer;
import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.InputStreamResource;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static com.epam.core.constants.Constants.*;

public class RestTest {


    @Test
    public void responcnseCodeTest() {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Assert.assertEquals(restAssuredClient.getUsersStatusCode(), "200", "Request failed");
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUserTest(User user) {
        RestAssuredClient restAssuredClient = new RestAssuredClient();
        Response rs = restAssuredClient.createUser(user.getFirst_name(), user.getLast_name(), user.getGender(), user.getEmail());
        Assert.assertEquals(rs.then().extract().statusCode(), 200, "Request failed ");
    }

    @Test(dataProvider = "jsonDataProvider", dataProviderClass = UserDataProvider.class)
    public void createUsersTest(User user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getCreateUserStatusCode(user), 200, "Request failed ");
    }


    @Test(dataProvider = "userNames", dataProviderClass = NameDataProvider.class)
    public void deleteUserTest(String user) {
        InterfaceClient client = ClientGenerator.getClient(Definer.getDataProviderName("deleteUserTest"));
        Assert.assertEquals(client.getDeleteUserStatusCode(user), "200", "Request failed");
    }
}
