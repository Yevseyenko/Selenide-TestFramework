package com.epam.core2;

import ch.qos.logback.classic.Logger;
import com.epam.core2.utils.Propertiator;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class RestAppacheClient implements InterfaceClient {
    private List<Header> headers;
    private HttpClient httpClient;
    Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

    private void setBasicClientHeaders(String token) {
        this.headers = Lists.newArrayList(
                new BasicHeader(HttpHeaders.ACCEPT, "application/json"),
                new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"),
                new BasicHeader("Authorization", "Bearer " + token));
    }

    private void buildClient() {
        this.httpClient = HttpClients.custom().setDefaultHeaders(headers).build();
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

    public HttpResponse get() {
        setBasicClientHeaders(Propertiator.getTokenDomain());
        buildClient();
        HttpResponse httpResponse = null;
        HttpGet httpGet = new HttpGet(EndPoints.domain+EndPoints.users);
        try {
             httpResponse= httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static void main(String[] args) throws IOException {
        RestAppacheClient restAppacheClient = new RestAppacheClient();
        System.out.println(restAppacheClient.get().getEntity().toString());
        BufferedReader rd = new BufferedReader(new InputStreamReader(restAppacheClient.get().getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            line+=line;
        }
        System.out.println(line);
    }


    @Override
    public String getUsersStatusCode() {
        return null;
    }

    @Override
    public String getCreateUserStatusCode(String payload) {
        return null;
    }

    @Override
    public String getUserByFirstNameStatusCode(String userName) {
        return null;
    }

    @Override
    public String getDeleteUserStatusCode(String userName) {
        return null;
    }
}
