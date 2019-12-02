package com.epam.core2;

import io.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHttpResponse;

public class RestAppacheClient implements Client{

    public HttpResponse getRequest(){
        return new BasicHttpResponse(null);
    }
    public HttpResponse postRequest(){
        return new BasicHttpResponse(null);
    }
    public HttpResponse deleteRequest(String userName){
        return new BasicHttpResponse(null);
    }
}
