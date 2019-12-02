package com.epam.core2;



public interface Client<T> {
public T getRequest();
public T postRequest();
public T deleteRequest(String userName);
}
