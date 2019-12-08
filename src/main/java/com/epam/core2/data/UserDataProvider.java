package com.epam.core2.data;

import com.epam.core2.models.User;
import com.paypal.selion.platform.dataprovider.DataProviderFactory;
import com.paypal.selion.platform.dataprovider.DataResource;
import com.paypal.selion.platform.dataprovider.SeLionDataProvider;
import com.paypal.selion.platform.dataprovider.impl.InputStreamResource;

import java.io.FileInputStream;
import java.io.IOException;

public class UserDataProvider {
    @org.testng.annotations.DataProvider
    public Object[][] jsonDataProvider() throws IOException {
        DataResource resource =
                new InputStreamResource(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/otherUsers.json"),
                        User.class, "json");
        SeLionDataProvider dataProvider =
                DataProviderFactory.getDataProvider(resource);
        Object[][] data = dataProvider.getAllData();
        return data;
    }
}
