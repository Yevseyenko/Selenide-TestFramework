package com.epam.core2;

import com.epam.core2.model.User;

public interface InterfaceClient<T> {
public String getUsersStatusCode();
public int getCreateUserStatusCode(User user);
public String getUserByFirstNameStatusCode(String userName);
public String getDeleteUserStatusCode(String userName);
}
