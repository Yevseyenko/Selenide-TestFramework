package com.epam.core2.client;

import ch.qos.logback.classic.Logger;
import com.epam.core2.constants.EndPoints;
import com.epam.core2.models.User;
import com.epam.core2.utils.Propertiator;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.epam.core2.constants.Constants.FIRST_NAME_PARAMETER;

public class RestApacheClient implements InterfaceClient {
    private List<Header> headers;
    private HttpClient httpClient;
    private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(this.getClass());

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
            logger.error("Couldn't create Entity " + e.getMessage());
        }
        return httpEntity;
    }

    private HttpResponse get() {
        HttpResponse httpResponse = null;
        setBasicClientHeaders(Propertiator.getTokenDomain());
        buildClient();
        HttpGet httpGet = new HttpGet(EndPoints.users);
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    private HttpResponse post(String payload) {
        setBasicClientHeaders(Propertiator.getTokenDomain());
        buildClient();
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(EndPoints.users);
        httpPost.setEntity(createEntity(payload));
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    private HttpDelete basicDelete(String user) {
        return new HttpDelete(EndPoints.users + FIRST_NAME_PARAMETER + user);
    }

    private HttpResponse delete(String user) {
        setBasicClientHeaders(Propertiator.getTokenDomain());
        buildClient();
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(basicDelete(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    private HttpResponse getByUserName(String name) {
        setBasicClientHeaders(Propertiator.getTokenDomain());
        buildClient();
        HttpResponse httpResponse = null;
        HttpGet httpGet = new HttpGet(EndPoints.users + FIRST_NAME_PARAMETER + name);
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public String getContent(HttpResponse response) {
        String content = "";
        try {
            content = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public int getUsersStatusCode() {
        return get().getStatusLine().getStatusCode();
    }

    @Override
    public int getCreateUserStatusCode(User user) {
        Gson gson = new Gson();
        return post(gson.toJson(user)).getStatusLine().getStatusCode();
    }

    @Override
    public String getUserByFirstNameResponse(String userName) {
        return getContent(getByUserName(userName));
    }

    @Override
    public int getDeleteUserStatusCode(String user) {
        return delete(user).getStatusLine().getStatusCode();
    }
}
