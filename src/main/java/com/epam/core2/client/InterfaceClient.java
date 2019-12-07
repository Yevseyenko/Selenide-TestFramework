package com.epam.core2.client;

import com.epam.core2.model.User;

public interface InterfaceClient<T> {
public int getUsersStatusCode();
public int getCreateUserStatusCode(User user);
public String getUserByFirstNameResponse(String userName);
public int getDeleteUserStatusCode(String user);
}
