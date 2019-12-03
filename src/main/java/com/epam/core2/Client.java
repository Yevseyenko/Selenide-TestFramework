package com.epam.core2;



public interface Client<T> {
public T getUsers();
public T createUser(String payload);
public T deleteUser(String userName);
}
