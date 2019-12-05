package com.epam.core2;

public interface InterfaceClient<T> {
public String getUsersStatusCode();
public String getCreateUserStatusCode(String payload);
public String getUserByFirstNameStatusCode(String userName);
public String getDeleteUserStatusCode(String userName);
}
