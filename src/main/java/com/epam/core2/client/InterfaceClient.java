package com.epam.core2.client;

import com.epam.core2.models.User;

public interface InterfaceClient<T> {
    String getUsersResponse();

    int getUsersStatusCode();

    int getCreateUserStatusCode(User user);

    String getUserByFirstNameResponse(String userName);

    int getDeleteUserStatusCode(String user);
}
