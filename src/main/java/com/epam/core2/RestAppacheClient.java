package com.epam.core2;

import ch.qos.logback.classic.Logger;
import com.google.common.collect.Lists;
import io.restassured.response.Response;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.openqa.selenium.logging.LogType;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RestAppacheClient implements Client {
    private List<Header> headers;
    private HttpClient httpClient;
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

    private void setBasicClientHeaders(String token) {
        this.headers = Lists.newArrayList(
                new BasicHeader(HttpHeaders.ACCEPT,"application/json"),
                new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"),
                new BasicHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token));
    }

    private void buildClient(){
        this.httpClient= HttpClients.custom().setDefaultHeaders(headers).build();
    }

    private HttpEntity createEntity(String payload) {
        HttpEntity httpEntity = null;
        try {
            httpEntity = new StringEntity(payload);
        } catch (UnsupportedEncodingException e) {
            logger.info("Couldn't create Entity " + e.getMessage());
        }
        return httpEntity;
    }


    @Override
    public Object getUsers() {
        return null;
    }

    @Override
    public Object createUser(String payload) {
        return null;
    }

    @Override
    public Object deleteUser(String userName) {
        return null;
    }
}
